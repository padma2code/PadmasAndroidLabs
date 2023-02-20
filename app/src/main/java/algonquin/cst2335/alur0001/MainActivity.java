package algonquin.cst2335.alur0001;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



/**
 * The MainActivity class is the main activity for the password checker app.
 * It contains the UI elements and the password checker function.
 *
 * @author PadmaAluri
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = findViewById(R.id.editText);
        Button btn = findViewById(R.id.button);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            checkPassword(password);
        });
    }

    /**
     * This function checks if the entered password contains at least one uppercase letter,
     * one lowercase letter, one number, and one special character.
     *
     * @param password The password entered by the user.
     */
    protected void checkPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()_-+=\\|[{]};:'\",<.>/?";

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        if (hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            Toast.makeText(this, "Your password meets the requirements!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "You shall not pass!", Toast.LENGTH_LONG).show();
        }
    }
}
