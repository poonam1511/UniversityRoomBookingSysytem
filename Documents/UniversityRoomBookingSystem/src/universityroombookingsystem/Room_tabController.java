/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.MyUtils;
import OS.bean.room_detail;
import OS.dao.RoomDao;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Room_tabController implements Initializable {
static String sc = "id";
    static String si = "";
    @FXML
    private TextField txtSi;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;
    @FXML
    private TableView<?> tblList;
    @FXML
    private ComboBox<?> cmbSc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         MyUtils.populateColumnNames(cmbSc, "room_detail");
        MyUtils.selectComboBoxValue(cmbSc, sc);
        txtSi.setText(si);
        populate();
    }    
    
    public void populate() {
        LinkedList<room_detail> res = RoomDao.search(cmbSc.getValue().toString(), txtSi.getText());
        MyUtils.populateTable(tblList, res, room_detail.class);
    }

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnAdd){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("AddRoom.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
        
         else if(event.getSource()==btnDelete){
            String id = MyUtils.getSelColValue("id", tblList);
            if (id == null) {
                JOptionPane.showMessageDialog(null, "Please select a row!");
                return;
            }
            
            int ch = JOptionPane.showConfirmDialog(null, "R u sure, you want to delete!");
            if(ch!=JOptionPane.YES_OPTION){
                return;                
            }
            RoomDao.delete(id);
            JOptionPane.showMessageDialog(null, "deleted!");
            populate();            
        }
        
        
         else if (event.getSource() == btnUpdate) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
                else{
                   UpdateRoomController.id = id;
                Parent root = FXMLLoader.load(getClass().getResource("UpdateRoom.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                }
                
               } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        
         
         
         
         
         
         
         
        
        
         else   if(event.getSource()==btnBack){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("Booking_tab.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            
        }
        
        
        
    }

    @FXML
    private void cc(ActionEvent event) {
        sc = cmbSc.getValue().toString();
        populate();
    }

    @FXML
    private void kr(KeyEvent event) {
        si = txtSi.getText();
        populate(); 
    }
    
    
}
