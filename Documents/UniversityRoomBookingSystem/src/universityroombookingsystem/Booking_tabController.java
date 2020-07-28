/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.MyUtils;
import OS.bean.booking_detail;
import OS.bean.room_detail;
import OS.dao.BookDao;
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
import static universityroombookingsystem.Room_tabController.sc;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Booking_tabController implements Initializable {
static String sc = "id";
    static String si = "";
    @FXML
    private ComboBox<?> cmbSc;
    @FXML
    private TableView<?> tblList;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;
   // private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtSi;
    @FXML
    private Button btnRoom_tab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MyUtils.populateColumnNames(cmbSc, "booking_detail");
        MyUtils.selectComboBoxValue(cmbSc, sc);
        txtSi.setText(si);
        populate();
    }    
public void populate() {
        LinkedList<booking_detail> res = BookDao.search(cmbSc.getValue().toString(), txtSi.getText());
        MyUtils.populateTable(tblList, res, booking_detail.class);
    }
   

    @FXML
    private void he(ActionEvent event) {
     /*   if(event.getSource()==btnAdd){
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
        }*/
        
        
         if(event.getSource()==btnRoom_tab){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("Room_tab.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
        
        
        
        
        
        if (event.getSource() == btnUpdate) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                booking_detail c1 = BookDao.searchById(id);
LinkedList res=RoomDao.searchForRoomNo(c1.getType_of_room(),c1.getRoom_cap());
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
                 if ((c1.getStatus()).equals("approved")) {
                    JOptionPane.showMessageDialog(null, "That client's booking is already approved!");
                    return;
                }
                 if((res.isEmpty())){
         c1.setBookingId("null");
                           c1.setRoom_no("NoRoom");
                           c1.setStatus("NotApproved");    
                           BookDao.update(c1);
         JOptionPane.showMessageDialog(null, "No room Avail with such config!");
        return;
        }
                 
                else{
                   ApproveOrNotController.id = id;
                   
                Parent root = FXMLLoader.load(getClass().getResource("ApproveOrNot.fxml"));
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
            BookDao.delete(id);
            JOptionPane.showMessageDialog(null, "deleted!");
            populate();            
        }
        
        
        
        else   if(event.getSource()==btnBack){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
        si = txtSi.getText().toString();
        populate();  
    }
    
}
