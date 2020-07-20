/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegisterClientFXMLController implements Initializable {
    GUIValidator g1 = new GUIValidator();

    @FXML
    private TextField txtClientName;
    @FXML
    private PasswordField txtClientPass;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtPT_Name;
    @FXML
    private TextField txtFocus;
    @FXML
    private TextField txtTime;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtDate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addEmailValidator(txtEmail);
        g1.addPassValidator(txtClientPass);
        g1.addNameValidator(txtClientName);
        g1.addNameValidator(txtPT_Name);
        g1.addDateValidator(txtDate);
        
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnSubmit){
             try {
                 
                 if (!g1.validateAll()) {
                    return;
                }
                 client c1=new client();
                 c1.setClient_name(txtClientName.getText());
                 c1.setPt_name(txtPT_Name.getText());
                 c1.setEmail(txtEmail.getText());
                 c1.setFocus(txtFocus.getText());
                 c1.setPass(txtClientPass.getText());
                 c1.setTime(txtTime.getText());
                 c1.setDuration(txtDuration.getText());
                 c1.setDate(txtDate.getText());
                 ClientDao.insert(c1);
                Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            
        }
         else   if(event.getSource()==btnReset){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("RegisterClientFXML.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
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
