package com.example.quinnh.sec_lab_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public enum  LoginSuccess{
        login(1),
        password(2),
        success(0);

        private  int intValue;
        LoginSuccess(int Value){
            intValue = Value;
        }
        public int getIntValue(){
            return intValue;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text_login = (TextView) findViewById(R.id.login_input);
        final TextView text_password = (TextView) findViewById(R.id.password_input);
        Button btnLogin = (Button) findViewById(R.id.login_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast ToastAskError = null;

                switch (Checklogin(text_login.getText().toString(), text_password.getText().toString())){
                    case login:
                        ToastAskError.makeText(getApplicationContext(),getString(R.string.err_message_login), ToastAskError.LENGTH_LONG).show();
                        text_login.requestFocus();
                        break;
                    case password:
                        ToastAskError.makeText(getApplicationContext(),getString(R.string.err_message_pass), ToastAskError.LENGTH_LONG).show();
                        text_password.requestFocus();
                        break;
                        default:
                            ToastAskError.makeText(getApplicationContext(), "Success", ToastAskError.LENGTH_LONG).show();

                }
            }
        });
    }
    LoginSuccess Checklogin (String text_login, String text_password){
        String holdLogin = "Quinn";
        String holdPassword = "Stuff";
        if(!(holdLogin.equals(text_login)))
        {
            return LoginSuccess.login;
        }

        if(!(holdPassword.equals(text_password)))
        {
            return LoginSuccess.password;
        }

        return  LoginSuccess.success;
    }
}
