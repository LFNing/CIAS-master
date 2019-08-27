package com.example.testit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.testit.util.LoginUtil;
import com.example.testit.util.sqlConnect;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText username;
    private EditText userpassword;
    private LoginUtil loginUtil=new LoginUtil();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin= this.<Button>findViewById(R.id.btn_Login);
        username= this.<EditText>findViewById(R.id.userName);
        userpassword= this.<EditText>findViewById(R.id.userPassword);
        //final sqlConnect sc=new sqlConnect();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String un=username.getText().toString(),pw=userpassword.getText().toString();
                if (loginUtil.login(un,pw)) {
                    Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this,"登录失败，请检查用户名与密码！",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
