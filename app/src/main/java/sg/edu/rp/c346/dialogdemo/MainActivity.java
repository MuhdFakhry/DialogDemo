package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1;
    Button btnDemo2;
    TextView tvDemo2;
    Button btnDemo3;
    TextView tvDemo3;
    Button btnExercise;
    TextView tvExercise;
    Button btnDemo4;
    TextView tvDemo4;
    Button btnDemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnExercise = findViewById(R.id.buttonExercise);
        tvExercise = findViewById(R.id.textViewExercise);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);


        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                /*myBuilder.setTitle("Demo 1-Simple Android");
                myBuilder.setMessage("I can develop Android App");*/

                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one fo the Button below");
                myBuilder.setCancelable(false);

                //Configure the 'positive' button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");

                    }
                });

                //Configure the 'negative' button
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");

                    }
                });
                //Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });


        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("DEMO 3 - Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);

                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        btnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input_exercise, null);

                final EditText etNum1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNum2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Exercise 3");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        int num1 = Integer.parseInt(etNum1.getText().toString());
                        int num2 = Integer.parseInt(etNum2.getText().toString());
                        String sum = String.valueOf(num1 + num2);
                        tvExercise.setText("The sum is " + sum);

                    }
                });

                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }
        });

        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, 20, 00, true);
                myTimeDialog.show();
            }
        });


    }
}
