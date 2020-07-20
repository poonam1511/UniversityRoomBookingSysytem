/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
import OS.bean.client;
import OS.bean.per_tra;
import OS.dao.ClientDao;
import OS.dao.per_traDao;
import static gym_diary.ClientUpdateFXMLController.id;
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
    private TextField txtExpertise;
    @FXML
    private TextField txtAvail;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        populateOldData();
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if (event.getSource() == btnSubmit) {
                if(!g1.validateAll()){
                    return;
                } 
                
                try {

                    per_tra c1=new per_tra();
                 
                 c1.setPt_name(txtPtName.getText());
            
                 c1.setPass(txtPtPass.getText());
                 c1.setAvail_time(txtAvail.getText());
                 c1.setExpertise(txtExpertise.getText());
                    per_traDao.update(c1);
                    
                Parent root = FXMLLoader.load(getClass().getResource("Pt_tabFXML.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Pt_tabFXML.fxml"));
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
          txtExpertise.setText(c1.getExpertise());
          txtAvail.setText(c1.getAvail_time());
          txtPtPass.setText(c1.getPass());
          
        
        
        
      }
}

    
    
    
    

