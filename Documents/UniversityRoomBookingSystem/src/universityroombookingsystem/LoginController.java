/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.GUIValidator;
import OS.bean.booking_detail;
import OS.bean.staff;
import OS.dao.BookDao;
import OS.dao.StaffDao;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class LoginController implements Initializable {
GUIValidator g1 = new GUIValidator();
static String sc = "id";
    @FXML
    private Button btnReset;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField txtEmail;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnBack;
    @FXML
    private Label lblOut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if( event.getSource()==btnLogin) { 
                    
                 if(!g1.validateAll()){
                     return;
                 }
                   
                   staff  sa = StaffDao.validate(txtName.getText(), txtEmail.getText());
                   booking_detail mu = BookDao.searchUser(txtName.getText(),txtEmail.getText());
                   
                  try {
                 if(sa!=null){
                     Parent root = FXMLLoader.load(getClass().getResource("Booking_tab.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                             }
                 else if(mu!=null){
                      ClientOwnDetailController.id = mu.getId();
                Parent root = FXMLLoader.load(getClass().getResource("ClientOwnDetail.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
