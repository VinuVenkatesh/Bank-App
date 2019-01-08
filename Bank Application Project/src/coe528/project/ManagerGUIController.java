/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Vinu
 */
public class ManagerGUIController implements Initializable {
    @FXML
    private TextField user;
    @FXML
    private TextField pass;
    @FXML
    private Label error;
    public boolean check;
    /**
     * Initializes the controller class.
     */
    public void addingCustomer(){
        if(Manager.addCustomer(user.getText(),pass.getText()))
            error.setText("Customer Created");
        else
            error.setText("Username is already taken");
    }
    public void deletingCustomer(){
        if(Manager.deleteCustomer(user.getText(),pass.getText()))
            error.setText("Customer Deleted");
        else
            error.setText("Deletion Unsucessful due to either incorrect user or pass");
    }
    public void logout(ActionEvent event) throws IOException{
        Parent managerGUIParent = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene managerGUIScene = new Scene(managerGUIParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(managerGUIScene);
        window.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
