import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MyFriend extends JPanel {
    private JLabel title = new JLabel("我的好友");
    private JTextField newFriendID = new JTextField();
    private JButton addFriend = new JButton("添加好友");
    private JList friendList;


    public MyFriend() {
        this.init();
        this.addListener();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);
        this.add(title);
        title.setBounds(30, 10, 150, 50);
        Font f = new Font("微软雅黑", Font.BOLD, 30);
        title.setFont(f);
        title.setForeground(Color.BLACK);
        this.add(newFriendID);
        newFriendID.setBounds(30, 70, 150, 30);
        this.add(addFriend);
        addFriend.setBounds(180, 70, 100, 30);
        textSet(newFriendID);
        DefaultListModel<Object> l1 = new DefaultListModel<>();
        l1.addElement("20373324 陈百铭");
        l1.addElement("456");
        friendList = new JList(l1);
        friendList.setBounds(30, 110, 150, 300);
        this.add(friendList);
    }
    private void textSet(JTextField field) {
        field.setBackground(new Color(255, 255, 255));
        field.setPreferredSize(new Dimension(150, 28));
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
        field.setBorder(border);
        field.setText("请输入学号添加好友");
    }
    private void addListener() {
        addFriend.addActionListener(e -> {
            String id = newFriendID.getText();
            if (id.equals("")) {
                JOptionPane.showMessageDialog(null, "请输入学号");
            } else {
                JFrame frame = new JFrame("添加好友");
                frame.setSize(300, 200);
                frame.setLocation(500, 300);
                JLabel label = new JLabel("是否添加20373324陈百铭为好友？");
                JButton yes = new JButton("是");
                JButton no = new JButton("否");
                frame.setLayout(null);
                frame.add(label);
                label.setBounds(40, 10, 200, 30);
                frame.add(yes);
                yes.setBounds(50, 100, 60, 30);
                frame.add(no);
                no.addActionListener(e1 -> frame.dispose());
                no.setBounds(150, 100, 60, 30);
                frame.setVisible(true);
            }
        });
    }
}
