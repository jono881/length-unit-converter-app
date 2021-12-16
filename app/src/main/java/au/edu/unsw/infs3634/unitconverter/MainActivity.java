package au.edu.unsw.infs3634.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // declaring widgets
    EditText input;
    Button button;
    TextView outputCall;

    // creating Random and Converter objects
    Random random = new Random();
    Converter converter = new Converter();
    DecimalFormat df = new DecimalFormat("###.####");


    private static final String TAG = "DetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // don't change above code

        // reset activity screen to ask for specific input and output
        randomPairUnitsGenerator();

        // allows button to convert units and go to convert activity
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Code here executes on main thread after user presses button
                Log.d(TAG,  "onCreate: Starting Launch");

                // method used to calculate the input value
                calculateInput();

                // send Strings of original unit and value with desired unit and calculated value
                // to ConvertionActivity through intents
                Intent intent = new Intent(MainActivity.this, ConvertionActivity.class);
                intent.putExtra("input", Double.toString(converter.getInputValue()));

                // assigns output value to some significant figures
                Double output = converter.getOutputValue();
                if(output < 1 && output > 0){
                    // 12 decimal places if output is between 0 and 1
                    String outcome = String.format("%.12f",converter.getOutputValue());
                    intent.putExtra("output", outcome);
                }
                else if(output == 0){
                    String outcome = String.format("%.0f",converter.getOutputValue());
                    intent.putExtra("output", outcome);
                }
                else{
                    // 2 decimal places for all other values
                    String outcome = String.format("%.2f",converter.getOutputValue());
                    intent.putExtra("output", outcome);
                }
                intent.putExtra("input unit", converter.getUnit1());
                intent.putExtra("output unit", converter.getUnit2());
                startActivity(intent);
            }
        });

    }

    // method to receive and calculate user's input
    private void calculateInput(){

        // these lines of code can be put back into the onCreate method
        // recording input from editText field from activity_main.xml
        input = (EditText) findViewById(R.id.input_number);
        String inputString = input.getText().toString();
        // condition if there is no input from user, change the string to "0"
        if(inputString.matches("")){
            inputString = "0";
        }
        double inputUnit = Double.parseDouble(inputString);

        // create new object that gets inputUnit into a converter
        // Converter class conducts calculations on the input number
        converter.setInputValue(inputUnit);
        converter.setConstant(converter.getUnit1(), converter.getUnit2());
        converter.setOutputValue(inputUnit);
    }

    // method to randomise the input and output unit of measurement
    // should be used to call on user to type in value based on input unit
    private void randomPairUnitsGenerator(){


        // randomly find 2 units to show --> can include imperial units like in, ft, yd, mi later
        String[] units = {"millimetres", "centimetres", "metres", "kilometres", "inches", "feet", "yards", "miles"};
        String unitLabel1 = units[random.nextInt(units.length)];
        String unitLabel2 = units[random.nextInt(units.length)];
        // condition if both units are the same
        if (unitLabel1.equals(unitLabel2)){
            if(unitLabel1.equals("millimetres")){
                unitLabel2 = "inches";
            }
            else if (unitLabel1.equals("miles")){
                unitLabel2 = "kilometres";
            }
            else{
                unitLabel2 = "metres";
            }
        }

        // store units in converter object
        converter.setUnit1(unitLabel1);
        converter.setUnit2(unitLabel2);

        // prepare TextView and EditText widgets to change to random units demanded and desired
        outputCall = findViewById(R.id.desired_unit_text);
        input = (EditText) findViewById(R.id.input_number);
        outputCall.setText(unitLabel2);
        input.setHint("Enter value in " + unitLabel1);


    }
}