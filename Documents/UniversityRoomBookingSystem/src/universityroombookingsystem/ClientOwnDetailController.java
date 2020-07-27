/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.GUIValidator;
import OS.bean.booking_detail;
import OS.dao.BookDao;
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
public class ClientOwnDetailController implements Initializable {
GUIValidator g1 = new GUIValidator();
public static String id;
    booking_detail c1 = BookDao.searchById(id);
    @FXML
    private Label lblOut;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String res = "\n Lecturer Name  :: " +c1.getLec_name() ;
            res += "\n\n Booking Id  :: " +c1.getBookingId() ;
            res += "\n\n Room No. :: " +c1.getRoom_no();
            res += "\n\n Status :: " + c1.getStatus();
            res += "\n\n Time :: " + c1.getTime();
            res += "\n\n Date :: " + c1.getDate();
            //lblOut1.setText(res);
            lblOut.setText(res);
    }    

    @FXML
    private void he(ActionEvent event) {
    }
    
}
