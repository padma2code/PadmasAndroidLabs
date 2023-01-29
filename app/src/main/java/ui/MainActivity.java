package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import algonquin.cst2335.alur0001.databinding.ActivityMainBinding;
import data.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding variableBinding;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        //Button b = findViewById(R.id.button);
        //TextView tv =findViewById(R.id.TextviewHelloWorld);
        //EditText et = findViewById(R.id.editText);

        variableBinding = ActivityMainBinding.inflate(getLayoutInflater());
        variableBinding.mySwitch.setChecked(viewModel.isSelected.getValue());

        // Get values from View Model by observing
        viewModel.isSelected.observe(this, newBooleanValue -> {
                variableBinding.mySwitch.setChecked(newBooleanValue);
                variableBinding.myCheckBox.setChecked(newBooleanValue);
                variableBinding.myRadio.setChecked(newBooleanValue);
        });


            //Set Toast for Image BTN Height and Width
            variableBinding.imageBTN.setOnClickListener( imageBTN -> {


                Toast
                        .makeText(MainActivity.this,  "The width = " + String.valueOf(variableBinding.imageBTN.getWidth()) + " and height = " + String.valueOf(variableBinding.imageBTN.getHeight()),Toast.LENGTH_LONG)
                        .show();

            });

            //Set Toast on Compound buttons status change
            variableBinding.mySwitch.setOnCheckedChangeListener(( whichButton , isChecked) -> {
            viewModel.isSelected.postValue(isChecked);

            Toast
                    .makeText(MainActivity.this,  "The value is now:"+isChecked,Toast.LENGTH_LONG)
                    .show();

        });

        //Get Text value from View Model for edittext,textview and button
        variableBinding.editText.setText(viewModel.editTextContents);
        variableBinding.TextviewHelloWorld.setText(viewModel.editTextContents);
        variableBinding.button.setText(viewModel.editTextContents);

        //changing the value to true for compound buttons
        variableBinding.mySwitch.setChecked(true);
        variableBinding.myRadio.setChecked(true);
        variableBinding.myCheckBox.setChecked(true);
        setContentView(variableBinding.getRoot());



        //on click listener for button
        variableBinding.button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            //tv.setText("You Clicked Button");
            //et.setText("You Clicked Button");
            //b.setText("You Clicked Button");
            viewModel.editTextContents = "You Clicked Button!";

            variableBinding.editText.setText(viewModel.editTextContents);
            variableBinding.TextviewHelloWorld.setText(viewModel.editTextContents);
            variableBinding.button.setText(viewModel.editTextContents);
            variableBinding.mySwitch.setChecked(true);
            variableBinding.myRadio.setChecked(true);
            variableBinding.myCheckBox.setChecked(true);

            //variableBinding.button.setText("You Clicked Button");
            //variableBinding.editText.setText("You Clicked Button");
            //variableBinding.TextviewHelloWorld.setText("You Clicked Button");
        }
    });
    }
}