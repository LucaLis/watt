package lis.android.watt;

import android.app.Activity;
import android.os.Bundle;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        double timePerDay = getIntent().getDoubleExtra(DAILY_WORK_SCHEDULE,0.0);

        setContentView(R.layout.define_power);

        TextView hoursField = (TextView) findViewById(R.id.hoursField);
        hoursField.setText(String.valueOf(timePerDay));
    }
}
