/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class SimpleCalculator extends JFrame{
    private JLabel lbNum1,lbNum2,lbResult;
    private JTextField txtNum1,txtNum2,txtResult;
    private JButton btAdd,btSub,btMul,btDiv,btExit;
    
    public SimpleCalculator(String title){
        super(title);
        createGUI();
        
        setSize(470,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    private void createGUI(){
        JPanel p = new JPanel();
        p.setLayout(null);
        p.add(lbNum1=new JLabel("Num 1"));
        p.add(txtNum1=new JTextField(10));
        
        p.add(lbNum2=new JLabel("Num 2"));
        p.add(txtNum2=new JTextField(10));
        
        p.add(lbResult=new JLabel("Result"));
        p.add(txtResult=new JTextField(10));
        
        p.add(btAdd=new JButton("Add"));
        p.add(btSub=new JButton("Sub"));
        p.add(btMul=new JButton("Mul"));
        p.add(btDiv=new JButton("Div"));
        p.add(btExit=new JButton("Exit"));
        
        lbNum1.setBounds(10, 10, 100, 30);
        txtNum1.setBounds(120, 10, 200, 30);
        
        lbNum2.setBounds(10, 50, 100, 30);
        txtNum2.setBounds(120, 50, 200, 30);
        
        lbResult.setBounds(10, 100, 100, 30);
        txtResult.setBounds(120, 100, 200, 30);
        
        btAdd.setBounds(10, 140, 80, 40);
        btSub.setBounds(100, 140, 80, 40);
        btMul.setBounds(190, 140, 80, 40);
        btDiv.setBounds(280, 140, 80, 40);
        btExit.setBounds(370, 140, 80, 40);
        add(p);
        
        btAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x=Double.parseDouble(txtNum1.getText());
                    double y=Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    kq=x+y;
                    txtResult.setText(String.valueOf(kq));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Loi nhap lieu","Thong bao",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btSub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x=Double.parseDouble(txtNum1.getText());
                    double y=Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    kq=x-y;
                    txtResult.setText(String.valueOf(kq));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Loi nhap lieu","Thong bao",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btMul.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x=Double.parseDouble(txtNum1.getText());
                    double y=Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    kq=x*y;
                    txtResult.setText(String.valueOf(kq));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Loi nhap lieu","Thong bao",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btDiv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x=Double.parseDouble(txtNum1.getText());
                    double y=Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    kq=x/y;
                    txtResult.setText(String.valueOf(kq));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Loi nhap lieu","Thong bao",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                    SimpleCalculator.this,
                    "Ban co muon thoat khong?",
                    "Exit Confirmation",
                    JOptionPane.YES_NO_OPTION
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    public static void main(String[] args) {
        SimpleCalculator frm=new SimpleCalculator("Simple Calculator");
        frm.setVisible(true);
    }
}
