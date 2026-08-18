package com.ifsc.aula2;

import static kotlin.random.RandomKt.nextInt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;
import com.ifsc.aula2.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);
        EditText edMin, edMax;
        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);
        textView.setText("");

        button.setOnClickListener(v -> {

            String smin = edMin.getText().toString();
            String smax = edMax.getText().toString();

            if(smin.isEmpty()){
                edMin.setError("Informe um inteiro");
                return;
            }

            if(smax.isEmpty()){
                edMax.setError("Informe um inteiro");
                return;
            }
            int min = Integer.parseInt(smin);
            int max = Integer.parseInt(smax);

            if(min > max){
                Toast.makeText(this, "Defina Mínimo < Máximo", Toast.LENGTH_SHORT).show();
                return;
            }


            Random random = new Random();
            int n = random.nextInt(min, max);
            textView.setText(Integer.toString(n));




        });
    }
}