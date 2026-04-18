package com.example.lab5unitswift;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    // Declare UI components
    private RadioGroup radioGroup;
    private RadioButton radioKmToMiles;
    private RadioButton radioMilesToKm;
    private EditText inputValue;
    private Button convertButton;
    private TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load the layout file
        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        // Connect Java variables to XML components
        radioGroup = view.findViewById(R.id.radioGroupDist);
        radioKmToMiles = view.findViewById(R.id.radioKmToMiles);
        radioMilesToKm = view.findViewById(R.id.radioMilesToKm);
        inputValue = view.findViewById(R.id.inputDist);
        convertButton = view.findViewById(R.id.btnConvertDist);
        resultText = view.findViewById(R.id.resultDist);

        // Set click listener for the convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertDistance();
            }
        });

        return view;
    }

    private void convertDistance() {
        // Get the input text
        String input = inputValue.getText().toString();

        // Check if input is empty
        if (TextUtils.isEmpty(input)) {
            Toast.makeText(getActivity(), "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert string to double
        double value = Double.parseDouble(input);
        double result;

        // Check which radio button is selected and convert accordingly
        if (radioKmToMiles.isChecked()) {
            // Kilometers to Miles: km × 0.621371
            result = value * 0.621371;
            resultText.setText(String.format("%.2f miles", result));
        } else {
            // Miles to Kilometers: miles ÷ 0.621371
            result = value / 0.621371;
            resultText.setText(String.format("%.2f km", result));
        }
    }
}