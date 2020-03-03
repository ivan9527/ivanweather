package com.example.ivanweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import interfaces.heweather.com.interfacesmodule.bean.Lang;
import interfaces.heweather.com.interfacesmodule.bean.Unit;
import interfaces.heweather.com.interfacesmodule.bean.grid.now.GridNow;
import interfaces.heweather.com.interfacesmodule.bean.weather.now.Now;
import interfaces.heweather.com.interfacesmodule.view.HeConfig;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        HeConfig.init("HE2002292329001260", "ea321263246745a385c875c1d1290010");
//        HeWeather.getWeatherNow(MainActivity.this,"CN101260101", Lang.CHINESE_SIMPLIFIED, Unit.METRIC,
//                new HeWeather.OnResultWeatherNowBeanListener(){
//
//                    @Override
//                    public void onError(Throwable throwable) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(Now now) {
//                        String data = new Gson().toJson(now)+"";
//                        Toast.makeText(MainActivity.this,  data, Toast.LENGTH_LONG).show();
//                    }
//                });


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.getString("weather",null) != null){

            Intent intent = new Intent(this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
