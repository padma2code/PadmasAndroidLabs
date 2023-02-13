package algonquin.cst2335.alur0001;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Switch;

import algonquin.cst2335.alur0001.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        String emailAddress = prefs.getString("EmailAddress", "");
        if(emailAddress != "") {
            binding.editTextTextEmailAddress.setText(emailAddress);
        }



        binding.button.setOnClickListener(btn -> {
            Intent nextPage = new Intent( MainActivity.this, SecondActivity.class);
            nextPage.putExtra( "EmailAddress", binding.editTextTextEmailAddress.getText().toString() );
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("EmailAddress", binding.editTextTextEmailAddress.getText().toString());
            editor.apply();
            startActivity(nextPage);


        });

    }
}