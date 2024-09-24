/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bt03;

import gui.DemoJRadioButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class DemoComboBox extends JFrame {

    private JLabel lbNum1, lbNum2, lbOp, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btTinh, btNhapLai;
    private JComboBox cboTinh;

    public DemoComboBox(String title) {
        super(title);
        createGUI();

        setSize(400, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    private void createGUI() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5, 2, 10, 10));

        p.add(lbNum1 = new JLabel("Num 1"));
        p.add(txtNum1 = new JTextField(10));

        p.add(lbNum2 = new JLabel("Num 2"));
        p.add(txtNum2 = new JTextField(10));

        p.add(lbOp = new JLabel("Phep Tinh"));
        String[] pheptinh = { "Add", "Subtract", "Multiply", "Divide" };
        p.add(cboTinh = new JComboBox<>(pheptinh));
        cboTinh.setSelectedIndex(0);
        
        

        p.add(lbResult = new JLabel("Result"));
        p.add(txtResult = new JTextField(10));
        txtResult.setEditable(false);

        p.add(btTinh = new JButton("Tinh"));
        p.add(btNhapLai = new JButton("NhapLai"));
        add(p);

        btTinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x = Double.parseDouble(txtNum1.getText());
                    double y = Double.parseDouble(txtNum2.getText());
                    double kq = 0;
                    String Tinh = (String) cboTinh.getSelectedItem();

                    switch (Tinh) {
                        case "Add":
                            kq = x + y;
                            break;
                        case "Subtract":
                            kq = x - y;
                            break;
                        case "Multiply":
                            kq = x * y;
                            break;
                        case "Divide":                          
                            kq = x / y;
                            break;
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Loi nhap lieu", "Thong bao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btNhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNum1.setText("");
                txtNum2.setText("");
                txtResult.setText("");
                cboTinh.setSelectedIndex(0);

                txtNum1.requestFocus();
            }
        });
    }

    public static void main(String[] args) {
        DemoComboBox frm = new DemoComboBox("Simple Calculator");
        frm.setVisible(true);
    }
}
