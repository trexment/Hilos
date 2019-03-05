package com.edicionesmomento.hilos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView mImageView;
    Button btn;
    ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        btn = findViewById(R.id.button);
        progreso = findViewById(R.id.progressBar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               progreso.setVisibility(View.VISIBLE);
               new Hilo1().start();
            }
        });
    }

    class Hilo1 extends Thread{
        @Override
        public void run(){
            try{
                Thread.sleep(10000); //Hilo que lo manda a dormir 10 seg.
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Proceso Terminado", Toast.LENGTH_SHORT).show();
                        progreso.setVisibility(View.INVISIBLE);
                    }
                });
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
