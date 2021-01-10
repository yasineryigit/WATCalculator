package com.ossovita.watcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText workweektext,saatlikucrettext,saattext,housingtext,weeklyspendtext,taxratetext;
    TextView resultText;

    double workweek,saatlikUcret,haftalikSaat,konaklama,haftalikHarcama,taxrate;
    double gelir,gider,kar,vergi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workweektext = findViewById(R.id.work_week_text);
        saatlikucrettext = findViewById(R.id.hourly_wage_text);
        saattext = findViewById(R.id.hour_text);
        housingtext=findViewById(R.id.housing_text);
        weeklyspendtext=findViewById(R.id.weekly_spend);
        taxratetext=findViewById(R.id.taxrate_text);
        resultText = findViewById(R.id.resultText);
        workweek=0;
        saatlikUcret=0;
        haftalikSaat=0;
        konaklama=0;
        haftalikHarcama=0;
        vergi=0;


    }



    public void calculate(View v){
        if(workweektext.getText().toString().equals("")//herhangi bir değer boşsa
        ||saatlikucrettext.getText().toString().equals("")
        ||saattext.getText().toString().equals("")
        ||housingtext.getText().toString().equals("")
        ||weeklyspendtext.getText().toString().equals("")
        ||taxratetext.getText().toString().equals(""))  {
            Toast.makeText(this, "Lütfen hepsini doldurunuz, (0 yazabilirsiniz)", Toast.LENGTH_SHORT).show();

        }else{//hepsi doldurulduysa işlem yap
            workweek = Double.parseDouble(workweektext.getText().toString());
            saatlikUcret = Double.parseDouble(saatlikucrettext.getText().toString());
            haftalikSaat = Double.parseDouble(saattext.getText().toString());
            konaklama = Double.parseDouble(housingtext.getText().toString());
            haftalikHarcama = Double.parseDouble(weeklyspendtext.getText().toString());
            taxrate = Double.parseDouble(taxratetext.getText().toString());

            gelir = (saatlikUcret*haftalikSaat)*workweek;
            vergi = ((gelir*taxrate)/100);
            gider = ((konaklama+haftalikHarcama)*workweek)+vergi;
            kar = gelir-gider;

            resultText.setText("Gelir: " + Double.toString(gelir)
                    +"\nGider: "+ Double.toString(gider)
                    +"\nKar: "+ Double.toString(kar));

            System.out.println("Vergi: " + vergi);
        }






    }
    public void degerAta(double deger){
        deger = 0;
    }
}

