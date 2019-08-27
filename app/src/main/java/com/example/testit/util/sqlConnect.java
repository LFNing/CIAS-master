package com.example.testit.util;
import java.sql.*;
//该类实现与数据库连接以及与数据库相关功能的实现，目前不齐
public class sqlConnect {
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;
    static final String url="";
    static final String username="";
    static final String password="";//未建立连接，简约显示

    public sqlConnect(){
        //获取连接并用conn存储，暂未实现
    }
    /*public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/usersdata";
        String userName = "root";
        String password="199902";
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("找不到驱动！");
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(url,userName,password);
            if(conn!=null){
                System.out.println("connection successful");
            }
        }catch (SQLException e){
            System.out.println("connection fail");
            e.printStackTrace();
        }
        return conn;
    }

    public boolean login(String username,String password){
        String stat = "select * from standard_data where name like " + username;
        String pw=null;
        boolean isMatch=false;
        try{
           conn = this.getConnection();//连接数据库
           ps = conn.prepareStatement(stat);//创建Statement并执行参数
           rs = ps.executeQuery();//执行sql语句
           while(rs.next()){
               pw=rs.getString("password");
               break;
           }
           if (pw!=null&&pw.equals(password))
               isMatch=true;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {//释放资源
            try{
                rs.close();
                ps.close();
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return isMatch;
    }*/

}
