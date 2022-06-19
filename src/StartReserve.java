import javax.swing.*;
import java.awt.*;

public class StartReserve extends JFrame {
    private int maxNum;
    private int minNum;
    private String courtName;
    private boolean selectType; //选择预约类型 true:包场 false:拼场
    private boolean canPin; //是否可以拼场
    private boolean canBao; //是否可以包场
    private String[] friendList;
    private int curNum = 0;
    private String startTime;
    private JLabel infoLabel;

    public StartReserve(int maxNum, int minNum, String courtName, boolean canPin, boolean canBao, String startTime) {
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.courtName = courtName;
        this.canPin = canPin;
        this.canBao = canBao;
        this.startTime = startTime;
        this.init();
        this.setVisible(true);
    }
    private void init() {
        this.setTitle(courtName + "预约");
        this.setSize(700, 700);
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
        friendList = new String[5];
        friendList[0] = "20373324陈百铭";
        friendList[1] = "20373324陈百铭";
        friendList[2] = "20373324陈百铭";
        friendList[3] = "20373324陈百铭";
        friendList[4] = "20373324陈百铭";
        JLabel friendLabel = new JLabel("好友列表");
        this.add(friendLabel);
        friendLabel.setFont(new Font("微软雅黑", Font.BOLD, 15));
        friendLabel.setBounds(50, 120, 500, 15);

    }
}
