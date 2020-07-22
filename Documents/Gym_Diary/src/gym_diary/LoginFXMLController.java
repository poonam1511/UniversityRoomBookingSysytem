/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
import ECUtils.MyUtils;
import OS.bean.client;
import OS.bean.per_tra;
import OS.bean.staff;
import OS.dao.ClientDao;
import OS.dao.StaffDao;
import OS.dao.per_traDao;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginFXMLController implements Initializable {
GUIValidator g1 = new GUIValidator();
static String sc = "id";
    @FXML
    private RadioButton RadioPT;
    @FXML
    private ToggleGroup Toggle;
    @FXML
    private Label lblOut;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnReset;
    @FXML
    private RadioButton RadioClient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addRequiredValidator(txtName);
        g1.addPassValidator(txtPass);
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if(event.getSource()==RadioPT)
        {
         try {  Parent root = FXMLLoader.load(getClass().getResource("RegisterPTFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                        }
         catch (Exception  e) {
                e.printStackTrace();
            }
        }
         
        if(event.getSource()==RadioClient)
        {
         try {  Parent root = FXMLLoader.load(getClass().getResource("RegisterClientFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                        }
         catch (Exception  e) {
                e.printStackTrace();
            }
        }
         
         if( event.getSource()==btnLogin) { 
                    
                 if(!g1.validateAll()){
                     return;
                 }
                   
                   staff  sa = StaffDao.validate(txtName.getText(), txtPass.getText());
                   client mu = ClientDao.searchUser(txtName.getText(),txtPass.getText());
                   per_tra mt = per_traDao.searchUser(txtName.getText(),txtPass.getText());
                  try {
                 if(sa!=null){
                Parent root = FXMLLoader.load(getClass().getResource("Staff_sec.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                             }
                 
                 
                  
                 else if(mu!=null){
                      ClientViewOwnDetailFXMLController.id = mu.getId();
                Parent root = FXMLLoader.load(getClass().getResource("ClientViewOwnDetailFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                                    }
                 else if(mt!=null){
                      PtViewOwnDetailFXMLController.id = mt.getId();
                Parent root = FXMLLoader.load(getClass().getResource("PtViewOwnDetailFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                                    }
                 else{
                      lblOut.setText("incorrect username or password");
                  }
                 
             } catch (Exception e) {
                 e.printStackTrace();
             }
                                      
      
                       
}
   else   if(event.getSource()==btnReset){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("Pt_tabFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            
        }
        else   if(event.getSource()==btnBack){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("Staff_sec.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            
        }
    
    }
    
}
