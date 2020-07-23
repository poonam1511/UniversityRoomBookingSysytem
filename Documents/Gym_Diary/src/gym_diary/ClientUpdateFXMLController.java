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
import OS.dao.per_traDao;
import java.io.FileInputStream;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ClientUpdateFXMLController implements Initializable {

    @FXML
    private TextField txtClientName;
    @FXML
    private PasswordField txtClientPass;
    @FXML
    private TextField txtEmail;
  //  private ComboBox<?> txtPT_Name;
    @FXML
    private ComboBox<?> txtFocus;
    @FXML
    private ComboBox<?> txtTime;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<?> txtDuration;
GUIValidator g1=new GUIValidator();
public static String id=null;
   // private TextField txtDate;
    @FXML
    private DatePicker txtDatePicker;
    @FXML
    private ComboBox<?> txtPTName;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     //  txtPT_Name.setDisable(true);
        
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
        
        LinkedList focus = new LinkedList();
        focus.add("weight loss");
        focus.add("muscle gain");
        focus.add("flexibility");
        focus.add("cardio");
        focus.add("upper body");
        focus.add("lower body");
        txtFocus.getItems().addAll(focus);
        txtTime.getItems().addAll(roles);
        txtDuration.getItems().addAll(duration);
        
        // TODO
        populateOldData();
        g1.addEmailValidator(txtEmail);
        g1.addPassValidator(txtClientPass);
        g1.addNameValidator(txtClientName);
    //    g1.addNameValidator(txtPT_Name);
        
    }    

    @FXML
    private void he(ActionEvent event) {
        
        
        if (event.getSource() == btnUpdate) {
                if(!g1.validateAll()){
                    return;
                } 
                
                try {

               client c1=new client();
                 c1.setClient_name(txtClientName.getText());
                 c1.setPt_name(txtPTName.getValue().toString());
                 c1.setEmail(txtEmail.getText());
                 c1.setFocus(txtFocus.getValue().toString());
                 c1.setPass(txtClientPass.getText());
                 c1.setTime(txtTime.getValue().toString());
                 c1.setDuration(txtDuration.getValue().toString());
                 c1.setDate(txtDatePicker.getValue().toString());
                  c1.setId(id);
                    ClientDao.update(c1);
                    
                Parent root = FXMLLoader.load(getClass().getResource("LoginFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }  
    
    }
        
        else if (event.getSource() == btnReset) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("ClientUpdateFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }  
    
}
         else if (event.getSource() == btnBack) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Staff_sec.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }  
    
}
    
    
    
   
    
    }
    
    
     public void populateOldData()
      {
          
          client c1 = ClientDao.searchById(id);
          txtClientName.setText(c1.getClient_name());
          
          MyUtils.selectComboBoxValue(txtFocus, c1.getFocus());
          
          LinkedList ptName = new LinkedList();
          ptName.add(c1.getPt_name());
          txtPTName.getItems().addAll(ptName);
          MyUtils.selectComboBoxValue(txtPTName, c1.getPt_name());
          MyUtils.selectComboBoxValue(txtDuration, c1.getDuration());
          MyUtils.selectComboBoxValue(txtTime, c1.getTime());
         /* txtPT_Name.setValue(c1.getPt_name());
          txtFocus.setText(c1.getFocus());
          txtDuration.setText(c1.getDuration());
          txtTime.setText(c1.getTime());*/
          txtEmail.setText(c1.getEmail());
          txtClientPass.setText(c1.getPass());
          LocalDate localDate= LocalDate.parse((c1.getDate()));
          txtDatePicker.setValue(localDate);
        
        
        
      }

    @FXML
    private void kr(ActionEvent event) {
         LinkedList res=per_traDao.searchByFocus(txtFocus.getValue().toString(),txtTime.getValue().toString());
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
            txtPTName.setDisable(false);
            txtPTName.getItems().addAll(res);
        }
        else{
                     //txtPT_Name.setText(null);
                    // txtPT_Name.getItems().removeAll(res);
                     txtPTName.setDisable(true);
                     JOptionPane.showMessageDialog(null, "No Trainer Availible with such expertise in that time!");
                  //  return;
                 }
               
                 
                 
    }
    
    
}
