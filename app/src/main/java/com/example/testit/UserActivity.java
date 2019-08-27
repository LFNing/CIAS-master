package com.example.testit;
//该类为完成登录后的用户界面显示
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.testit.util.TimeSync;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class UserActivity extends AppCompatActivity {

    private TextView date;
    private TextView time;
    private Button att;
    //private DateUtil dateUtil=new DateUtil();
   // private Timer timer = new Timer();
    /*private int what=1;
    public void setTime(){
        DateUtil dateUtil=new DateUtil();
        tv1.setText(dateUtil.getDate());
        tv2.setText(dateUtil.getNowTime());
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        date = this.<TextView>findViewById(R.id.date);
        time = this.<TextView>findViewById(R.id.time);
        TimeSync timesync=new TimeSync(date,time);
        att = this.<Button>findViewById(R.id.att);
        att.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        timesync.start();

       // timeRefresh.start();

        /*tv1.setText(dateUtil.getDate());
        tv2.setText(dateUtil.getNowTime());
        refresh rf = new refresh();*/
        //timer.schedule(timeRefresh,0,1000);
    }
    /*private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case 1:
                    setTime();
                    break;
            }
            super.handleMessage(msg);

        }
    };
    private Thread timeRefresh=new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                handler.sendEmptyMessage(what);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    });*/




}
