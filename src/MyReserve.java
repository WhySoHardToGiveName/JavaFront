import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MyReserve extends JPanel {
    private JLabel title = new JLabel("我的预约");

    public MyReserve() {
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
    }
}
