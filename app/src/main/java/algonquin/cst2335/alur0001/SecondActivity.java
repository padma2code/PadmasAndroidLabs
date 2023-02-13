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
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import algonquin.cst2335.alur0001.databinding.ActivityMainBinding;
import algonquin.cst2335.alur0001.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ActivitySecondBinding binding2 = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding2.getRoot());
        SharedPreferences prefs = getSharedPreferences("MyData", Context.MODE_PRIVATE);

        String phoneNumber = prefs.getString("phoneNumber", "");
        if(phoneNumber != "") {
            binding2.editTextTextPersonName.setText(phoneNumber);
        }



        File file = new File( getFilesDir(), "Picture.png");

        if(file.exists())

        {
            Bitmap theImage = BitmapFactory.decodeFile(String.valueOf(file));
            binding2.profileImage.setImageBitmap( theImage );
        }


    binding2.button4.setOnClickListener(clk ->{

        finish();
    });


        binding2.button2.setOnClickListener(clk -> {


            Intent call = new Intent(Intent.ACTION_DIAL);
            call.setData(Uri.parse("tel:" + binding2.editTextTextPersonName.getText().toString()));
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("phoneNumber", binding2.editTextTextPersonName.getText().toString());
            editor.apply();
            startActivity(call);


        });

        Intent fromPrevious = getIntent();
        String emailAddress = fromPrevious.getStringExtra("EmailAddress");
        binding2.textView3.setText("Welcome back - "  + emailAddress);

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ActivityResultLauncher<Intent> cameraResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override

                    public void onActivityResult(ActivityResult result) {

                        if (result.getResultCode() == Activity.RESULT_OK) {

                            Intent data = result.getData();
                            Bitmap thumbnail = data.getParcelableExtra("data");
                            binding2.profileImage.setImageBitmap (thumbnail);
                            FileOutputStream fOut = null;




                            try { fOut = openFileOutput("Picture.png", Context.MODE_PRIVATE);

                                thumbnail.compress(Bitmap.CompressFormat.PNG, 100, fOut);

                                fOut.flush();

                                fOut.close();

                            }

                            catch (IOException e)

                            { e.printStackTrace();

                            }

                        }


                    }

                } );
        //Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        binding2.button3.setOnClickListener(click -> {

            cameraResult.launch(cameraIntent);
        });

    }
}