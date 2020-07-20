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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    }
    
}
