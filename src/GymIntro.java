import javax.swing.*;

public class GymIntro extends JPanel {
    private String name;
    private String picture;
    private String openTime;
    private String support;
    private int num;
    private int min;
    private int max;
    private String intro;
    private JLabel nameLabel, pictureLabel, openTimeLabel, supportLabel, numLabel, minLabel, maxLabel, introLabel;
    private ImageIcon pictureIcon;

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
        this.setLayout(null);
        JLabel title = new JLabel(name);
    }
}
