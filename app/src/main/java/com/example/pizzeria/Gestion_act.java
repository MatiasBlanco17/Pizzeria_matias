package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Objetos.Pizza;

public class Gestion_act extends AppCompatActivity {

    private EditText iname,ivalor,ilocal;
    private Button anadirpizza;

    //variables para obtener database
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion);

        iname=findViewById(R.id.Inombre);
        ivalor=findViewById(R.id.Iprecio);
        ilocal=findViewById(R.id.Ilocal);
        anadirpizza=findViewById(R.id.Apizza);

        obtenerDatabase();

        //Añadir pizza
        anadirpizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pizza p=new Pizza();

                p.setId(UUID.randomUUID().toString());
                p.setNombre(iname.getText().toString());
                p.setPrecio(ivalor.getText().toString());
                p.setLocalizacion(ilocal.getText().toString());

                databaseReference.child("Pizza").child(p.getId()).setValue(p);
                Toast.makeText(getBaseContext(),"Se añadio una pizza",Toast.LENGTH_LONG).show();
            }
        });
    }
    //obtener database
    public void obtenerDatabase(){
        FirebaseApp.initializeApp(this);
        firebase=FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();
    }

}