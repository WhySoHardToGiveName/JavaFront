import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class MyReserve extends JPanel {
    private JLabel title = new JLabel("我的预约");
    private JList resvList;
    private DefaultListModel<Object> l2;
    private JLabel label = new JLabel("场地名称                场地状态        预约开始时间        预约结束时间        当前人数:        当前成员姓名        ");

    public MyReserve() {
        this.init();
        this.setVisible(true);
    }

    private void init() {
        this.setLayout((new GridLayout(10,1,5,5)));
        this.add(title);
        title.setBounds(30, 10, 150, 50);
        Font f = new Font("微软雅黑", Font.BOLD, 30);
        title.setFont(f);
        title.setForeground(Color.BLACK);
        this.add(label);
        label.setBounds(35, 35, 5000, 200);
        label.setFont(new Font("微软雅黑", Font.BOLD, 20));
        label.setForeground(Color.BLACK);
        forGetResvs(MainFrame.loginID);
//        resvList = new JList(l2);
//        resvList.setBounds(30, 110, 600, 300);
//        this.add(resvList);
        new SimpleTable().init();
    }

    public class SimpleTable
    {
        JFrame jf = new JFrame("简单表格 - www.jb51.net");
        JTable table;
        //定义二维数组作为表格数据
        Object[][] tableData =
                {
                        new Object[]{"李清照" , 29 , "女"},
                        new Object[]{"苏格拉底", 56 , "男"},
                        new Object[]{"李白", 35 , "男"},
                        new Object[]{"弄玉", 18 , "女"},
                        new Object[]{"虎头" , 2 , "男"}
                };
        //定义一维数据作为列标题
        Object[] columnTitle = {"姓名" , "年龄" , "性别"};
        public void init()
        {
            //以二维数组和一维数组来创建一个JTable对象
            table = new JTable(tableData , columnTitle);
            table.setVisible(true);
            //将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
            MyReserve.this.add(table);
        }
    }

    public void forGetResvs(String studentID) {
//        DefaultListModel<Object> l = new DefaultListModel<>();
        JSONObject obj = new JSONObject();
        obj.put("studentID", studentID);
        String url = "http://localhost:8080/getStudentResvInfoByID";
        //发送 POST 请求
        String str = HttpRequest.sendPost( url, obj.toString());
        JSONObject res = new JSONObject(str);
        if(res.get("error").equals(0)){
//            String[] arr = MyFriend.objectToStringArray(res.get("friendList"));
            JSONArray jsonArray = res.getJSONArray("orderList");
//            System.out.println(jsonArray);
            for (int i = 0; i < jsonArray.length(); i++) {
                String tmp = jsonArray.getString(i);
                String[] token = tmp.split(" ");
                String str1 = "";
                int cnt = 0;
                for(String s: token){
                    cnt++;
//                    System.out.println(s);
                    if(cnt==1)
                        str1 += s;
                    else
                        str1 += s.split(":")[1];
                    if(cnt!=1 && s.split(":").length>2){
                        str1 += ":00";
                    }
                    switch (cnt){
                        case 1:
                            if(s.startsWith("羽毛")|| s.startsWith("乒乓")){
                                System.out.println("匹配");
                                break;
                            }
                            str1 += "   ";
                            break;
                        case 2:
                        case 3:
                            str1 += "        ";
                            break;
                        case 4:
                            str1 += "       ";
                            break;
                        default:
                    }
                    str1 += "            ";
                }

                JLabel resvs = new JLabel(str1);
                this.add(resvs);
                resvs.setBounds(35 , 35+(i+1)*50, 5000, 200);
                resvs.setFont(new Font("微软雅黑", Font.BOLD, 20));
                resvs.setForeground(Color.BLACK);
//                l.addElement(entry);
//                System.out.println(entry);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, res.get("msg"));
        }
        return;
    }
}
