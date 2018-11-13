package com.egr423.android.napkin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class TipActivity  extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        updateOutputs();

        // Inputs
        EditText waysSplit = (EditText) findViewById(R.id.waysSplit);
        EditText tipPercentage = (EditText) findViewById(R.id.tipPercentage);
        EditText totalBill = (EditText) findViewById(R.id.totalBill);

        // Each input needs to have an addTextChangedListener to dynamically change the outputs
        waysSplit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        tipPercentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        totalBill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateOutputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /**
     * Updates the output fields to the appropriate number whenever an input field is changed.
     */
    private void updateOutputs() {
        try {
            // Inputs
            EditText waysSplitInput = (EditText) findViewById(R.id.waysSplit);
            EditText tipPercentageInput = (EditText) findViewById(R.id.tipPercentage);
            EditText totalBillInput = (EditText) findViewById(R.id.totalBill);

            // Input values
            double waysSplit = Double.parseDouble(waysSplitInput.getText().toString());
            double tipPercentage = Double.parseDouble(tipPercentageInput.getText().toString()) / 100;
            double totalBill = Double.parseDouble(totalBillInput.getText().toString());

            // Outputs
            TextView costPerPerson = (TextView) findViewById(R.id.costPerPerson);
            TextView totalCostOfBill = (TextView) findViewById(R.id.totalCostOfBill);

            double expectedTotalCostOfBill = totalBill * (1 + tipPercentage);
            double expectedCostPerPerson = expectedTotalCostOfBill / waysSplit;

            // Update the outputs with dollar signs and only 2 decimals
            costPerPerson.setText(String.format("$%s", String.format("%.2f", expectedCostPerPerson)));
            totalCostOfBill.setText(String.format("$%s", String.format("%.2f", expectedTotalCostOfBill)));
        } catch (NumberFormatException e){
            return;
        }

    }
}
