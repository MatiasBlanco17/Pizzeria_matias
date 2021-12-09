package com.example.pizzeria;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Objetos.Pizza;

public class Listado_act extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Pizza> listapizza=new ArrayList<>();
    Pizza pizzaSelected;

    //variables para obtener database
    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        lista=findViewById(R.id.lv);
        obtenerDatabase();
        //Método para obtener la selección del ListView
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                pizzaSelected = (Pizza) parent.getItemAtPosition(position);
            }
        });

        databaseReference.child("Pizza").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot op: snapshot.getChildren())
                {
                    Pizza p = op.getValue(Pizza.class);
                    listapizza.add(p);



                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listapizza);
                    lista.setAdapter(adapt);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    //obtener database
    public void obtenerDatabase(){
        FirebaseApp.initializeApp(this);
        firebase=FirebaseDatabase.getInstance();
        databaseReference=firebase.getReference();
    }
    //Método para eliminar
    public void Eliminar(View view){
        Pizza p = new Pizza();
        p.setId(pizzaSelected.getId());
        databaseReference.child("Pizza").child(p.getId()).removeValue();
        Toast.makeText(getBaseContext(),"fue eliminado de la base de datos", Toast.LENGTH_LONG).show();
    }
}