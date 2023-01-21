package com.example.parouimpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String numero =binding.editNumero.getText().toString();

                if (numero.isEmpty()){
                    binding.editNumero.setError("Informe um valor!");
                }else{
                    validaParImpar();
                }
            }
        });
    }

    private void validaParImpar() {
        int numero = Integer.parseInt(binding.editNumero.getText().toString());

        if (numero % 2 == 0){
            binding.txtResultado.setText("O número " + numero + " é Par");
        }else {
            binding.txtResultado.setText("O número " + numero + " é Ímpar");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.ic_limpar){
            binding.editNumero.setText("");
            binding.txtResultado.setText("");
        }
        return super.onOptionsItemSelected(item);
    }
}