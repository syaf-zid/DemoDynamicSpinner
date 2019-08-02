package com.example.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        // Initialise the ArrayList
        alNumbers = new ArrayList<>();

        // Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        // Approach #1
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        // Implement the button onCLick() method
        // to load the correct number list when it is clicked
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                if(pos == 0) {
                    // Approach #2
                    // Get the string-array as an Array
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);

                    // Convert Array to List and add to the ArrayList
                    alNumbers.addAll(Arrays.asList(strNumbers));

                    // Bind the ArrayAdapter to the Spinner
                    spn2.setAdapter(aaNumbers);

                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setAdapter(aaNumbers);
                }
            }
        });

        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        alNumbers.clear();
                        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(alNumbers.indexOf("6"));
                        break;
                    case 1:
                        alNumbers.clear();
                        strNumbers = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        spn2.setAdapter(aaNumbers);
                        spn2.setSelection(alNumbers.indexOf("3"));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
