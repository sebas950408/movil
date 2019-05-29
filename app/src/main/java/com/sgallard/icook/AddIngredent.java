package com.sgallard.icook;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddIngredent extends AppCompatActivity {

    private EditText Name, Quantity;
    private Resources Res;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_ingredient);

        Name = (EditText)findViewById(R.id.TxtName);
        Quantity = (EditText)findViewById(R.id.TxtCantidad);
        Res = this.getResources();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

    }

    public void addIng (View view){
         final String name, cantidad;
         name = Name.getText().toString().trim();
         cantidad = Quantity.getText().toString().trim();

         if (name.isEmpty() || cantidad.isEmpty()){
             Name.setError("*");
             Quantity.setError("*");
         }else{
             myRef.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(DataSnapshot dataSnapshot) {
                     // This method is called once with the initial value and again
                     // whenever data at this location is updated.
                     Ingredient i = new Ingredient(name, cantidad);

                     myRef.child("Ingredient").push().setValue(i);
                 }

                 @Override
                 public void onCancelled(DatabaseError error) {
                     // Failed to read value

                 }
             });

         }



    }
}
