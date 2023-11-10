package com.example.simplecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    // initialosation of buttons
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9,
            buttonadd, buttonsub, buttonmul, buttondevide, button0, buttonequals, buttonclear;
    TextView textview;
    TextView textview2;
    Button advanceHistory;
    private List<String> historyList = null;
    private final String ADVANCE_WITH_HISTORY = "ADVANCE-WITH HISTORY";
    private final String STANDARD_NO_HISTORY = "STANDARD-NO HISTORY";


    boolean isAdvanceHistoryFlag = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Accessing buttons by id

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);
        button0 = findViewById(R.id.btn_zero);
        buttonadd = findViewById(R.id.btn_add);
        buttonsub = findViewById(R.id.btn_sub);
        buttonmul = findViewById(R.id.btn_mul);
        buttondevide = findViewById(R.id.btn_devide);
        buttonclear = findViewById(R.id.btn_clear);
        buttonequals = findViewById(R.id.btn_equals);
        textview = findViewById(R.id.result);

        advanceHistory = findViewById(R.id.btn_history);
        // textview2 = findViewById(R.id.text_history);
        textview2 = findViewById(R.id.text_history);


        //Onclick listners

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textview.setText(textview.getText() + "1");


            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                textview.setText(textview.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "0");
            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "+");
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "-");
            }
        });
        buttonmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "*");
            }
        });

        buttondevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText(textview.getText() + "/");
            }
        });


        //Clear button
        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText("");

            }
        });

        //Equals button
        buttonequals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // throw new RuntimeException();
                textview.setText(textview.getText() + "=");

                Button btn = (Button) v;
                String btnString = btn.getText().toString();


                try {

                    Calculator calculator = new Calculator();
                    calculator.push(textview.getText().toString());
                    int result = calculator.calculate();
                    textview.setText(textview.getText() + "" + result);
                } catch (CalculatorException ex) {
                    textview.setText(textview.getText() + "" + ex.getErrorMessage());
                    if (ex.getErrorCode() == 1001) {
                        // Toast.makeText(this, "",Toast.LENGTH_LONG).show();
                        Toast.makeText(MainActivity.this, "invalid input ", Toast.LENGTH_SHORT).show();
                        // Toast.makeText(MainActivity.this,ex.getErrorMessage(),Toast.LENGTH_SHORT).show();
                    } else if (ex.getErrorCode() == 1002) {
                    }
                } finally {

                    if (isAdvanceHistoryFlag) {
                        historyList.add(textview.getText().toString());
                        textview2.setText(String.join("\n", historyList));

                    } else if (!isAdvanceHistoryFlag) {
                        // clearHistory();
                        textview2.setText(" ");
                    }
                }

            }
        });


        advanceHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String btnDisplayString = advanceHistory.getText().toString();

                if (ADVANCE_WITH_HISTORY.equals(btnDisplayString)) {
                    isAdvanceHistoryFlag = true;
                    advanceHistory.setText(STANDARD_NO_HISTORY);
                    //  advanceHistory.setBackgroundColor(Color.BLUE);
                    initHistory();

                    ((MyApp) getApplication()).isAdvanceHistoryFlag = true;

                } else if (STANDARD_NO_HISTORY.equals(btnDisplayString)) {
                    isAdvanceHistoryFlag = false;
                    advanceHistory.setText(ADVANCE_WITH_HISTORY);
                    // advanceHistory.setBackgroundColor(Color.CYAN);
                    clearHistory();
                    ((MyApp) getApplication()).isAdvanceHistoryFlag = false;

                }
                textview.setText("");
                textview2.setText(" ");

            }


        });

    }


    private void initHistory() {

        if (historyList == null) {
            historyList = new ArrayList<>();
        }
    }

    private void clearHistory() {
        if (historyList != null) {
            historyList = null;
        }
    }


}