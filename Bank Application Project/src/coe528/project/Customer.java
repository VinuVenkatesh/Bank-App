/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Vinu
 */
public class Customer {
    public String userName, password;
    public double balance;
    public Levels lvl;
    
    public Customer(String userName, String password, double balance){
        this.balance = balance;
        if(this.balance < 10000)
            lvl = new Silver();
        else if (this.balance >=10000 && this.balance < 20000)
            lvl = new Gold();
        else
            lvl = new Platinum();
        this.userName = userName;
        this.password = password;
    }
    public boolean withdraw(double b) throws IOException{
        if(b > balance)
            return false;
        else
            balance -= b;
        lvl.changeLevel(this);
        FileWriter fw = new FileWriter(userName+".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(password);
        pw.println(balance);
        pw.close();
        return true;
    }
    public void deposit(double b) throws IOException{
        balance += b;
        lvl.changeLevel(this);
        FileWriter fw = new FileWriter(userName+".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(password);
        pw.println(balance);
        pw.close();
    }
    public boolean onlinePurchase(double cost) throws IOException{
        if(cost < 100 || (cost+ lvl.getFee()) > balance)
            return false;
        else
            balance = balance - (cost + lvl.getFee());
        lvl.changeLevel(this);
        FileWriter fw = new FileWriter(userName+".txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.println(password);
        pw.println(balance);
        pw.close();
        return true;
    }
    public double getBalance(){
        return balance;
    }
    @Override
    public String toString(){
        return userName;
    }
}
