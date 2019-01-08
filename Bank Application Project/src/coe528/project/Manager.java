/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.project;
import java.io.*;
/**
 *
 * @author Vinu
 */
public class Manager {
    final static String MANAGERUSER = "admin";
    final static String MANAGERPASS = "admin";
    
    public static boolean addCustomer(String user, String pass){
        try{
            FileReader fr = new FileReader(user+".txt");
            BufferedReader br = new BufferedReader(fr);
            br.close();
            return false;
        }
        catch(Exception e){
        }
        try{
            FileWriter fw = new FileWriter(user+".txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(pass);
            pw.println(100);
            pw.close();
        }
        catch(Exception e){
            System.out.println("Unable to create file");
        }
        return true;
    }
    public static boolean deleteCustomer(String user, String pass){
        boolean check = false;
        try{
            FileReader fr = new FileReader(user+".txt");
            BufferedReader br = new BufferedReader(fr);
            if(br.readLine().equals(pass)){
                br.close();
                File file = new File(user+".txt");
                file.delete();
                check = true;
            }
            else{
                br.close();
                return false;
            }
                
        }
        catch(Exception e){
            
        }
        return check;
    }
}
