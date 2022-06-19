import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReserveGrid extends JPanel {
    private int row;
    private int maxNum;
    private int minNum;
    private String name;
    private JPanel grid;
    private String support;
    private GymIntro gym;

    public ReserveGrid(int row, String name, String support, int maxNum, int minNum, GymIntro gym) {
        this.row = row;
        this.name = name;
        this.support = support;
        this.maxNum = maxNum;
        this.minNum = minNum;
        this.gym = gym;
        this.init();
        this.setVisible(true);
    }
    private void init(){
        this.setLayout(null);
        grid = new JPanel(new GridLayout(row, 12,3,3));
        grid.setBounds(40,0,12*52+6,row*50+6);
        grid.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
        this.add(grid);
        // 发送请求查询场地预约信息
        JSONObject obj = new JSONObject();
        obj.put("placeName", name);
        String url = "http://localhost:8080/getReserveInfo";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){
//            String[] arr = MyFriend.objectToStringArray(res.get("friendList"));

//            System.out.println(count.getJSONArray(1).get(1));
//            System.out.println(canPin.get(1));
//            System.out.println(canBao.get(1));
            for(int i = 0;i < row;i++){
                for(int j = 0; j < 12; j++) {
                    JSONArray count = res.getJSONArray("count").getJSONArray(i);
                    JSONArray canPin = res.getJSONArray("canPin").getJSONArray(i);
                    JSONArray canBao = res.getJSONArray("canBao").getJSONArray(i);
                    JButton btn;
                    int finalJ = j;
                    int finalI = i+1;
                    if(support.equals("否")){
                        if(canBao.getInt(j)==1){
                            btn = new JButton("<html>可包场</html>");
                            btn.setBackground(Color.CYAN);
                            System.out.println(name+j+"号");
                            btn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new StartReserve(maxNum-count.getInt(finalJ), minNum,name+ finalI +"号",false,true,Integer.toString(finalJ+9), gym);
                                }});
                        }
                        else{
                            btn = new JButton("<html>已被预约</html>");
                            btn.setBackground(Color.RED);
                        }
                    }
                    else{
                        if(canBao.getInt(j)==1 && canPin.getInt(j)==1){
                            btn = new JButton("<html><body>可包场<br/>或拼场</body></html>");
                            btn.setBackground(Color.GREEN);
                            btn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new StartReserve(maxNum-count.getInt(finalJ), minNum,name+finalI+"号",true,true,Integer.toString(finalJ+9), gym);
                                }});
                        }
                        else if (canPin.getInt(j)==1 && canBao.getInt(j)==0){
                            btn = new JButton("<html><body>拼场</body></html>");
                            btn.setBackground(Color.ORANGE);
                            btn.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    new StartReserve(maxNum-count.getInt(finalJ), minNum,name+finalI+"号",true,false,Integer.toString(finalJ+9), gym);
                                }});
                        }
                        else{
                            btn = new JButton("<html>已被预约</html>");
                            btn.setBackground(Color.RED);
                        }
                    }

                    btn.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
                    btn.setSize(new Dimension(50, 50));
                    grid.add(btn);
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }



        //
        for(int i = 0;i < row;i++){
            JLabel label = new JLabel((i + 1) + "号场");
            this.add(label);
            label.setBounds(0, i*50, 40, 50);
        }
    }
}
