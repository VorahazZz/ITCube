package com.example.itcube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText ed1, ed2;
    RadioGroup radioGroup;
    Double num1, num2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btnRes);
        ed1 = findViewById(R.id.editTextNum1);
        ed2 = findViewById(R.id.editTextNum2);
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                if (ed1.getText().toString().equals("") && ed2.getText().toString().equals("")){
                    for (int i = 0; i < radioGroup.getChildCount(); i++){
                        radioGroup.getChildAt(i).setActivated(false);
                    }
                    Toast.makeText(MainActivity.this, "Оба поля с цифрами должны быть заполнены", Toast.LENGTH_SHORT).show();
                }
                else {
                    num1 = Double.parseDouble(ed1.getText().toString());
                    num2 = Double.parseDouble(ed2.getText().toString());
                    if (id == R.id.rbPlus)
                        res = num1 + num2;
                    if (id == R.id.rbMin)
                        res = num1 - num2;
                    if (id == R.id.rbDel)
                        res = num1 / num2;
                    if (id == R.id.rbYmn)
                        res = num1 * num2;
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num1 == null && num2 == null){
                    Toast.makeText(MainActivity.this, "Вы так и не написали числа", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, res + "", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}