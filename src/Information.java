import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Information extends JPanel {
    private JLabel title = new JLabel("场馆信息");
    //插入图片
    private ImageIcon badminton = new ImageIcon("src/img/badminton.jpg");
    private JLabel badmintonLabel = new JLabel(badminton);
    private ImageIcon basketball = new ImageIcon("src/img/basketball2.jpg");
    private JLabel basketballLabel = new JLabel(basketball);
    private ImageIcon football = new ImageIcon("src/img/football2.jpg");
    private JLabel footballLabel = new JLabel(football);
    private ImageIcon tennis = new ImageIcon("src/img/tennis2.jpg");
    private JLabel tennisLabel = new JLabel(tennis);
    private ImageIcon volleyball = new ImageIcon("src/img/volleyball2.jpg");
    private JLabel volleyballLabel = new JLabel(volleyball);
    private ImageIcon tabletennis = new ImageIcon("src/img/tabletennis2.jpg");
    private JLabel tabletennisLabel = new JLabel(tabletennis);
    private JLabel badmintonWord = new JLabel("羽毛球场");
    private JLabel basketballWord = new JLabel("篮球场");
    private JLabel footballWord = new JLabel("足球场");
    private JLabel tennisWord = new JLabel("网球场");
    private JLabel volleyballWord = new JLabel("排球场");
    private JLabel tabletennisWord = new JLabel("乒乓球场");

    public Information() {
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
        Font fo = new Font("微软雅黑", Font.BOLD, 20);
        badmintonWord.setFont(fo);
        basketballWord.setFont(fo);
        footballWord.setFont(fo);
        tennisWord.setFont(fo);
        volleyballWord.setFont(fo);
        tabletennisWord.setFont(fo);
        this.add(badmintonWord);
        badmintonWord.setBounds(170, 70, 150, 30);
        this.add(basketballWord);
        basketballWord.setBounds(580, 70, 150, 30);
        this.add(footballWord);
        footballWord.setBounds(980, 70, 150, 30);
        this.add(tennisWord);
        tennisWord.setBounds(180, 330, 150, 30);
        this.add(volleyballWord);
        volleyballWord.setBounds(580, 330, 150, 30);
        this.add(tabletennisWord);
        tabletennisWord.setBounds(970, 330, 150, 30);
        this.add(badmintonLabel);
        badmintonLabel.setBounds(100, 100, 220, 170);
        this.add(basketballLabel);
        basketballLabel.setBounds(500, 100, 220, 170);
        this.add(footballLabel);
        footballLabel.setBounds(900, 100, 220, 170);
        this.add(tennisLabel);
        tennisLabel.setBounds(100, 360, 220, 170);
        this.add(volleyballLabel);
        volleyballLabel.setBounds(500, 360, 220, 170);
        this.add(tabletennisLabel);
        tabletennisLabel.setBounds(900, 360, 220, 170);
    }
    private void addListener() {
        badmintonLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("羽毛球", "src/img/badminton.jpg", "9：00-21:00", "否", 10, 2, 4,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
        basketballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("篮球", "src/img/basketball2.jpg", "8：00-22:00", "是", 15, 1, 10,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
        footballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("足球", "src/img/football2.jpg", "8：00-22:00", "是", 3, 1, 20,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
        tennisLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("网球", "src/img/tennis2.jpg", "8：00-22:00", "否", 3, 2, 4,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
        volleyballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("排球", "src/img/volleyball2.jpg", "8：00-22:00", "是", 3, 1, 15,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
        tabletennisLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new GymIntro("乒乓球", "src/img/tabletennis2.jpg", "9：00-21:00", "否", 10, 2, 4,
                        "<html><body>数据版本<br/>v1.0.0<br/>啊<br/>啊<br/>啊</body></html>");
            }
        });
    }
}
