/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powermanager;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import powermanager.controllers.Profiles;

/**
 *
 * @author Eldin Habibovic
 */
public class PowerManager {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String []args){
        if(!SystemTray.isSupported()){
            System.out.println("System tray is not supported !!! ");
            return ;
        }
        
        Profiles profiles = new Profiles();
        SystemTray systemTray = SystemTray.getSystemTray();

        PopupMenu trayPopupMenu = new PopupMenu();

        MenuItem action = new MenuItem("Add power plan");
        action.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "TO DO");
            }
        });
        trayPopupMenu.add(action);

        MenuItem highPerformance = new MenuItem("High performance");
        highPerformance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profiles.setHigh();
            }
        });
        trayPopupMenu.add(highPerformance);
        
        MenuItem balanced = new MenuItem("Balanced");
        balanced.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profiles.setBalanced();
            }
        });
        trayPopupMenu.add(balanced);
        
        MenuItem powersave = new MenuItem("Power Saver");
        powersave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profiles.setPowerSave();
            }
        });
        trayPopupMenu.add(powersave);

        MenuItem close = new MenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        trayPopupMenu.add(close);
        
        Image image = Toolkit.getDefaultToolkit().getImage(PowerManager.class.getResource("/resources/power.png"));

        TrayIcon trayIcon = new TrayIcon(image, "PowerManager", trayPopupMenu);

        trayIcon.setImageAutoSize(true);

        try{
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
        System.out.println("end of main");

    }
        
}
