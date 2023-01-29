package ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import algonquin.cst2335.alur0001.databinding.ActivityMainBinding;
import data.MainViewModel;

/*Room T318, THursday 10am (Tomorrow)
*/



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

        variableBinding.editText.setText(viewModel.editTextContents);
        variableBinding.TextviewHelloWorld.setText(viewModel.editTextContents);
        variableBinding.button.setText(viewModel.editTextContents);
        setContentView(variableBinding.getRoot());


 variableBinding.button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            //tv.setText("You Clicked Button");
            //et.setText("You Clicked Button");
            //b.setText("You Clicked Button");
            viewModel.editTextContents = "You Clicked Button!";
            //variableBinding.button.setText("You Clicked Button");
            //variableBinding.editText.setText("You Clicked Button");
            //variableBinding.TextviewHelloWorld.setText("You Clicked Button");
        }
    });
    }
}