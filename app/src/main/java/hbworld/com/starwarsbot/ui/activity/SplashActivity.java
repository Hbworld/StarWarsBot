package hbworld.com.starwarsbot.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.widget.Toast;

import hbworld.com.starwarsbot.R;
import hbworld.com.starwarsbot.utils.AppUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int secondsDelayed = 5;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                if(AppUtil.isNetworkAvailable(SplashActivity.this)) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                }else Toast.makeText(SplashActivity.this,getString(R.string.connect_to_internet),Toast.LENGTH_LONG).show();
            }
        }, secondsDelayed * 1000);
    }
}
