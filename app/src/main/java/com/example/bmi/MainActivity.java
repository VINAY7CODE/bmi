package com.example.bmi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TextView txtresult ;
        EditText editweight,editheightft,editheightin ;
        Button btncalculate ;
        LinearLayout main;

        editweight=findViewById(R.id.edtweight);
        editheightft=findViewById(R.id.edtheightft);
        editheightin=findViewById(R.id.edtheightin);
        btncalculate=findViewById(R.id.btncalculate);
        txtresult=findViewById(R.id.txtresult);
        main=findViewById(R.id.main);

        btncalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                int weight=Integer.parseInt(editweight.getText().toString());
                int heightft=Integer.parseInt(editheightft.getText().toString());
                int heightin=Integer.parseInt(editheightin.getText().toString());

                int height=heightft*12+heightin;
                double cm=height*2.54;
                double m=cm/100;
                double bmi=weight/(m*m);

                if(bmi>25){
                    txtresult.setText("overweight !");
                    main.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(bmi<18.5){
                    txtresult.setText("underweight !");
                    main.setBackgroundColor(getResources().getColor(R.color.colorUW));

                }else{
                    txtresult.setText("your are fit !");
                    main.setBackgroundColor(getResources().getColor(R.color.colorFW));
                }
            }
        });


    }
}