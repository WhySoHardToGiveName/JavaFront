import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyFriend extends JPanel {
    private JLabel title = new JLabel("我的好友");
    private JTextField newFriendID = new JTextField();
    private JButton addFriend = new JButton("添加好友");
    private JList friendList;
    private JLabel label = new JLabel("请输入学号添加好友");
    private DefaultListModel<Object> l1;

    public MyFriend() {
        this.init();
        this.addListener();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);
        this.add(title);
        this.add(label);
        label.setBounds(300, 35, 200, 100);
        title.setBounds(30, 10, 150, 50);
        Font f = new Font("微软雅黑", Font.BOLD, 30);
        title.setFont(f);
        title.setForeground(Color.BLACK);
        this.add(newFriendID);
        newFriendID.setBounds(30, 70, 150, 30);
        this.add(addFriend);
        addFriend.setBounds(180, 70, 100, 30);
        textSet(newFriendID);
        l1 = forGetFriends(MainFrame.loginID);
        friendList = new JList(l1);
        friendList.setBounds(30, 110, 150, 300);
        this.add(friendList);
    }
    private void textSet(JTextField field) {
        field.setBackground(new Color(255, 255, 255));
        field.setPreferredSize(new Dimension(150, 28));
        MatteBorder border = new MatteBorder(0, 0, 2, 0, new Color(192, 192, 192));
        field.setBorder(border);
        field.setText("");
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
                JLabel label = new JLabel("<html><body>是否添加学号为:<br/>"+id+"<br/>的用户为好友？</body></html>");
                JButton yes = new JButton("是");
                JButton no = new JButton("否");
                frame.setLayout(null);
                frame.add(label);
                label.setBounds(40, 10, 200, 100);
                frame.add(yes);
                yes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        forAddFriend(MainFrame.loginID, id);
//                        l1.addElement("1111");
                    }});
                yes.setBounds(50, 100, 60, 30);
                frame.add(no);
                no.addActionListener(e1 -> frame.dispose());
                no.setBounds(150, 100, 60, 30);
                frame.setVisible(true);
            }
        });
    }

    //添加好友
    public void forAddFriend(String studentIDA, String studentIDB) {
//        System.out.println(studentIDA+":"+studentIDB);
        JSONObject obj = new JSONObject();
        obj.put("studentIDA", studentIDA);
        obj.put("studentIDA", studentIDB);
        String url = "http://localhost:8080/";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){

        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }
    }

    //获取好友
    public DefaultListModel<Object> forGetFriends(String studentID) {
        DefaultListModel<Object> l1 = new DefaultListModel<>();
        /*
        JSONObject obj = new JSONObject();
        obj.put("studentIDA", studentID);
        String url = "http://localhost:8080/";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){
            String[] arr = (String[]) res.get("friendList");
            for(String tmp: arr){
                String name = tmp.split(":")[1];
                String id = tmp.split(":")[0];
                String entry = id + " " + name;
                l1.addElement(entry);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }
        */
        l1.addElement("20373376 李昱熙");
        l1.addElement("20373324 陈百铭");
        return l1;
    }
}
