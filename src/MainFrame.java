import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends JFrame{
    private JMenuBar jmb = new JMenuBar();
    private JMenuItem jm1 = new JMenu("场馆预约");
    private JMenuItem jm3 = new JMenu("我的预约");
    private JMenuItem jm4 = new JMenu("我的好友");
    private JMenuItem jm5 = new JMenu("通知");
    private JPanel contentPanel;
    private int currentPanel = 1;
    public static String loginID;

    public MainFrame(String loginID){
        this.init();
        this.addListener();
        this.setVisible(true);
        contentPanel = new Information();
        currentPanel = 1;
        MainFrame.this.add(contentPanel);
        contentPanel.setBounds(0, 0, 1200, 700);
        contentPanel.setVisible(true);
        this.loginID = loginID;
    }

    private void init() {
        this.setTitle("场馆预约系统");
        this.setSize(1200, 700);
        this.setLocation(400, 200);
        this.setJMenuBar(jmb);
        jmb.add(jm1);
        jmb.add(jm3);
        jmb.add(jm4);
        jmb.add(jm5);
    }

    private void addListener() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        jm1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentPanel != 1) {
                    if(contentPanel != null) {
                        MainFrame.this.remove(contentPanel);
                    }
                    contentPanel = new Information();
                    currentPanel = 1;
                    MainFrame.this.add(contentPanel);
                    contentPanel.setBounds(0, 0, 1200, 700);
                    contentPanel.setVisible(true);
                }
            }
        });
        jm3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentPanel != 3) {
                    if(contentPanel != null) {
                        MainFrame.this.remove(contentPanel);
                    }
                    contentPanel = new MyReserve();
                    currentPanel = 3;
                    MainFrame.this.add(contentPanel);
                    contentPanel.setBounds(0, 0, 1200, 700);
                    contentPanel.setVisible(true);
                }
            }
        });
        jm4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(currentPanel != 4) {
                    if(contentPanel != null) {
                        MainFrame.this.remove(contentPanel);
                    }
                    contentPanel = new MyFriend();
                    currentPanel = 4;
                    MainFrame.this.add(contentPanel);
                    contentPanel.setBounds(0, 0, 1200, 700);
                    contentPanel.setVisible(true);
                }
            }
        });
        jm5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(currentPanel != 5) {
                    if(contentPanel != null) {
                        MainFrame.this.remove(contentPanel);
                    }
                    contentPanel = new Notice();
                    currentPanel = 5;
                    MainFrame.this.add(contentPanel);
                    contentPanel.setBounds(0, 0, 1200, 700);
                    contentPanel.setVisible(true);
                }
            }
        });
    }
}
