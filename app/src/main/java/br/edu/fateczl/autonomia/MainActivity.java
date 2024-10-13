package br.edu.fateczl.autonomia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author: Kelvin Santos Guimarães
     */

    private EditText etConsumoMedio;
    private EditText etCombustivelTanque;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etConsumoMedio = findViewById(R.id.etConsumoMedio);
        etConsumoMedio.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etCombustivelTanque = findViewById(R.id.etCombustivelTanque);
        etCombustivelTanque.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);

        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc(){
        float consumoMedio = Float.parseFloat(etConsumoMedio.getText().toString());
        float combustivelTanque = Float.parseFloat(etCombustivelTanque.getText().toString());
        float autonomia = (combustivelTanque * consumoMedio) * 1000;
        tvRes.setText("Autonomia do veículo é de " + autonomia + " metros");
    }

}