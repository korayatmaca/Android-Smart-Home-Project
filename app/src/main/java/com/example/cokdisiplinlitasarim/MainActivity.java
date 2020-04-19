package com.example.cokdisiplinlitasarim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login_Button, exit_Button,blue_Button;
    String address = null;
    String address2 = null;
    public static String EXTRA_EXTRA_ADDRESS = "device_address";
    public static String EXTRA_ADDRESS = "device_address";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);
        login_Button = (Button) findViewById(R.id.logBut);
        exit_Button = (Button)findViewById(R.id.exitButton);
        blue_Button = (Button)findViewById(R.id.bluetooth_button);


        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {

                    //admin ekranı gelir
                    //Admin tüm sistemi kapatma yetkisine sahiptir
                    //Admin sistemin tüm yükünü görüntüleyebilir.

                    Intent myIntent = new Intent(MainActivity.this, AdminActivity.class);

                    Intent intent = getIntent();
                    address = intent.getStringExtra(EXTRA_ADDRESS);
                    address2 = address;
                    myIntent.putExtra(EXTRA_EXTRA_ADDRESS,address2);

                    MainActivity.this.startActivity(myIntent);


                } else if (username.getText().toString().equals("1") && password.getText().toString().equals("1")) {
                    //Daire1 ekranı gelir
                    Intent userIntent = new Intent(MainActivity.this, UserActivity.class);

                    Intent intent = getIntent();
                    address = intent.getStringExtra(EXTRA_ADDRESS);
                    address2 = address;
                    userIntent.putExtra(EXTRA_EXTRA_ADDRESS,address2);

                    MainActivity.this.startActivity(userIntent);
                    //daire1 kendisini kapatabilir
                    //daire1 yüklerini görebilir

                } else if (username.getText().toString().equals("2") && password.getText().toString().equals("2")) {
                    //Daire2 ekranı gelir
                    //daire2 kendisini kapatabilir
                    //daire2 yüklerini görebilir

                    Intent us2Intent = new Intent(MainActivity.this, User2Activity.class);

                    Intent intent = getIntent();
                    address = intent.getStringExtra(EXTRA_ADDRESS);
                    address2 = address;
                    us2Intent.putExtra(EXTRA_EXTRA_ADDRESS,address2);

                    MainActivity.this.startActivity(us2Intent);

                } else {
                    //kullanıcı adı veya password hatalı.
                    shakeAnim();
                    Toast.makeText(getApplicationContext(), "Hatalı giriş yapıldı", Toast.LENGTH_LONG).show();


                }
            }
        });

        exit_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //uygulama kapatılır.
                finish();
            }
        });


        blue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bluetoothIntent = new Intent(MainActivity.this, BTActivity.class);
                MainActivity.this.startActivity(bluetoothIntent);
            }
        });
    }

    private void shakeAnim(){
        Animation shake = AnimationUtils.loadAnimation(this,R.anim.shake);
        password.startAnimation(shake);
        username.startAnimation(shake);

    }

}




