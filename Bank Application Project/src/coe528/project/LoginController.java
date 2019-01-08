/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Vinu
 */
public class LoginController implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Label error;
    public static Customer currentCustomer;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void loginClicked(ActionEvent event) throws IOException{
        if(Manager.MANAGERUSER.equals(user.getText()) && Manager.MANAGERPASS.equals(pass.getText())){
            Parent managerGUIParent = FXMLLoader.load(getClass().getResource("ManagerGUI.fxml"));
            Scene managerGUIScene = new Scene(managerGUIParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(managerGUIScene);
            window.show();
        }
        else{
            try{
                FileReader fr = new FileReader(user.getText()+".txt");
                BufferedReader br = new BufferedReader(fr);
                if(br.readLine().equals(pass.getText())){
                    double b;
                    b = Double.parseDouble(br.readLine());
                    br.close();
                    currentCustomer = new Customer(user.getText(),pass.getText(),b);
                    Parent CustomerGUIParent = FXMLLoader.load(getClass().getResource("CustomerGUI.fxml"));
                    Scene CustomerGUIScene = new Scene(CustomerGUIParent);
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(CustomerGUIScene);
                    window.show();
                }
            }
            catch(Exception e){
                error.setText("Incorrect User or Pass");
            }
        }
    }
}
