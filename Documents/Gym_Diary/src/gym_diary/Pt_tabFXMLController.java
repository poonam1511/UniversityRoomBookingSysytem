/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym_diary;

import ECUtils.MyUtils;
import OS.bean.client;
import OS.bean.per_tra;
import OS.dao.ClientDao;
import OS.dao.per_traDao;
import static gym_diary.Staff_secController.sc;
import static gym_diary.Staff_secController.si;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Pt_tabFXMLController implements Initializable {
static String sc = "id";
    static String si = "";
    @FXML
    private ComboBox<?> cmbSc;
    @FXML
    private TableView<?> tblList;
    @FXML
    private TextField txtSi;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MyUtils.populateColumnNames(cmbSc, "per_tra");
        MyUtils.selectComboBoxValue(cmbSc, sc);
        txtSi.setText(si);
        populate();
    }    

    public void populate() {
        LinkedList<per_tra> res = per_traDao.search(cmbSc.getValue().toString(), txtSi.getText());
        MyUtils.populateTable(tblList, res, per_tra.class);
    }

    @FXML
    private void cc(ActionEvent event) {
        sc = cmbSc.getValue().toString();
        populate();
    }

    @FXML
    private void kr(KeyEvent event) {
        si = txtSi.getText().toString();
        populate(); 
    }

    @FXML
    private void he(ActionEvent event) {
        
        if(event.getSource()==btnAdd){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("RegisterPtFXML.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
        else if (event.getSource() == btnUpdate) {
            try {
                String id = MyUtils.getSelColValue("id", tblList);
                if (id == null) {
                    JOptionPane.showMessageDialog(null, "Please select a row!");
                    return;
                }
                else{
                   PtUpdateFXMLController.id = id;//trainer fxml make
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
        
        
        
        else if(event.getSource()==btnDelete){
            String id = MyUtils.getSelColValue("id", tblList);
            if (id == null) {
                JOptionPane.showMessageDialog(null, "Please select a row!");
                return;
            }
            
            int ch = JOptionPane.showConfirmDialog(null, "R u sure, you want to delete!");
            if(ch!=JOptionPane.YES_OPTION){
                return;                
            }
            ClientDao.delete(id);
            JOptionPane.showMessageDialog(null, "deleted!");
            populate();            
        }

        
        
        else if(event.getSource()==btnBack){
                       try {
                 Parent root = FXMLLoader.load(getClass().getResource("Staff_sec.fxml"));
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnBack.getScene().getWindow();
                stage.setScene(scene);
                stage.setMaximized(true);
                stage.show();
                 } catch (Exception e) {
                e.printStackTrace();
            }                                    
        }
        
    }
    
}
