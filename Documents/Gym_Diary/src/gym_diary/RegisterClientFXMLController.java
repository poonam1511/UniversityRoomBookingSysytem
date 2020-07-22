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
import OS.dao.ClientDao;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    private ComboBox<?> txtPT_Name;
    @FXML
    private TextField txtFocus;
    @FXML
    private ComboBox<?> txtTime;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<?> txtDuration;

    @FXML
    private TextField txtDate;
    @FXML
    private DatePicker txtDatePicker;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //DatePicker dp = new DatePicker();
        
        txtPT_Name.setDisable(true);
        
        LinkedList roles = new LinkedList();
        roles.add("7am - 9am");
        roles.add("10am-12pm");
        roles.add("3pm-5pm");
        roles.add("5pm-7pm");
        roles.add("7pm-9pm");
        
        LinkedList duration = new LinkedList();
        duration.add("3 month");
        duration.add("6 month");
        duration.add("9 month");
        duration.add("1 year");
        
        txtTime.getItems().addAll(roles);
        txtDuration.getItems().addAll(duration);
        
        MyUtils.selectComboBoxValue(txtTime, "7am - 9am");
        MyUtils.selectComboBoxValue(txtDuration, "3 month");
        
        g1.addEmailValidator(txtEmail);
        g1.addPassValidator(txtClientPass);
        g1.addNameValidator(txtClientName);
        g1.addNameValidator(txtPT_Name);
        //g1.addDateValidator(txtDate);
        
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
                 c1.setPt_name(txtPT_Name.getValue().toString());
                 c1.setEmail(txtEmail.getText());
                 c1.setFocus(txtFocus.getText());
                 c1.setPass(txtClientPass.getText());
                 c1.setTime(txtTime.getValue().toString());
                 c1.setDuration(txtDuration.getValue().toString());
                 c1.setDate(txtDate.getText());
                 //c1.setDate(txtDatePicker.getValue().toString());
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

   

    @FXML
    private void kr(ActionEvent event) {
        LinkedList res=per_traDao.searchByFocus(txtFocus.getText(),txtTime.getValue().toString());
       /*  if(c2!=null){
                     txtPT_Name.setDisable(false);
                     //txtPT_Name.setTex(c2.getPt_name());
        /setText(txtPT_Name)=c2.getPt_name();
                 
                 }*/
        
        if(!(res.isEmpty())){
             client c1=new client();
            for(int i=0;i<res.size();i++){
               c1=ClientDao.searchByFocus(res.get(i).toString(),txtTime.getValue().toString());
               if(c1!=null){
                   res.remove(i);
               }
            }
            txtPT_Name.setDisable(false);
            txtPT_Name.getItems().addAll(res);
        }
        else{
                     //txtPT_Name.setText(null);
                    // txtPT_Name.getItems().removeAll(res);
                     txtPT_Name.setDisable(true);
                     JOptionPane.showMessageDialog(null, "No Trainer Availible with such expertise in that time!");
                  //  return;
                 }
               
                 
                 
    }
    
    
}
