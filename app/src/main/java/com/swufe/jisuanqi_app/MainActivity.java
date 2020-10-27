package com.swufe.jisuanqi_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";//logt+tab键

    EditText resultText;
    private String ss = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void calculator(View v) {
        resultText = findViewById(R.id.result);
        switch (v.getId()) {

            case R.id.clear:
                ss = " ";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button0:
                ss += "0";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button1:
                ss += "1";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button2:
                ss += "2";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button3:
                ss += "3";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button4:
                ss += "4";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button5:
                ss += "5";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button6:
                ss += "6";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button7:
                ss += "7";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button8:
                ss += "8";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.button9:
                ss += "9";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.add:
                if (ss.length() == 0) {
                    break;
                }
                if (ss.contains(" ")) {
                    if (ss.indexOf(" ") == ss.length() - 3 || ss.indexOf(" ") == ss.length() - 2 || ss.indexOf(" ") == ss.length() - 1)
                        break;
                    getResult();
                }

                ss += " ＋ ";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());

                break;

            case R.id.sub:
                if (ss.length() == 0) {
                    break;
                }
                if (ss.contains(" ")) {
                    if (ss.indexOf(" ") == ss.length() - 3 || ss.indexOf(" ") == ss.length() - 2 || ss.indexOf(" ") == ss.length() - 1)
                        break;
                    getResult();
                }

                ss += " － ";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.mul:
                if (ss.length() == 0) {
                    break;
                }
                if (ss.contains(" ")) {
                    if (ss.indexOf(" ") == ss.length() - 3 || ss.indexOf(" ") == ss.length() - 2 || ss.indexOf(" ") == ss.length() - 1)
                        break;
                    getResult();
                }
                ss += " × ";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());

                break;

            case R.id.div:
                if (ss.length() == 0) {
                    break;
                }
                if (ss.contains(" ")) {
                    if (ss.indexOf(" ") == ss.length() - 3 || ss.indexOf(" ") == ss.length() - 2 || ss.indexOf(" ") == ss.length() - 1)
                        break;
                    getResult();
                }

                ss += " ÷ ";
                resultText.setText(ss);
                resultText.setSelection(resultText.getText().length());
                break;

            case R.id.spot:
                if (ss.length() == 0 || ss.indexOf(" ") == ss.length() - 3 || ss.lastIndexOf(".") > ss.indexOf(" ")) {
                    break;
                } else {
                    ss += ".";
                    resultText.setText(ss);
                    resultText.setSelection(resultText.getText().length());
                }
                break;

            case R.id.equal:
                getResult();

            default:
                break;

        }

    }



    public void getResult() {

        double result = 0;
        if (ss == null || ss.equals("")) return;
        if (!ss.contains(" ")) return;
        String s1 = ss.substring(0, ss.indexOf(" "));
        String op = ss.substring(ss.indexOf(" ") + 1, ss.indexOf(" ") + 2);
        String s2 = ss.substring(ss.indexOf(" ") + 3);
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            switch (op) {
                case "＋":
                    result = d1 + d2;
                    break;
                case "－":
                    result = d1 - d2;
                    break;
                case "×":
                    result = d1 * d2;
                    break;
                case "÷": {
                    if (d2 == 0) {
                        resultText.setText("不能除以零");
                        resultText.setSelection(resultText.getText().length());
                        break;
                    }
                    result = d1 / d2 * 1.0;
                }
                break;
            }

            int r = (int) result;
            if (r == result) {
                resultText.setText("" + r);
                resultText.setSelection(resultText.getText().length());
                ss = "" + r;
            } else {
                resultText.setText(result + "");
                resultText.setSelection(resultText.getText().length());
                ss = "" + result;
            }

        }

    }


}