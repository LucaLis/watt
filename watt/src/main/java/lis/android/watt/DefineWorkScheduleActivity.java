package lis.android.watt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;
import de.akquinet.android.androlog.Log;

/**
 * Created with IntelliJ IDEA.
 * User: lli
 * Date: 17.12.12
 * Time: 18:55
 * To change this template use File | Settings | File Templates.
 */
public class DefineWorkScheduleActivity extends Activity {


    static final int DEFAULT_WORK_H_PER_DAY = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initializes the logging
        Log.init();

        // Log a message (only on dev platform)
        Log.i(this, "onCreate");

        setContentView(R.layout.define_work_schedule);

        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(DEFAULT_WORK_H_PER_DAY);
        timePicker.setCurrentMinute(0);
    }

    public void onConfirmTimeButtonClick(View view) {
        Intent intent = new Intent(DefineWorkScheduleActivity.this, DefinePowerActivity.class);
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);

        double workTimePerDay = timePicker.getCurrentHour() + timePicker.getCurrentMinute() / 60d;

        // replace with validate methods
        if(workTimePerDay == 0.0d){
            throw new RuntimeException("work time per day set to 0.0d!");
        }

        intent.putExtra(DefinePowerActivity.DAILY_WORK_SCHEDULE, workTimePerDay);

        startActivity(intent);
    }

}
