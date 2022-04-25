package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    NumberFormat nf;
    String numbers = "0", operation = null, results;
    Double total = 0.0, input_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txt_view);
        nf = NumberFormat.getInstance(Locale.US);
    }

    /* onClick methods */
    public void btn_one_click(View v) {
        number_builders("1");
    }
    public void btn_two_click(View v) {
        number_builders("2");
    }
    public void btn_three_click(View v) {
        number_builders("3");
    }
    public void btn_four_click(View v) {
        number_builders("4");
    }
    public void btn_five_click(View v) {
        number_builders("5");
    }
    public void btn_six_click(View v) {
        number_builders("6");
    }
    public void btn_seven_click(View v) {
        number_builders("7");
    }
    public void btn_eight_click(View v) {
        number_builders("8");
    }
    public void btn_nine_click(View v) {
        number_builders("9");
    }
    public void btn_zero_click(View v) {
        number_builders("0");
    }
    public void btn_dot_click(View v) {
        if (!numbers.contains(".")) {
            number_builders(".");
        }
    }
    public void btn_clear_click(View v) {
        numbers = "0";
        total = 0.0;
        txtView.setText(numbers);
    }

    public void btn_back_click(View v) {
        if (numbers.length() > 1) {
            /* Delete character at the end */
            StringBuffer sb = new StringBuffer(numbers);
            sb.deleteCharAt(sb.length() - 1);

            numbers = String.valueOf(sb);
            txtView.setText(nf.format(Double.parseDouble(numbers)));
        }
        else {
            txtView.setText("");
        }
    }

    public void btn_plus_click(View v) {
       operation = "+";
       show_result();
    }
    public void btn_minus_click(View v) {
        operation = "-";
        show_result();
    }
    public void btn_multi_click(View v){
        operation = "*";
        show_result();
    }
    public void btn_divide_click(View v) {
        operation = "/";
        show_result();
    }
    public void btn_equals_click(View v) {
        show_result();
        operation = null;
        total = null;
    }
    /* End of onClick Method */
    /* Service method */
    public void number_builders(String n) {
        if (numbers.length() > 0 && numbers.length() <= 19) {
            numbers += n;
        }
        txtView.setText(nf.format(Double.parseDouble(numbers)));
    }
    public void show_result() {
        results = "0";

        if (operation != null) {
            if (numbers.length() > 0) {
                input_num = Double.parseDouble(numbers);
                if (total != null) {
                    switch (operation) {
                        case "+":
                            results = String.valueOf(nf.format(total += input_num));
                            break;
                        case "-":
                            results = String.valueOf(nf.format(total -= input_num));
                            break;
                        case "*":
                            results = String.valueOf(nf.format(total *= input_num));
                            break;
                        case "/":
                            try {
                                results = String.valueOf(nf.format(total /= input_num));
                            }
                            catch (Exception e) {
                                results = "Error";
                            }
                            break;
                        default :
                            results = String.valueOf(nf.format(input_num));
                    }
                } else {
                    total = input_num;
                    results = String.valueOf(nf.format(total));
                }
            }
        }
        txtView.setText(results);
        numbers = "0";
    }
}