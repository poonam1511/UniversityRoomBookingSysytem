/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.MyUtils;
import OS.bean.client;
import OS.dao.ClientDao;
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
public class Staff_secController implements Initializable {
static String sc = "id";
    static String si = "";
    @FXML
    private Button btnPt_Detail;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField txtSi;
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
         MyUtils.populateColumnNames(cmbSc, "client");
        MyUtils.selectComboBoxValue(cmbSc, sc);
        txtSi.setText(si);
        populate();
    }    

     public void populate() {
        LinkedList<client> res = ClientDao.search(cmbSc.getValue().toString(), txtSi.getText());
        MyUtils.populateTable(tblList, res, client.class);
    }

    @FXML
    private void he(ActionEvent event) {
        
        if(event.getSource()==btnAdd){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("RegisterClientFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
        
        else if (event.getSource() == btnUpdate) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
                else{
                   ClientUpdateFXMLController.id = id;
                Parent root = FXMLLoader.load(getClass().getResource("ClientUpdateFXML.fxml"));
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
            ClientDao.delete(id);
            JOptionPane.showMessageDialog(null, "deleted!");
            populate();            
        }
        
        
        else if(event.getSource()==btnPt_Detail){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("Pt_tabFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
        else   if(event.getSource()==btnBack){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
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
    private void kr(KeyEvent event) {
        si = txtSi.getText().toString();
        populate();   
    }

    @FXML
    private void cc(ActionEvent event) {
        sc = cmbSc.getValue().toString();
        populate();
    }
    
}
