package algonquin.cst2335.alur0001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*Room T318, THursday 10am (Tomorrow)
*/



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.button);
        TextView tv =findViewById(R.id.TextviewHelloWorld);
        EditText et = findViewById(R.id.editText);


 b.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            tv.setText("You Clicked Button");
            et.setText("You Clicked Button");
            b.setText("You Clicked Button");
        }
    });
    }
}