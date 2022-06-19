import javax.swing.*;
import java.awt.*;

public class GymIntro extends JFrame {
    private String name;
    private String picture;
    private String openTime;
    private String support;
    private int num;
    private int min;
    private int max;
    private String intro;
    private JLabel nameLabel, pictureLabel, openTimeLabel, supportLabel, numLabel, minLabel, maxLabel;
    private JLabel introLabel;
    private ImageIcon pictureIcon;
    private JPanel reservePanel;

    public GymIntro(String name, String picture, String openTime, String support, int num, int min, int max, String intro) {
        this.name = name;
        this.picture = picture;
        this.openTime = openTime;
        this.support = support;
        this.num = num;
        this.min = min;
        this.max = max;
        this.intro = intro;
        this.init();
        this.setVisible(true);
    }
    public void init() {
        this.setTitle(name);
        this.setSize(800, 1000);
        this.setLocation(650, 20);
        this.setLayout(null);
        nameLabel = new JLabel(name);
        Font f = new Font("微软雅黑", Font.BOLD, 30);
        nameLabel.setFont(f);
        nameLabel.setForeground(Color.BLACK);
        this.add(nameLabel);
        nameLabel.setBounds(360, 10, 150, 40);
        pictureIcon = new ImageIcon(picture);
        pictureLabel = new JLabel(pictureIcon);
        this.add(pictureLabel);
        pictureLabel.setBounds(290, 60, 220, 170);
        openTimeLabel = new JLabel("开放时间：" + openTime);
        this.add(openTimeLabel);
        openTimeLabel.setBounds(30, 250, 200, 20);
        supportLabel = new JLabel("是否支持拼场预约：" + support);
        this.add(supportLabel);
        supportLabel.setBounds(30, 280, 200, 20);
        numLabel = new JLabel("场地数量：" + num);
        this.add(numLabel);
        numLabel.setBounds(30, 310, 200, 20);
        minLabel = new JLabel("预约人数下限：" + min);
        this.add(minLabel);
        minLabel.setBounds(30, 340, 200, 20);
        maxLabel = new JLabel("场地人数上限：" + max);
        this.add(maxLabel);
        maxLabel.setBounds(30, 370, 200, 20);
        introLabel = new JLabel(intro);
        this.add(introLabel);
        introLabel.setBounds(250, 250, 400, 100);
        String tomorrow = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(new java.util.Date().getTime() + 24 * 60 * 60 * 1000));
        JLabel dateLabel = new JLabel("预约日期：" + tomorrow);
        this.add(dateLabel);
        dateLabel.setBounds(250, 380, 200, 20);
        reservePanel = new ReserveGrid(5, "羽毛球");
        this.add(reservePanel);
        reservePanel.setBounds(30, 430, 700, 400);
        for (int i = 0; i < 13; i++) {
            JLabel label = new JLabel((9+i) + ":00");
            this.add(label);
            label.setBounds(55+i*52, 410, 40, 20);
        }
    }
}
