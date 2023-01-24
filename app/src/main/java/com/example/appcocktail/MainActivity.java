package com.example.appcocktail;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    String emailValue, pwdValue;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
    }

    /**
     * Objet de référence à la base de données Firebase
     */

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cocktailapp-e9109-default-rtdb.europe-west1.firebasedatabase.app/");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  base de donée SQLite
         */


        RecipeCocktailDataBase recipeCocktailDataBase = new RecipeCocktailDataBase(MainActivity.this);

        mAuth = FirebaseAuth.getInstance();


        /**
         * connexion à l'application
         */


        Button button = findViewById(R.id.buttonConnexion);
        EditText email = findViewById(R.id.emailField);
        EditText pwd = findViewById(R.id.pwdField);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /**
                 * Recuperation des champs de connexion
                 */


               final String emailFormConnexion = email.getText().toString();
                final String pwdFormConnexion = pwd.getText().toString();





// Ajout d'un écouteur pour récupérer les données lorsqu'elles sont modifiées

               String userIdMail = emailFormConnexion.replaceAll("[^a-zA-Z0-9]", "");
               Log.i(TAG, "mon id est " + userIdMail);

                databaseReference.child("Utilisateur").child(userIdMail).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                       emailValue = dataSnapshot.child("email").getValue(String.class);
                        pwdValue = dataSnapshot.child("pwd").getValue(String.class);
                        Log.i(TAG,"mot de passe bdd est " + pwdValue);


                        /**
                         * Verification des donnees
                         */

                        if (emailFormConnexion.isEmpty() || pwdFormConnexion.isEmpty()) {

                            // Affiche un message d'erreur
                            Toast.makeText(MainActivity.this, "Les champs de connexion doivent être remplit", Toast.LENGTH_SHORT).show();
                        }
                        /**
                         * Vérifie que les champs sont identiques
                         */
                        else if (!Objects.equals(pwdValue, pwdFormConnexion) || !Objects.equals(emailValue, emailFormConnexion))
                        {

                            Log.i(TAG,"mot de passe champs form " + pwdFormConnexion);

                            // Affiche un message d'erreur
                            Toast.makeText(MainActivity.this, "Probléme de connexion", Toast.LENGTH_SHORT).show();
                        } else {
                            Intent intent = new Intent(view.getContext(), HomeActivity.class);
                            startActivity(intent);
                            // Toast.makeText(MainActivity.this, "Bonne visite !", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }

                } );




            }
        });

        /**
         * Gestion du champs d'inscription
         */

        TextView textView = findViewById(R.id.textInscription);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), activity_form.class);
                startActivity(intent);
            }
        });
        /**
         * Base de donnée Firebase
         */

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}