package com.edicionesmomento.hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Thread.sleep(10000); //Hilo que lo manda a dormir 10 seg.
                    Toast.makeText(MainActivity.this, "Proceso terminado", Toast.LENGTH_SHORT).show();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
    }
}
