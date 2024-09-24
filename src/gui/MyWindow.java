/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.GridLayout;
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
public class MyWindow extends JFrame {

    private JLabel lbUser, lbPass;
    private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btLogin, btReset;

    public MyWindow(String title) {
        super(title);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(3, 2, 10, 10));
        p.add(lbUser =new JLabel("User name"));
        p.add(txtUser =new JTextField(10));
        p.add(lbPass =new JLabel("Password"));
        p.add(txtPass =new JPasswordField(10));
        
        p.add(btLogin =new JButton("Login"));
        p.add(btReset =new JButton("Reset"));
        
        add(p);
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        MyWindow frm=new MyWindow("Login System");
        frm.setVisible(true);
    }


}
