package academy.porto.meusorteio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> sorteados = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sortear(View view) {
        TextView resultado;
        resultado = findViewById(R.id.resultadoSorteio);

        TextView resultados;
        resultados = findViewById(R.id.resultados);

        EditText limite;
        limite = findViewById(R.id.numeroLimite);

        int number;
        if (limite.getText().toString().isEmpty()) {
            limite.setText("10");
            number = 10;
        } else {
            number = Integer.parseInt(limite.getText().toString());
        }

        Random gerador = new Random();

        String resultadoTexto = String.valueOf(gerador.nextInt(number) + 1);

        this.sorteados.add(resultadoTexto);

        resultados.setText(this.sorteados.toString());

        resultado.setText(resultadoTexto);
    }

    public void onLimpar(View view) {
        this.sorteados = new ArrayList<String>();

        TextView resultados;
        resultados = findViewById(R.id.resultados);
        resultados.setText(this.sorteados.toString());

    }
}
