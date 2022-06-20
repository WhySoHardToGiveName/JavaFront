import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Notice extends JPanel {
    private JLabel title = new JLabel("通知");
    private JLabel label = new JLabel("北航学院路校区综合体育馆入馆须知(2022年6月)");
    private JLabel content;

    public Notice() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout(null);
        this.add(title);
        title.setBounds(30, 10, 150, 50);
        Font f = new Font("微软雅黑", Font.BOLD, 30);
        title.setFont(f);
        title.setForeground(Color.BLACK);
        this.add(label);
        label.setBounds(30, 80, 600, 20);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        content = new JLabel("<html><body>1.进入馆内锻炼者，须遵守馆内有关规定，服从管理员工的安排。<br>" +
                "2.体育教学须由教师带队集体进入场地，教学时间以外场馆有偿向校内师生开放，进入场馆需购票后到达指定场地，校外人员未经许可禁止入内。<br>" +
                "3.请保持馆内卫生，严禁在场馆内吸烟，不得随地吐痰、乱丢废弃物，严禁携带有色及含糖饮料入内。<br>" +
                "4.入馆须穿不掉色软底运动鞋，禁止穿皮鞋、黑底、高跟鞋等进入。<br>" +
                "5.严禁携带宠物入馆，严禁饮酒者、患有高血压、心脏病等人员入馆进行剧烈活动，1.2米以下儿童需在家长陪同下入馆，但禁止进入活动场地。<br>" +
                "6.入馆后注意言谈举止、文明礼让，不得在场馆内大声喧哗、乱写乱画，不能强占他人正在使用的场地，严禁在场馆内滋事斗殴。<br>" +
                "7.入馆后请妥善保管好个人贵重物品，如有丢失，责任自负。<br>" +
                "8.运动前做好必要的热身准备，以免运动时受伤，在场馆内发生一切运动损伤责任自负。<br>" +
                "9.要爱护公共设施，使用过程中如损坏应照价赔偿，严禁擅自动用馆内消防设施和电源，防止发生意外。<br>" +
                "10.如发生停电、火灾等重大事故，不要惊慌，听从管理人员指挥，有序撤离。<br>" +
                "11.凡举办参观、摄影、比赛等活动需租用场馆的，请提前到前台售票处办理预约登记手续。<br><body/><html/>");
        content.setBounds(30, 100, 1000, 250);
        content.setFont(new Font("微软雅黑", Font.BOLD, 15));
        this.add(content);
    }
}
