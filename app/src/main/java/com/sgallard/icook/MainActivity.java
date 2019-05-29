package com.sgallard.icook;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText Email, Password;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        Email = (EditText)findViewById(R.id.txtemail);
        Password = (EditText)findViewById(R.id.txtpassword);
        res = this.getResources();
    }

    public void register (View view){
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Email.setError("*");
            Password.setError("*");
        }else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(MainActivity.this,"Record Authentication", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(MainActivity.this,"Record Fail", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }

    }

    public void Login (View view){
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if(email.isEmpty() || password.isEmpty()){
            Email.setError("*");
            Password.setError("*");
        }else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                                Intent in = new Intent(MainActivity.this,Home.class);
                                startActivity(in);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                            }

                            // ...
                        }
                    });
        }
    }
}

