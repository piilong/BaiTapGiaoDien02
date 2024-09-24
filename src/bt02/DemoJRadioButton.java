/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import bt01.SimpleCalculator;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author ADMIN
 */
public class DemoJRadioButton extends JFrame{
    private JLabel lbNum1,lbNum2,lbResult,lbOp;
    private JTextField txtNum1,txtNum2,txtResult;
    private JButton btTinh,btNhapLai;
    private JRadioButton rdCong,rdTru,rdNhan,rdChia;
    
    public DemoJRadioButton(String title){
        super(title);
        createGUI();
        
        setSize(400,250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    private void createGUI(){
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,2,10,10));
        
        p.add(lbNum1=new JLabel("Num 1"));
        p.add(txtNum1=new JTextField(10));
        
        p.add(lbNum2=new JLabel("Num 2"));
        p.add(txtNum2=new JTextField(10));
        
        p.add(lbResult=new JLabel("Result"));
        p.add(txtResult=new JTextField(10));
        txtResult.setEditable(false);
        
        JPanel pPhepTinh=new JPanel();
        pPhepTinh.add(rdCong=new JRadioButton("+"));
        pPhepTinh.add(rdTru=new JRadioButton("-"));
        pPhepTinh.add(rdNhan=new JRadioButton("*"));
        pPhepTinh.add(rdChia=new JRadioButton("/"));
        
        p.add(lbOp=new JLabel("Phep Tinh"));
        p.add(pPhepTinh);
        
        p.add(btTinh=new JButton("Tinh"));
        p.add(btNhapLai=new JButton("NhapLai"));
        add(p);
        
        ButtonGroup btgPhepTinh=new ButtonGroup();
        btgPhepTinh.add(rdCong);
        btgPhepTinh.add(rdTru);
        btgPhepTinh.add(rdNhan);
        btgPhepTinh.add(rdChia);
        
        rdCong.setSelected(true);
        
        btTinh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    double x=Double.parseDouble(txtNum1.getText());
                    double y=Double.parseDouble(txtNum2.getText());
                    double kq=0;
                    if(rdCong.isSelected()){
                        kq=x+y;
                    }else if(rdTru.isSelected()){
                        kq=x-y;
                    }else if(rdNhan.isSelected()){
                        kq=x*y;
                    }else if(rdChia.isSelected()){
                        kq=x/y;
                    }
                    txtResult.setText(String.valueOf(kq));
                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Loi nhap lieu","Thong bao",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btNhapLai.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txtNum1.setText("");
                txtNum2.setText("");
                txtResult.setText("");
                rdCong.setSelected(true );
                
                txtNum1.requestFocus();
            }
        });
    }
    public static void main(String[] args) {
        DemoJRadioButton frm=new DemoJRadioButton("Simple Calculator");
        frm.setVisible(true);
    }
}
