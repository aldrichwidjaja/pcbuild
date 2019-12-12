package com.example.pcbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class procie extends AppCompatActivity {

    RadioGroup chooseprocie;
    Button add_procie;
    public String price_disp;
    public String procie_disp;
    public int procieprice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procie);

        chooseprocie = (RadioGroup) findViewById(R.id.chooseprocie);
        chooseprocie.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //set a listener on the RadioGroup
            @Override
            public void onCheckedChanged(RadioGroup view, int checkedId) {
                //checkedId refers to the selected RadioButton
                //Perform an action based on the option chosen
                if (checkedId == R.id.procie1) {
                    procieprice = 200;
                    price_disp = "$200";
                    procie_disp = "PROCESSOR: I9 INTEL 9900K";
                } else if (checkedId == R.id.procie2){
                    procieprice = 400;
                    price_disp = "$400";
                    procie_disp = "PROCESSOR: RYZEN 3RD SERIES 480";
                }
            }
        });

        add_procie = (Button) findViewById(R.id.add_procie);
        add_procie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("procie", procieprice);
                intent.putExtra("procieprice_disp", price_disp);
                intent.putExtra("prociedisp", procie_disp);
                setResult(RESULT_OK, intent);
                procie.this.finish();
            }
        });


    }
}
