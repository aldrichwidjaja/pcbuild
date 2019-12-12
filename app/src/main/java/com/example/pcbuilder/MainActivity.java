package com.example.pcbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView procie;
    TextView procieprice;
    int prociepricechoose = 0;
    String prociepricedisplay;
    String prociedisplay;
    Button prociego;

    TextView gpu;
    TextView gpuprice;
    int gpupricechoose = 0;
    String gpupricedisplay;
    String gpudisplay;
    Button gpugo;


    int totalvalue = 0;
    TextView totalvalue_preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        procie = (TextView) findViewById(R.id.procie);
        procieprice = (TextView) findViewById(R.id.procieprice);
        prociego = (Button) findViewById(R.id.prociego);

        gpu = (TextView) findViewById(R.id.gpu);
        gpuprice = (TextView) findViewById(R.id.gpuprice);
        gpugo = (Button) findViewById(R.id.gpugo);


        totalvalue_preview = (TextView) findViewById(R.id.totalvalue);

        prociego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, procie.class), 1);
            }
        });

        gpugo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, gpu.class), 2);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            prociepricechoose = data.getIntExtra("procie", 0);
            prociepricedisplay = data.getStringExtra("procieprice_disp");
            prociedisplay = data.getStringExtra("prociedisp");
            procieprice.setText(prociepricedisplay);
            procie.setText(prociedisplay);

            totalvalue = prociepricechoose + gpupricechoose;
            totalvalue_preview.setText(String.valueOf("TOTAL: $" + totalvalue));


        } else if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            gpupricechoose = data.getIntExtra("gpu", 0);
            gpupricedisplay = data.getStringExtra("gpuprice_disp");
            gpudisplay = data.getStringExtra("gpudisp");
            gpuprice.setText(gpupricedisplay);
            gpu.setText(gpudisplay);

            totalvalue = prociepricechoose + gpupricechoose;
            totalvalue_preview.setText(String.valueOf("TOTAL: $" + totalvalue));
        }
    }

}
