package lis.android.watt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import de.akquinet.android.androlog.Log;

/**
 * Created with IntelliJ IDEA.
 * User: lli
 * Date: 17.12.12
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class DefinePowerActivity extends Activity {

    public static final String DAILY_WORK_SCHEDULE = "DAILY_WORK_SCHEDULE";

    public static final int MAX_POWER = 2500;
    public static final int DEFAULT_POWER = 500;
    private double hoursOfWorkPerDay;
    private int devicePower;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        hoursOfWorkPerDay = getIntent().getDoubleExtra(DAILY_WORK_SCHEDULE,0.0);

        setContentView(R.layout.define_power);

        // display time per day
        TextView hoursField = (TextView) findViewById(R.id.hoursField);
        hoursField.setText(String.valueOf(hoursOfWorkPerDay));

        // set default power
        SeekBar powerSeekBar = (SeekBar) findViewById(R.id.powerSeekBar);
        powerSeekBar.setMax(MAX_POWER);
        powerSeekBar.setProgress(DEFAULT_POWER);
        TextView powerTextView = (TextView) findViewById(R.id.powerTextView);
        powerTextView.setText(String.valueOf(DEFAULT_POWER));

        //display power value picked by user
        powerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView powerTextView = (TextView) findViewById(R.id.powerTextView);
                powerTextView.setText(String.valueOf(i));
                DefinePowerActivity.this.devicePower = i;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public void startSchowResultsActivity(View view) {
        Intent intent = new Intent(DefinePowerActivity.this, ShowResultsActivity.class);
        intent.putExtra(ShowResultsActivity.EXTRA_KWH_PER_YEAR,365* hoursOfWorkPerDay *devicePower/1000d);
        startActivity(intent);
    }

}
