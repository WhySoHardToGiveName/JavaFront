import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class ReserveGrid extends JPanel {
    private int row;
    private String name;
    private JPanel grid;

    public ReserveGrid(int row, String name) {
        this.row = row;
        this.name = name;
        this.init();
        this.setVisible(true);
    }
    private void init(){
        this.setLayout(null);
        grid = new JPanel(new GridLayout(row, 12,3,3));
        grid.setBounds(40,0,12*52+6,row*50+6);
        grid.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        this.add(grid);
        for(int i = 0;i < row * 12;i++){
            JButton btn = new JButton("<html><body>可包场<br/>或拼场</body></html>");
            btn.setBackground(Color.WHITE);
            btn.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
            btn.setSize(new Dimension(50,50));
            grid.add(btn);
        }
        for(int i = 0;i < row;i++){
            JLabel label = new JLabel((i + 1) + "号场");
            this.add(label);
            label.setBounds(0, i*50, 40, 50);
        }
    }
}
