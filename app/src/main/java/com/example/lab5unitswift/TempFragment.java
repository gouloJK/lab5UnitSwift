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

public class TempFragment extends Fragment {

    // Declare UI components
    private RadioGroup radioGroup;
    private RadioButton radioCtoF;
    private RadioButton radioFtoC;
    private EditText inputValue;
    private Button convertButton;
    private TextView resultText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load the layout file
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        // Connect Java variables to XML components
        radioGroup = view.findViewById(R.id.radioGroupTemp);
        radioCtoF = view.findViewById(R.id.radioCtoF);
        radioFtoC = view.findViewById(R.id.radioFtoC);
        inputValue = view.findViewById(R.id.inputTemp);
        convertButton = view.findViewById(R.id.btnConvertTemp);
        resultText = view.findViewById(R.id.resultTemp);

        // Set click listener for the convert button
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        return view;
    }

    private void convertTemperature() {
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
        if (radioCtoF.isChecked()) {
            // Celsius to Fahrenheit: (°C × 9/5) + 32
            result = (value * 9/5) + 32;
            resultText.setText(String.format("%.2f °F", result));
        } else {
            // Fahrenheit to Celsius: (°F - 32) × 5/9
            result = (value - 32) * 5/9;
            resultText.setText(String.format("%.2f °C", result));
        }
    }
}