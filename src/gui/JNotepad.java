/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame {

    private JMenuBar mBar;
    private JMenu mFile, mEdit, mFormat, mView, mHelp, mZoom;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit, itemFont,
            itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSearch, itemFind, itemFindNext, itemFindPrevious,
            itemReplace, itemGoto, itemSelectAll, itemTimeDate, itemZoomIn, itemZoomOut, itemRestore, itemStatus,
            itemViewHelp, itemSendFeedback, itemAbout;
    private JCheckBoxMenuItem itemWrap, itemStatusBar;
    private JTextArea txtEditor;
    private JToolBar toolBar;
    private JButton btNew, btOpen, btSave;
    int size = 20;

    public JNotepad(String title) {

        super(title);
        createMenu();
        createGUI();
        processEvent();
        createToolBar();
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        //tao thanh thuc don
        mBar = new JMenuBar();
        mBar.add(mFile = new JMenu("File"));
        mBar.add(mEdit = new JMenu("Edit"));
        mBar.add(mFormat = new JMenu("Format"));
        mBar.add(mView = new JMenu("View"));
        mBar.add(mHelp = new JMenu("Help"));

        //tao item va add vao menu file
        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open..."));
        mFile.add(itemSave = new JMenuItem("Save"));
        mFile.add(itemSaveAs = new JMenuItem("SaveAs..."));
        mFile.addSeparator();
        mFile.add(itemPageSetup = new JMenuItem("Page Setup..."));
        mFile.add(itemPrint = new JMenuItem("Print..."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));

        //tao item va add vao menu edit
        mEdit.add(itemUndo = new JMenuItem("Undo"));
        mEdit.addSeparator();
        mEdit.add(itemCut = new JMenuItem("Cut"));
        mEdit.add(itemCopy = new JMenuItem("Copy"));
        mEdit.add(itemPaste = new JMenuItem("Paste"));
        mEdit.add(itemDelete = new JMenuItem("Delete"));
        mFile.addSeparator();
        mEdit.add(itemSearch = new JMenuItem("Search with Bing..."));
        mEdit.add(itemFind = new JMenuItem("Find..."));
        mEdit.add(itemFindNext = new JMenuItem("Find Next"));
        mEdit.add(itemFindPrevious = new JMenuItem("Find Previous"));
        mEdit.add(itemReplace = new JMenuItem("Replace..."));
        mEdit.add(itemGoto = new JMenuItem("Go To..."));
        mEdit.addSeparator();
        mEdit.add(itemSelectAll = new JMenuItem("Select All"));
        mEdit.add(itemTimeDate = new JMenuItem("Time/Date"));

        //tao item va add vao menu Format
        mFormat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap"));
        mFormat.add(itemFont = new JMenuItem("Font..."));

        //tao item va add vao menu View
        mView.add(mZoom = new JMenu("Zoom"));
        mZoom.add(itemZoomIn = new JMenuItem("Zoom In"));
        mZoom.add(itemZoomOut = new JMenuItem("Zoom Out"));
        mZoom.add(itemRestore = new JMenuItem("Restore Default Zoom"));
        mView.add(itemStatus = new JCheckBoxMenuItem("Status Bar"));

        //tao item va add vao menu View
        mHelp.add(itemViewHelp = new JMenuItem("View Help"));
        mHelp.add(itemSendFeedback = new JMenuItem("Send Feedback"));
        mHelp.addSeparator();
        mHelp.add(itemAbout = new JMenuItem("About Notepad"));

        //tao to hop phim
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK + KeyEvent.SHIFT_DOWN_MASK));
        itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        itemSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindNext.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.CTRL_DOWN_MASK));
        itemFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        itemTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, KeyEvent.CTRL_DOWN_MASK));
        itemZoomIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, KeyEvent.CTRL_DOWN_MASK));
        itemZoomOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_DOWN_MASK));
        itemRestore.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, KeyEvent.CTRL_DOWN_MASK));
        //gan thuc don vao cua so
        setJMenuBar(mBar);
    }

    public static void main(String[] args) {
        JNotepad notepad = new JNotepad("Demo Notepad");
        notepad.setVisible(true);
    }

    private void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollEditor = new JScrollPane(txtEditor);
        add(scrollEditor);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    private void processEvent() {
        itemZoomIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size += 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemZoomOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size -= 4;
                txtEditor.setFont(new Font("Arial", Font.PLAIN, size));
            }
        });
        itemWrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itemWrap.isSelected()) {
                    txtEditor.setLineWrap(true);
                } else {
                    txtEditor.setLineWrap(false);
                }
            }
        });
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        itemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
            }
        });
        itemCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyText();
            }
        });
        itemPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pasteText();
            }
        });
    }

    private void openFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(dlgFile.getSelectedFile());
                byte[] b = new byte[fis.available()];
                fis.read(b);
                txtEditor.setText(new String(b));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi doc file");
            }
        }
    }

    private void saveFile() {
        JFileChooser dlgFile = new JFileChooser();
        if (dlgFile.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                FileOutputStream fos = new FileOutputStream(dlgFile.getSelectedFile());
                fos.write(txtEditor.getText().getBytes());
                fos.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Loi ghi file");
            }
        }
    }

    private void copyText() {
        StringSelection selection = new StringSelection(txtEditor.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }

    private void pasteText() {
        try {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            String text = (String) clipboard.getData(DataFlavor.stringFlavor);
            txtEditor.insert(text, txtEditor.getCaretPosition());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error pasting text: " + e.getMessage());
        }
    }

    private void createToolBar() {
        toolBar = new JToolBar();

        toolBar.add(btNew = new JButton("New"));
        toolBar.add(btOpen = new JButton("Open"));
        toolBar.add(btSave = new JButton("Save"));
        btNew.setIcon(new ImageIcon(this.getClass().getResource("/images/new.png")));
        btOpen.setIcon(new ImageIcon(this.getClass().getResource("/images/open.png")));
        btSave.setIcon(new ImageIcon(this.getClass().getResource("/images/save.png")));
        add(toolBar, BorderLayout.NORTH);
        btOpen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                openFile();
            }
        });
        btSave.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                saveFile();
            }
        });
        btNew.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                txtEditor.setText("");
            }
        });
    }
}
