package com.example.testit.util;
//该类实现时间的同步显示
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class TimeSync {
    private TextView tView1,tView2;
    public TimeSync(TextView tv1,TextView tv2){
        tView1=tv1;
        tView2=tv2;
    }//通过改变tView1，tView2来显示实际那
    public void start(){
        timeRefresh.start();//开始刷新
    }
    private void setTime(TextView tv1,TextView tv2){
        DateUtil dateUtil=new DateUtil();
        tv1.setText(dateUtil.getDate());
        tv2.setText(dateUtil.getNowTime());
    }//时间显示

    private int what=1;
    private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    setTime(tView1,tView2);
                    break;
            }
            super.handleMessage(msg);

        }
    };//获取传递过来的信息，收到则再设置时间
    private Thread timeRefresh=new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                handler.sendEmptyMessage(what);
                try {
                    Thread.sleep(1000);//每秒发送1次，即时间每秒刷新
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    });
}
