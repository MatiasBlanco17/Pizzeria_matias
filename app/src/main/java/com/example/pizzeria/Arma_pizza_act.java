package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Ingredientes;
import Objetos.Saborespizza;

public class Arma_pizza_act extends AppCompatActivity {

    private Spinner pizzas,ingredientes;
    private TextView precios;

    private Saborespizza sbp=new Saborespizza();
    private Ingredientes idt=new Ingredientes();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arma_pizza);

        pizzas=findViewById(R.id.Pizzas);
        ingredientes=findViewById(R.id.Ingredientes);
        precios=findViewById(R.id.Precios);

        //listas
        String[] listarpizza=sbp.getNombre();
        String[] listaringredientes=idt.getNombre();

        ArrayAdapter adappizza=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listarpizza);
        ArrayAdapter adapingrediente=new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaringredientes);

        pizzas.setAdapter(adappizza);
        ingredientes.setAdapter(adapingrediente);


    }
    public void Calcular(View view){
        String selecionpizza=pizzas.getSelectedItem().toString();
        String selecioningrediente=ingredientes.getSelectedItem().toString();
        int valor=0;

        for(int i=0; i<selecionpizza.length();i++ ) {
            if (selecionpizza.equals(sbp.getNombre()[i])){
                valor=sbp.getPrecio()[i];
                break;
            }
        }
        for(int i=0; i<selecioningrediente.length();i++ ) {
            if (selecioningrediente.equals(idt.getNombre()[i])){
                valor=valor+idt.getPrecio()[i];
                break;
            }
        }
        precios.setText("$"+valor);
    }

}