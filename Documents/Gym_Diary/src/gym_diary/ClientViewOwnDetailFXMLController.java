/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
import ECUtils.MyUtils;
import OS.bean.client;
import OS.dao.ClientDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ClientViewOwnDetailFXMLController implements Initializable {
GUIValidator g1 = new GUIValidator();
public static String id;
    client c1 = ClientDao.searchById(id);
    //private Label lblOut1;
    @FXML
    private Label lblOut;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        
        String res = "\n Client Name  :: " +c1.getClient_name() ;
            res += "\n\n Personal Trainer  :: " +c1.getPt_name() ;
            res += "\n\n email :: " +c1.getEmail();
            res += "\n\n Duration :: " + c1.getDuration();
            res += "\n\n Time :: " + c1.getTime();
            res += "\n\n Date :: " + c1.getDate();
            //lblOut1.setText(res);
            lblOut.setText(res);
 // lblOut.setText(c1.getProductName());
 
    }    

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnUpdate) {
            try {
                String id = c1.getId();
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
        
        
        
        else if (event.getSource() == btnBack) {
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
    
    
}
