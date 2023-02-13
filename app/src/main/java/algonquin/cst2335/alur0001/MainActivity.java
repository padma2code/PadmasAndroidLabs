package algonquin.cst2335.alur0001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageView imgView;
    private static String tag = "MainActivity";
    private Object msg;

    @Override
    protected void onResume() {
        super.onResume();

        Log.w(tag, "In - On Resume - Loading Widgets");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(tag, "In - On Pause - Loading Widgets");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(tag, "In - On Destroy - Loading Widgets");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(tag, "In - On Stop - Loading Widgets");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(tag, "In - On Start - Loading Widgets");
    }

    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View loginButton = null;
        loginButton.setOnClickListener(clk -> {
            Intent nextPage = new Intent( MainActivity.this, SecondActivity.class);
            startActivity(nextPage);
        });

    }
}