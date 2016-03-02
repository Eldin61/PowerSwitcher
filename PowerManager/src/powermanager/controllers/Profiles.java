/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powermanager.controllers;

import java.io.IOException;

/**
 *
 * @author Eldin Habibovic
 */
public class Profiles {
    
    String highPerfString = "8c5e7fda-e8bf-4a96-9a85-a6e23a8c635c";
    String balancedString = "381b4222-f694-41f0-9685-ff5bb260df2e";
    String powerSaverString = "a1841308-3541-4fab-bc81-f71556f20b4a";
    
    public void setHigh(){
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "powercfg -s " + highPerfString });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void setBalanced(){
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "powercfg -s " + balancedString });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void setPowerSave(){
        try {
            Process process = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", "powercfg -s " + powerSaverString });
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
