package lis.android.watt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import de.akquinet.android.androlog.Log;

public class WattWelcomeActivity extends Activity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after
     * previously being shut down then this Bundle contains the data it most
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        setContentView(R.layout.main);
    }

    public void onWholeDayButtonClick(View view) {
        Intent intent = new Intent(WattWelcomeActivity.this, DefinePowerActivity.class);
        intent.putExtra(DefinePowerActivity.DAILY_WORK_SCHEDULE,24d);
        startActivity(intent);
    }

    public void onPartOfDayButtonClick(View view) {
        Intent intent = new Intent(WattWelcomeActivity.this, DefineWorkScheduleActivity.class);
        startActivity(intent);
    }

}

