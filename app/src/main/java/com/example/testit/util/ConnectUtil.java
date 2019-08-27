package com.example.testit.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectUtil {
    public static String doPostJson(String url,String params,String charset)throws Exception{
        try {
            //建立连接
            URL realURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)realURL.openConnection();

            //设置连接属性
            //设定请求的方法为“POST”，默认是GET
            conn.setRequestMethod("POST");
            //设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true，默认情况是false
            conn.setDoOutput(true);
            //设置是否从httpUrlConnection读入，默认情况下是true
            conn.setDoInput(true);
            //Post请求不能使用缓存
            conn.setUseCaches(false);

            //设置请求属性
            conn.setRequestProperty("Connection","Keep-Alive");
            conn.setRequestProperty("charset",charset);
            //设定传送的内容类型是json，utf——8字符编码
            conn.setRequestProperty("Content_Type","application/json;charset=UTF-8");
            //设置接受类型否则返回415错误
            conn.setRequestProperty("accept","application/json");
            //往服务器里面发送数据
            if(params!=null&&params.length()>0){
                byte[] writebytes = params.getBytes();
                //设置文件长度
                conn.setRequestProperty("Content_Length",String.valueOf(writebytes.length));
                //建立输出流，并写入数据
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(params.getBytes());
                outputStream.flush();
                outputStream.close();
            }

            //获得响应状态
            int retCode = conn.getResponseCode();
            if(retCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                String resultString ="";
                while ((line=reader.readLine())!=null){
                    resultString+=line;
                }
                return resultString;
            }else{
                return "连接失败！！！";
            }

        }catch (Exception e){
            e.printStackTrace();
            return "连接失败！！！";
        }
    }
}
