package com.example.appnotas;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.appnotas.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText edt_anotacao;
    private AnotacaoPreferencia preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        edt_anotacao = findViewById(R.id.edt_anotacao);
        preferencia = new AnotacaoPreferencia(getApplicationContext());



        //

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String anotacao = edt_anotacao.getText().toString();
                if (!anotacao.isEmpty()){
                    preferencia.salvarAnotacao(anotacao);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        String anotacao = preferencia.recuperarAnotacao();
        if (!anotacao.isEmpty()){
            edt_anotacao.setText(anotacao);
        }
    }

}