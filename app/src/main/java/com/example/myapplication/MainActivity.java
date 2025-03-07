package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner villeSpinner;
    private EditText nomPrenomEditTxt, emailEditTxt, phoneEditTxt, adresseEditTxt;
    private RadioGroup genreRadioGroup;
    private RadioButton radioF, radioM;
    private Button btnEnvoyer;
    private ArrayList<String> villes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        villeSpinner = findViewById(R.id.villeSpinner);
        nomPrenomEditTxt = findViewById(R.id.nomPrenomEditTxt);
        emailEditTxt = findViewById(R.id.emailEditTxt);
        phoneEditTxt = findViewById(R.id.phoneEditTxt);
        adresseEditTxt = findViewById(R.id.adresseEditTxt);
        genreRadioGroup = findViewById(R.id.genreRadioGroup);
        radioF = findViewById(R.id.radioF);
        radioM = findViewById(R.id.radioM);
        btnEnvoyer = findViewById(R.id.btnEnvoyer);

        villes = new ArrayList<>();
        villes.add("Sélectionnez une ville");
        villes.add("Paris");
        villes.add("Madrid");
        villes.add("Barchalona");
        villes.add("London");
        villes.add("Autre ville");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, villes);
        villeSpinner.setAdapter(adapter);

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomPrenom = nomPrenomEditTxt.getText().toString();
                String email = emailEditTxt.getText().toString();
                String phone = phoneEditTxt.getText().toString();
                String adresse = adresseEditTxt.getText().toString();
                String ville = villeSpinner.getSelectedItem().toString();

                // Get the selected genre
                String genre = "";
                int selectedRadioId = genreRadioGroup.getCheckedRadioButtonId();
                if (selectedRadioId == R.id.radioF) {
                    genre = "Femme";
                } else if (selectedRadioId == R.id.radioM) {
                    genre = "Homme";
                }

                Intent intent = new Intent(MainActivity.this, RecapActivity.class);
                intent.putExtra("nomPrenom", nomPrenom);
                intent.putExtra("email", email);
                intent.putExtra("phone", phone);
                intent.putExtra("adresse", adresse);
                intent.putExtra("ville", ville);
                intent.putExtra("genre", genre);  // Adding genre to the intent
                startActivity(intent);
            }
        });
    }
}