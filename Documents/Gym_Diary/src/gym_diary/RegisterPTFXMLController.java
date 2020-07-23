/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
import ECUtils.MyUtils;
import OS.bean.per_tra;
import OS.dao.per_traDao;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class RegisterPTFXMLController implements Initializable {
GUIValidator g1 = new GUIValidator();

    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtPtName;
    @FXML
    private PasswordField txtPtPass;
    @FXML
    private ComboBox<?> txtExpertise;
    @FXML
    private ComboBox<?> txtAvail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addPassValidator(txtPtPass);
        g1.addNameValidator(txtPtName);
        LinkedList roles = new LinkedList();
        roles.add("7am - 9am");
        roles.add("10am-12pm");
        roles.add("3pm-5pm");
        roles.add("5pm-7pm");
        roles.add("7pm-9pm");
        
        
        LinkedList focus = new LinkedList();
        focus.add("weight loss");
        focus.add("muscle gain");
        focus.add("flexibility");
        focus.add("cardio");
        focus.add("upper body");
        focus.add("lower body");
        txtAvail.getItems().addAll(roles);
       // MyUtils.selectComboBoxValue(txtAvail, "7am - 9am");
        txtExpertise.getItems().addAll(focus);
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if(event.getSource()==btnSubmit){
             try {
                 if (!g1.validateAll()) {
                    return;
                }
                 per_tra c1=new per_tra();
                 
                 c1.setPt_name(txtPtName.getText());
                 c1.setExpertise(txtExpertise.getValue().toString());
                 c1.setPass(txtPtPass.getText());
                 c1.setAvail_time(txtAvail.getValue().toString());
                 c1.setEmail(txtEmail.getText());
                 per_traDao.insert(c1);
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
                Parent root = FXMLLoader.load(getClass().getResource("RegisterPTFXML.fxml"));
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
