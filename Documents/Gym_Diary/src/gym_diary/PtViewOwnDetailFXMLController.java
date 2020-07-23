/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.GUIValidator;
import OS.bean.per_tra;
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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class PtViewOwnDetailFXMLController implements Initializable {
GUIValidator g1 = new GUIValidator();
public static String id;
    per_tra c1 = per_traDao.searchById(id);
    @FXML
    private Button btnUpdate;
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
        String res = "\n Personal Trainer  :: " +c1.getPt_name();
            res += "\n\n email :: " +c1.getEmail();
            res += "\n\n expertise::"+c1.getExpertise();
            
            res += "\n\n Avail Time :: " + c1.getAvail_time();
            res += "\n\n pass :: " + c1.getPass();
            //lblOut1.setText(res);
            lblOut.setText(res);
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
                   PtUpdateFXMLController.id = id;
                Parent root = FXMLLoader.load(getClass().getResource("PtUpdateFXML.fxml"));
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
