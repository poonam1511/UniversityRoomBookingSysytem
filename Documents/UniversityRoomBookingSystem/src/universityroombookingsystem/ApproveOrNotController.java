/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universityroombookingsystem;

import ECUtils.GUIValidator;
import ECUtils.MyUtils;
import OS.bean.booking_detail;
import OS.dao.BookDao;
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

public class ApproveOrNotController implements Initializable {
GUIValidator g1=new GUIValidator();
public static String id=null;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnApprove;
    @FXML
    private Button btnBack;
    @FXML
    private ComboBox<?> cmbRoomNo;
   // private TextField txtLecturerName;
    @FXML
    private TextField txtBookingId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        booking_detail c1 = BookDao.searchById(id);
        LinkedList res=RoomDao.searchForRoomNo(c1.getType_of_room(),c1.getRoom_cap());
         cmbRoomNo.getItems().addAll(res);
        /*if((res.isEmpty())){
         c1.setBookingId("null");
                           c1.setRoom_no("NoRoom");
                           c1.setStatus("NotApproved");    
                           BookDao.update(c1);
         JOptionPane.showMessageDialog(null, "No room Avail with such config!");
        return;
        }
            /* client c1=new client();
            for(int i=0;i<res.size();i++){
               c1=ClientDao.searchByFocus(res.get(i).toString(),txtTime.getValue().toString());
               if(c1!=null){
                   res.remove(i);
               }
            }*/
      
    }    

    @FXML
    private void he(ActionEvent event) {
        if (event.getSource() == btnApprove) {
            try {
                booking_detail c1 = BookDao.searchById(id);
               
                   if((!(c1.getStatus()).equals("approved"))){
                       booking_detail b1=BookDao.searchForPending(c1.getType_of_room(),c1.getTime(),c1.getDate(),"approved");
                       if(b1==null){
                           c1.setBookingId(txtBookingId.getText());
                           c1.setRoom_no(cmbRoomNo.getValue().toString());
                           c1.setStatus("approved");    
                           BookDao.update(c1);
                       }
                       else{
                           c1.setBookingId("null");
                           c1.setRoom_no("RoomFull");
                           c1.setStatus("NotApproved");    
                           BookDao.update(c1);
                           JOptionPane.showMessageDialog(null, "That room is already booked!");
                       }
                   }
                    /*   else if((c1.getStatus()).equals("approved")){
                    //   booking_detail b1=BookDao.searchForApproved(c1.getRoom_no(),c1.getTime(),c1.getDate());
                     //  if(b1==null){
                 //  txtBookingId.setText(c1.getBookingId());
                   //    MyUtils.selectComboBoxValue(cmbRoomNo, c1.getRoom_no());
                   JOptionPane.showMessageDialog(null, "That client's booking is already approved!");}
                      /*     c1.setBookingId(txtBookingId.getText());
                           c1.setRoom_no(cmbRoomNo.getValue().toString());
                           c1.setStatus("approved");    
                           BookDao.update(c1);
                       }
                       else{
                           JOptionPane.showMessageDialog(null, "That room is already booked!");
                       }
                       
                   }
                       else{
                           c1.setBookingId("null");
                           c1.setRoom_no("Room already engagged");
                           c1.setStatus(" not approved");    
                           BookDao.update(c1);
                       }
            */
                
                Parent root = FXMLLoader.load(getClass().getResource("Booking_tab.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }  
    }
        
        
        else   if(event.getSource()==btnReset){
             try {
                Parent root = FXMLLoader.load(getClass().getResource("ApproveOrNot.fxml"));
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
                Parent root = FXMLLoader.load(getClass().getResource("Booking_tab.fxml"));
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