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
public class CustomerGUIController implements Initializable {
    @FXML
    private TextField amount;
    @FXML
    private Label displayBalance;
    @FXML
    private Label error;
    @FXML
    private Label level;
   
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
    public void depositClicked(){
        try{
            LoginController.currentCustomer.deposit(Double.parseDouble(amount.getText()));
            displayBalance.setText(Double.toString(LoginController.currentCustomer.getBalance()));
            level.setText(LoginController.currentCustomer.lvl.toString());
        }
        catch(Exception e){
            error.setText("Invalid Amount");
        }
    }
    public void withdrawClicked(){
         try{
            if(LoginController.currentCustomer.withdraw(Double.parseDouble(amount.getText())))
                error.setText("Successfully Withdrawn");
            else
                error.setText("Not Enought Balance");
            displayBalance.setText(Double.toString(LoginController.currentCustomer.getBalance()));
            level.setText(LoginController.currentCustomer.lvl.toString());
        }
        catch(Exception e){
            error.setText("Invalid Amount");
        }
    }
    public void onlinePurchaseClicked(){
         try{
            double amt = Double.parseDouble(amount.getText());
            if(amt < 100)
                error.setText("Amount is less than 100");
            else{
                if(LoginController.currentCustomer.onlinePurchase(amt))
                    error.setText("Successfuly Bought");
                else
                    error.setText("Not enough balance");
            }
            displayBalance.setText(Double.toString(LoginController.currentCustomer.getBalance()));
            level.setText(LoginController.currentCustomer.lvl.toString());
        }
        catch(Exception e){
            error.setText("Invalid Amount");
        }
    }
    public void checkBalanceClicked(){
        displayBalance.setText(Double.toString(LoginController.currentCustomer.getBalance()));
        level.setText(LoginController.currentCustomer.lvl.toString());
    }
}
