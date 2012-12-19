package lis.android.watt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import de.akquinet.android.androlog.Log;

public class ShowResultsActivity extends Activity {


    public static final double DEFAULT_KWH_PRICE = 0.49d;

    public static final String EXTRA_KWH_PER_YEAR = "ShowResultsActivity.EXTRA_KWH_PER_YEAR";

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */

    public double kwhPrice = DEFAULT_KWH_PRICE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        setContentView(R.layout.show_results);

        EditText kwhPriceField = (EditText) findViewById(R.id.kwhPriceField);
        kwhPriceField.setText(String.valueOf(DEFAULT_KWH_PRICE));

        double kwhPerYear = getIntent().getDoubleExtra(EXTRA_KWH_PER_YEAR,0.0d);

        // replace with validate methods
        if(kwhPerYear == 0.0d){
            throw new RuntimeException("kWh per year set to 0.0d!");
        }

        TextView yearCostTextView = (TextView) findViewById(R.id.yearCostField);
        yearCostTextView.setText(String.valueOf(kwhPerYear*kwhPrice));

        TextView monthCostTextView = (TextView) findViewById(R.id.monthCostField);
        monthCostTextView.setText(String.valueOf(kwhPerYear*kwhPrice/12));
    }

}

