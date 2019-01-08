/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;

/**
 *
 * @author Vinu
 */
public class Silver extends Levels {
    /**Overview: This class represents the level of a customer if their balance is less than 10,000.
     * This is a immutable class.
     */
    /**Abstraction Function:
     * Showing the level of the customer object that access this class.
     * The AF is: AF(c) = Silver
     */
    /**RepInvariant:
     * Always true
     */
    final double FEE = 20;
    @Override
    public double getFee(){
        //Effects: returns the fee for a silver customer to do an online purchase.
        return FEE;
    }
    @Override
    public void changeLevel(Customer c){
        //Requires: c to be of type Customer with username,pass,lvl, and balance.
        //Modifies: c.lvl.
        //Effects: according to the balance of the customer changes the level of the customer.
        if(c.balance >= 10000 && c.balance < 20000)
            c.lvl = new Gold();
        if(c.balance >= 20000)
            c.lvl = new Platinum();
    }
    @Override
    public String toString(){
        //Effects: returns customer's level.
        return "Silver";
    }
    public boolean repOK(){
        //Effects: returns true.
        return true;
    }
}
