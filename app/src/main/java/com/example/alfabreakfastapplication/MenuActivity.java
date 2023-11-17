package com.example.alfabreakfastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Button btnOrderSummary;
    Button btnTeaPlus, btnTeaMinus;
    TextView txtTeaQt;
    int teaQt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnOrderSummary = findViewById(R.id.btn_order_summary);
        btnTeaPlus = findViewById(R.id.btn_tea_plus);
        btnTeaMinus = findViewById(R.id.btn_tea_minus);
        txtTeaQt = findViewById(R.id.txt_tea_qt);

        btnTeaPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teaQt++;
                txtTeaQt.setText("" + teaQt);
            }
        });

        btnTeaMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teaQt--;
                if (teaQt<0){
                    teaQt = 0;
                    Toast.makeText(getApplicationContext(), "Quantity can't be less than 0", Toast.LENGTH_SHORT).show();
                }else {
                    txtTeaQt.setText("" + teaQt);
                }
            }
        });

        btnOrderSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OrderActivity.class));
            }
        });
    }
}