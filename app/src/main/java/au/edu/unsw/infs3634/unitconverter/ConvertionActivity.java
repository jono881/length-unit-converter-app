package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConvertionActivity extends AppCompatActivity {

    // declaring widgets
    Button button;
    TextView inputtedValue;
    TextView convertedValue;

    private static final String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertion);
        // don't change above!!

        // method to show output messages
        showConvertedValueMessage();

        // resets the converter to go back to main activity
        button = findViewById(R.id.reset_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
                Log.d(TAG,  "Return to main activity");
                Intent intent = new Intent(ConvertionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    // used to show final converted result
    private void showConvertedValueMessage(){

        // receive Strings through the intent from Main Activity
        Intent intentMessage = getIntent();
        String inputValueNum = intentMessage.getStringExtra("input");
        String outputValueNum = intentMessage.getStringExtra("output");
        String unit1 = intentMessage.getStringExtra("input unit");
        String unit2 = intentMessage.getStringExtra("output unit");

        // showing final result on ConvertionActivity
        String inputValue = inputValueNum + " " + unit1;
        String outputValue = outputValueNum + " " + unit2;
        inputtedValue = findViewById(R.id.input_number);
        convertedValue = findViewById(R.id.output_number);
        inputtedValue.setText(inputValue);
        convertedValue.setText(outputValue);

    }
}