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
public class Platinum extends Levels {
    final double FEE = 0;
    @Override
    public double getFee(){
        return FEE;
    }
    @Override
    public void changeLevel(Customer c){
        if(c.balance >= 10000 && c.balance < 20000)
            c.lvl = new Gold();
        if(c.balance < 10000)
            c.lvl = new Silver();
    }
    @Override
    public String toString(){
        return "Platinum";
    }
}
