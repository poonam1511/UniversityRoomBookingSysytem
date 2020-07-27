/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.GUIValidator;
import OS.bean.booking_detail;
import OS.bean.room_detail;
import OS.dao.BookDao;
import OS.dao.RoomDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Personal_detailController implements Initializable {

    @FXML
    private TextField txtEmail;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;
    @FXML
    private TextField txtAttendee;
   // private ComboBox<?> txtDuration;
    @FXML
    private TextField txtLecturerName;
    GUIValidator g1 = new GUIValidator();
static String type="";
static String time="";
static String date="";
static String duration="";
static String capacity="";
    @FXML
    private TextArea taReason;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addIntValidator(txtAttendee);
        g1.addEmailValidator(txtEmail);
        g1.addNameValidator(txtLecturerName);
        
    }    

    @FXML
    private void he(ActionEvent event) {
        
        if(event.getSource()==btnSubmit){
             try {
                 
                 if (!g1.validateAll()) {
                    return;
                }
                 booking_detail c1=new booking_detail();
                 c1.setLec_name(txtLecturerName.getText());
                 c1.setEmail(txtEmail.getText());
                 c1.setAttendee_no(txtAttendee.getText());
                 c1.setReason(taReason.getText());
                 c1.setType_of_room(type);
                 c1.setTime(time);
                 c1.setDate(date);
                 c1.setDuration(duration);
                 c1.setRoom_cap(capacity);
                 c1.setStatus("pending");
             if(Integer.parseInt(txtAttendee.getText())<=Integer.parseInt(capacity)){
                 BookDao.insert(c1);
                 JOptionPane.showMessageDialog(null, "Your status will be updated soon!");
             }
              
             else{
                 JOptionPane.showMessageDialog(null, "Room Capacity can't be smaller than Expected Attendee!!!!");
             }
                 
                 
                 Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Personal_detail.fxml"));
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
