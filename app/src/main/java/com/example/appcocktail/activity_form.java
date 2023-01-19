package com.example.appcocktail;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_form extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText inputNom, inputPrenom, inputEmail, inputPwd, inputTelephone;
    private Button btnSave, btnUpdate;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        // Affichage de l'icone dans la toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        inputNom = (EditText) findViewById(R.id.et_name);
        inputPrenom = (EditText) findViewById(R.id.et_surname);
        inputEmail = (EditText) findViewById(R.id.et_email);
        inputPwd = (EditText) findViewById(R.id.et_password);
        inputTelephone = (EditText) findViewById(R.id.et_telephone);
        btnSave = (Button) findViewById(R.id.submit_button);
        mFirebaseInstance = FirebaseDatabase.getInstance();
        // Acces au contenu de la node personnes
        mFirebaseDatabase = mFirebaseInstance.getReference("personnes");
        // cAffection de la valeur à la node titre
        mFirebaseInstance.getReference("titre").setValue("Liste des personnes Database Firebase");
        // listener sur le titre
        mFirebaseInstance.getReference("titre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.e(TAG, "titre mis a jour");
                //récupération du titre de la bdd firebase
                String titre = dataSnapshot.getValue(String.class);
                // mise a jour du titre dans la toolbar
                getSupportActionBar().setTitle(titre);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // En cas d'erreur
                Log.e(TAG, "Impossible de lire le noeud titre dans la database", error.toException());
            }
        });
        // Sauvegarde de la personne saisie dans le formulaire
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = inputNom.getText().toString();
                String prenom = inputPrenom.getText().toString();
                String email = inputEmail.getText().toString();
                String pwd = inputPwd.getText().toString();
                String tel = inputTelephone.getText().toString();
                //creation de l'utilisateur
                createUser(nom, prenom, email, pwd, tel);
            }
        });
    }

    /**
     * Creation d'une personne dans la node personnes
     */
    private void createUser(String nom, String prenom, String email, String
            adresse, String tel) {
        //possibilité de définir un identifiant unique en
        // appellant la méthode ! mFirebaseDatabase.push().getKey();
        userId = nom + "_" + prenom;
        Utilisateur pers = new Utilisateur(nom, prenom, email, adresse, tel);
        //creation de la node nom_prenom et insertion des valeurs
        mFirebaseDatabase.child(userId).setValue(pers);
        addUserChangeListener();
    }

    /**
     * Définition du listener pour detecter le changement de données
     */
    private void addUserChangeListener() {
        // listener detectant le changement des données
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Récupération des valeurs saisies
                Utilisateur user = dataSnapshot.getValue(Utilisateur.class);
                // Check for null
                if (user == null) {
                    Log.e(TAG, "User data is null!");
                    return;
                }
                Log.e(TAG, "Personne saisie:!" + user.nom + ", " + user.prenom + ", " + user.email +
                        "," + user.pwd + "," + user.tel);
                // Affichage des infos de la personne dans le textview
                txtDetails.setText(user.nom + ", " + user.prenom + ", " + user.email + "," + user.pwd
                        + "," + user.tel);
                // reset des edit text
                inputEmail.setText("");
                inputNom.setText("");
                inputPrenom.setText("");
                inputPwd.setText("");
                inputTelephone.setText("");
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Errreur de lecture
                Log.e(TAG, "Erreur à la lecture de l'utilisateur",
                        error.toException());
            }
        });
    }
}