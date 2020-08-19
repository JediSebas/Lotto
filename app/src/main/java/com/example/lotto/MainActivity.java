package com.example.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView nr1tV;
    TextView nr2tV;
    TextView nr3tV;
    TextView nr4tV;
    TextView nr5tV;
    TextView nr6tV;
    EditText nr1eT;
    EditText nr2eT;
    EditText nr3eT;
    EditText nr4eT;
    EditText nr5eT;
    EditText nr6eT;
    TextView traftV;
    Random generator = new Random();
    int[] random = new int[6];
    int[] number = new int[6];
    EditText etbufor;
    TextView tvbufor;
    int ibuf;
    String sbuff;
    TextView[] tv = new TextView[6];
    EditText[] et = new EditText[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv[0] = nr1tV = (TextView) findViewById(R.id.nr1tV);
        tv[1] = nr2tV = (TextView) findViewById(R.id.nr2tV);
        tv[2] = nr3tV = (TextView) findViewById(R.id.nr3tV);
        tv[3] = nr4tV = (TextView) findViewById(R.id.nr4tV);
        tv[4] = nr5tV = (TextView) findViewById(R.id.nr5tV);
        tv[5] = nr6tV = (TextView) findViewById(R.id.nr6tV);
        et[0] = nr1eT = (EditText) findViewById(R.id.nr1eT);
        et[1] = nr2eT = (EditText) findViewById(R.id.nr2eT);
        et[2] = nr3eT = (EditText) findViewById(R.id.nr3eT);
        et[3] = nr4eT = (EditText) findViewById(R.id.nr4eT);
        et[4] = nr5eT = (EditText) findViewById(R.id.nr5eT);
        et[5] = nr6eT = (EditText) findViewById(R.id.nr6eT);
        traftV = (TextView) findViewById(R.id.traftV);
    }


    public void losuj(View view) {
        for (int i=0; i < 6; i++) {
            random[i] = generator.nextInt(48)+1;
        }
    }
    void rantotv(){
        for (int i=0; i < 6; i++ ){
            ibuf = random[i];
            sbuff = String.valueOf(ibuf);
            tvbufor = tv[i];
            tv[i].setText(sbuff);
        }
    }
    void ettonum(){
        for (int i=0; i < 6; i++) {
            etbufor = et[i];
            sbuff = etbufor.getText().toString().trim();
            ibuf = Integer.parseInt(sbuff);
            number[i] = ibuf;
        }
    }
    int check(int[] a, int[] b){
        int i=0, j, x=0;
        for (; i < 6; i++){
            for (j=0; j<6; j++){
                if (a[i] == b[j]){
                   x++;
                }
            }
        }
        return x;
    }

        public void sprawdz (View view){
        try {
            rantotv();
            ettonum();
            int wyn = check(number, random);
            traftV.setText("trafienia: " + wyn);
        } catch (Exception e) {
            for (int i=0; i<6; i++){
                et[i].setText("0");
            }
        }
        }

    public void czysc(View view) {
        for (int i=0; i<6; i++){
            et[i].setText("");
        }
    }
}
