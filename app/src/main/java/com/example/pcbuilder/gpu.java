package com.example.pcbuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class gpu extends AppCompatActivity {

    RadioGroup choosegpu;
    Button add_gpu;
    public String price_disp;
    public String gpu_disp;
    public int gpuprice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpu);

        choosegpu = (RadioGroup) findViewById(R.id.choosegpu);
        choosegpu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //set a listener on the RadioGroup
            @Override
            public void onCheckedChanged(RadioGroup view, int checkedId) {
                //checkedId refers to the selected RadioButton
                //Perform an action based on the option chosen
                if (checkedId == R.id.gpu1) {
                    gpuprice = 460;
                    price_disp = "$460";
                    gpu_disp = "GPU: ZOTAC GTX 1660TI ULTIMATE EDITION";
                } else if (checkedId == R.id.gpu2){
                    gpuprice = 970;
                    price_disp = "$970";
                    gpu_disp = "GALAX RTX 2080 ULTRA OVERCLOCK";
                }
            }
        });

        add_gpu = (Button) findViewById(R.id.add_gpu);
        add_gpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("gpu", gpuprice);
                intent.putExtra("gpuprice_disp", price_disp);
                intent.putExtra("gpudisp", gpu_disp);
                setResult(RESULT_OK, intent);
                gpu.this.finish();
            }
        });


    }
}
