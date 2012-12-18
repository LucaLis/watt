package lis.android.watt;

import android.app.Activity;
import android.os.Bundle;
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        double timePerDay = getIntent().getDoubleExtra(DAILY_WORK_SCHEDULE,0.0);

        setContentView(R.layout.define_power);

        // display time per day
        TextView hoursField = (TextView) findViewById(R.id.hoursField);
        hoursField.setText(String.valueOf(timePerDay));

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
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
