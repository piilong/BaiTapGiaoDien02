/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class Program {
    public static void main(String[] args) {
        JFrame frm=new JFrame("Login System");
        
        
        JPanel p=new JPanel();
        
        p.setLayout(null);
        
        JLabel lbUser =new JLabel("User name");
        JLabel lbPass =new JLabel("Password");
        
        JTextField txtUser=new JTextField(10);
        JPasswordField txtPass=new JPasswordField(10);
        
        JButton btLogin=new JButton("login");
        JButton btReset=new JButton("Reset");
        
        
        p.add(lbUser);
        p.add(txtUser);
        p.add(lbPass);
        p.add(txtPass);
        p.add(btLogin);
        p.add(btReset);
        
        lbUser.setBounds(10, 10, 100, 30);
        txtUser.setBounds(120, 10, 150, 30);
        
        lbPass.setBounds(10, 50, 100, 30);
        txtPass.setBounds(120, 50, 150, 30);
        
        btLogin.setBounds(30, 90, 100, 30);
        btReset.setBounds(140, 90, 100, 30);
        
        frm.add(p);
        
        frm.setSize(300,200);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
