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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AddRoomController implements Initializable {

    @FXML
    private TextField txtRoomNo;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<?> cmbCap;
    @FXML
    private ComboBox<?> cmbType;
GUIValidator g1 = new GUIValidator();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        g1.addIntValidator(txtRoomNo);
        
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
        
        
        cmbType.getItems().addAll(types);
        cmbCap.getItems().addAll(cap);
    }    

    @FXML
    private void he(ActionEvent event) {
        if(event.getSource()==btnSubmit){
             try {
                 if (!g1.validateAll()) {
                    return;
                }
                 room_detail c1=new room_detail();
                 
                 c1.setRoom_no(txtRoomNo.getText());
                 c1.setType_of_room(cmbType.getValue().toString());
                 c1.setRoom_cap(cmbCap.getValue().toString());
                 room_detail d1=RoomDao.searchByRoomNo(txtRoomNo.getText());
                  if(d1==null){
                     RoomDao.insert(c1);
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Room is already Added!");
                    //return;
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
