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
                GymIntro gym = new GymIntro("羽毛球场", "src/img/badminton.jpg", "9：00-21:00", "否", 8, 2, 4,
                        "<html><body>场地介绍： 羽毛球馆整体环境宽大舒适优雅。馆内拥有10块专业塑胶场地，采用专业侧面排光技术，双层龙骨硬木地板铺装方式，PU塑胶弹性地面，能有效地避免、减少运动损伤。在您充分运动之后，场地边也有充足的长椅，为您提供舒适的休息条件。</body></html>");
            }
        });
        basketballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GymIntro gym = new GymIntro("篮球场", "src/img/basketball2.jpg", "9：00-21:00", "是", 8, 6, 10,
                        "<html><body>场地介绍： 篮球场的设计整体风格明亮宽阔、简洁通透，具现代感。馆区设有两片标准篮球场，设施齐全。场馆可用于球队训练、篮球比赛、各种篮球训练营；场馆顶部配有64盏防炫灯，符合照度标准。</body></html>");
            }
        });
        footballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GymIntro gym = new GymIntro("足球场", "src/img/football2.jpg", "9：00-21:00", "是", 3, 10, 20,
                        "<html><body>场地介绍： 本足球场地环境优良，设备齐全。场地内铺设高密度人造草坪，草坪下铺设弹性垫，最大程度上贴近天然草，防止运动员受伤。场地配套设施有：主、客队休息室、更衣室、卫浴室。场内设施建设按照职业联赛的专业球场标准，设有观众休闲区，看台区，配套简餐水吧区、运动商品展示区、足球文化展区等。</body></html>");
            }
        });
        tennisLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GymIntro gym = new GymIntro("网球场", "src/img/tennis2.jpg", "9：00-21:00", "否", 3, 2, 4,
                        "<html><body>场地介绍： 网球场地环境优良，大方简约，地面由水泥和沥青铺垫而成，其上涂有红、绿色塑胶面层，其表面平整，硬度高。场地四周设有遮阳棚休息区，并且配套清流水吧，供球友们打球后休息。</body></html>");
            }
        });
        volleyballLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GymIntro gym = new GymIntro("排球场", "src/img/volleyball2.jpg", "9：00-21:00", "是", 3, 8, 15,
                        "<html><body>场地介绍： 排球场馆整体设计通透大方，一共可以容纳8033名观众。场馆使用的运动地板采用国际赛事专用品牌，专用的固定悬浮式结构、倒刺钢钉和固定地锚，保证了场地的品质；地板上的油漆更是控制摩擦系数在0.4到0.6，实现耐用和环保的效果；不论是承办大型赛事还是供爱好者们切磋球技都游刃有余。</body></html>");
            }
        });
        tabletennisLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GymIntro gym = new GymIntro("乒乓球场", "src/img/tabletennis2.jpg", "9：00-21:00", "否", 8, 2, 4,
                        "<html><body>场地介绍： 乒乓球场地面积合计1200平方米。馆内布局合理、设计新颖 , 配有30张标准乒乓球桌挡板若干，设有器材租赁处、男女更衣室以及电视、音响等系统，能够满足众多乒乓球爱好者的需求。</body></html>");
            }
        });
    }
}
