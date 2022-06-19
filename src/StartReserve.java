import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class StartReserve extends JFrame {
    private int maxNum;
    private int minNum;
    private String courtName;
    private boolean selectType; //选择预约类型 true:包场 false:拼场
    private boolean canPin; //是否可以拼场
    private boolean canBao; //是否可以包场
    private String[] friendList;
    private String startTime;
    private JLabel infoLabel;
    private ArrayList<String> selectedList = new ArrayList<>();
    private JButton pinButton, baoButton;
    private GymIntro gym;

    public StartReserve(int maxNum, int minNum, String courtName, boolean canPin, boolean canBao, String startTime, GymIntro gym) {
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.courtName = courtName;
        this.canPin = canPin;
        this.canBao = canBao;
        this.startTime = startTime;
        this.gym = gym;
        this.init();
        this.addListener();
        this.setVisible(true);
    }
    private void init() {
        this.setTitle(courtName + "预约");
        this.setSize(500, 700);
        this.setLocation(400, 200);
        this.setLayout(null);
        String tomorrow = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(new java.util.Date().getTime() + 24 * 60 * 60 * 1000));
        infoLabel = new JLabel(courtName + " " + tomorrow + " " + startTime + ":00-" + (Integer.parseInt(startTime) + 1) + ":00");
        this.add(infoLabel);
        infoLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        infoLabel.setBounds(30, 10, 500, 20);
        JLabel inviteLabel = new JLabel("邀请好友");
        this.add(inviteLabel);
        inviteLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        inviteLabel.setBounds(50, 40, 500, 15);
        JLabel pinLabel;
        if(canPin) {
            pinLabel = new JLabel("拼场预约：最多可邀请好友" + (maxNum - 1) + "人");
        } else {
            pinLabel = new JLabel("当前场地不支持拼场预约");
        }
        this.add(pinLabel);
        pinLabel.setBounds(50, 60, 500, 15);
        JLabel baoLabel;
        if(canBao) {
            baoLabel = new JLabel("包场预约：最少邀请好友" + (minNum - 1) +"人，最多可邀请" + (maxNum - 1) + "人");
        } else {
            baoLabel = new JLabel("当前场地不支持包场预约");
        }
        this.add(baoLabel);
        baoLabel.setBounds(50, 80, 500, 15);
        //forGetFriends(MainFrame.loginID);
        selectedList.add(MainFrame.loginID);
        friendList = new String[5];
        friendList[0] = "20373324:陈百铭";
        friendList[1] = "20373325:陈百铭";
        friendList[2] = "20373326:陈百铭";
        friendList[3] = "20373327:陈百铭";
        friendList[4] = "20373328:陈百铭";
        JLabel friendLabel = new JLabel("好友列表");
        this.add(friendLabel);
        friendLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        friendLabel.setBounds(50, 120, 500, 15);
        for(int i = 0; i < friendList.length; i++) {
            //添加勾选框
            JCheckBox checkBox = new JCheckBox();
            this.add(checkBox);
            checkBox.setBounds(50, 140 + i * 20, 20, 20);
            int finalI = i;
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (checkBox.isSelected()) {
                        selectedList.add(friendList[finalI].split(":")[0]);
                    } else {
                        selectedList.remove(friendList[finalI].split(":")[0]);
                    }
                }
            });
            JLabel label = new JLabel(friendList[i]);
            this.add(label);
            label.setBounds(70, 140 + i * 20, 500, 15);
        }
        if(canPin) {
            pinButton = new JButton("拼场预约");
            this.add(pinButton);
            pinButton.setBounds(100, 600, 100, 30);
        }
        if(canBao) {
            baoButton = new JButton("包场预约");
            this.add(baoButton);
            baoButton.setBounds(300, 600, 100, 30);
        }
    }
    private void addListener() {
        if(canPin) {
            pinButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(selectedList.size() > maxNum) {
                        JOptionPane.showMessageDialog(null, "最多可邀请" + (maxNum - 1) + "人");
                    } else {
                        forReserve(selectedList, false, startTime, courtName, gym);
                    }
                }});
        }
        if(canBao) {
            baoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(selectedList.size() < minNum) {
                        JOptionPane.showMessageDialog(null, "请至少邀请" + (minNum - 1) + "人");
                    } else if(selectedList.size() > maxNum) {
                        JOptionPane.showMessageDialog(null, "最多可邀请" + (maxNum - 1) + "人");
                    } else {
                        forReserve(selectedList, true, startTime, courtName, gym);
                    }
                }});
        }
    }
    public void forGetFriends(String studentID) {
        JSONObject obj = new JSONObject();
        obj.put("studentID", studentID);
        String url = "http://localhost:8080/getStudentInfoByID";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){
//            String[] arr = MyFriend.objectToStringArray(res.get("friendList"));
            JSONArray jsonArray = res.getJSONArray("friendList");
            this.friendList = new String[jsonArray.length()];
            for(int i = 0; i < jsonArray.length(); i++) {
                this.friendList[i] = jsonArray.getString(i);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }
    }
    public void forReserve(ArrayList<String> selectedList, boolean type, String reservationTime, String stadiumName, GymIntro gym) {
        JSONObject obj = new JSONObject();
        obj.put("selectedList", selectedList);
        obj.put("type", type);
        obj.put("reservationTime", reservationTime);
        obj.put("stadiumName", stadiumName);
        String url = "http://localhost:8080/reserve";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){
            JOptionPane.showMessageDialog(null, "预约成功");
            this.dispose();
            gym.dispose();
        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }
    }
}
