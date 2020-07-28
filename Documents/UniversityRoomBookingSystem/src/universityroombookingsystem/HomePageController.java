/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.GUIValidator;
import OS.bean.room_detail;
import OS.dao.RoomDao;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomePageController implements Initializable {

    @FXML
    private Button btnReset;
    @FXML
    private Button btnBook;
    @FXML
    private ComboBox<?> cmbCap;
    @FXML
    private ComboBox<?> cmbType;
    @FXML
    private ComboBox<?> cmbTime;
    @FXML
    private DatePicker txtDatePicker;
    @FXML
    private ComboBox<?> cmbDuration;
 GUIValidator g1 = new GUIValidator();
    @FXML
    private Hyperlink LoginHypLink;
    @FXML
    private TextField txtAttendee;
    @FXML
    private TextArea taReason;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         g1.addIntValidator(txtAttendee);
         LinkedList types = new LinkedList();
        types.add("Lecture hall");
        types.add("Seminar hall");
        types.add("Auditorium");
        types.add("Experiment room");
        types.add("Computer room");
        
        
        LinkedList cap = new LinkedList();
        cap.add("50");
        cap.add("100");
        cap.add("200");
        cap.add("300");
        cap.add("500");
        cap.add("800");
        
        LinkedList roles = new LinkedList();
        roles.add("7am - 9am");
        roles.add("10am-12pm");
        roles.add("3pm-5pm");
        roles.add("5pm-7pm");
        roles.add("7pm-9pm");
        
        LinkedList duration = new LinkedList();
        duration.add("1 day");
        duration.add("2 days");
        duration.add("1 week");
        duration.add("2 hour");
        
        cmbType.getItems().addAll(types);
        cmbCap.getItems().addAll(cap);
        cmbTime.getItems().addAll(roles);
        cmbDuration.getItems().addAll(duration);

    }    

    @FXML
    private void he(ActionEvent event) {
        
         if(event.getSource()==btnBook){
             try {
                 if (!g1.validateAll()) {
                    return;
                }
                 Personal_detailController.type=cmbType.getValue().toString();
                 Personal_detailController.date=txtDatePicker.getValue().toString();
                 Personal_detailController.time=cmbTime.getValue().toString();
                 Personal_detailController.duration=cmbDuration.getValue().toString();
                 Personal_detailController.capacity=cmbCap.getValue().toString();
                 Personal_detailController.Attendee=txtAttendee.getText();
                 Personal_detailController.Reason=taReason.getText();
                 
                 Parent root = FXMLLoader.load(getClass().getResource("Personal_detail.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnReset.getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
            
        }
         
         else   if(event.getSource()==LoginHypLink){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
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
