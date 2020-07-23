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
import static gym_diary.ClientUpdateFXMLController.id;
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
public class PtUpdateFXMLController implements Initializable {
GUIValidator g1=new GUIValidator();
public static String id=null;
    @FXML
    private TextField txtPtName;
    @FXML
    private PasswordField txtPtPass;
    @FXML
    private TextField txtEmail;
    @FXML
    private ComboBox<?> txtExpertise;
    @FXML
    private ComboBox<?> txtAvail;
    @FXML
    private Button btnReset;
  //  private Button btnSubmit;
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
        populateOldData();
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if (event.getSource() == btnUpdate) {
                if(!g1.validateAll()){
                    return;
                } 
                
                try {

                    per_tra c1=new per_tra();
                 
                 c1.setPt_name(txtPtName.getText());
            c1.setEmail(txtEmail.getText());
                 c1.setPass(txtPtPass.getText());
                 c1.setAvail_time(txtAvail.getValue().toString());
                 c1.setExpertise(txtExpertise.getValue().toString());
                 c1.setId(id);
                    per_traDao.update(c1);
                    
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
                Parent root = FXMLLoader.load(getClass().getResource("PtUpdateFXML.fxml"));
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
    
    
     public void populateOldData()
      {
          
          per_tra c1 = per_traDao.searchById(id);
         
          txtPtName.setText(c1.getPt_name());
          MyUtils.selectComboBoxValue(txtExpertise, c1.getExpertise());
          MyUtils.selectComboBoxValue(txtAvail, c1.getAvail_time());
          //txtExpertise.setText(c1.getExpertise());
         // txtAvail.setText(c1.getAvail_time());
          txtPtPass.setText(c1.getPass());
          txtEmail.setText(c1.getEmail());
          
        
        
        
      }
}

    
    
    
    

