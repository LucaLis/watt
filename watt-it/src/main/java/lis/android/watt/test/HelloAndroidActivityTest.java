package lis.android.watt.test;

import android.test.ActivityInstrumentationTestCase2;
import lis.android.watt.*;

public class HelloAndroidActivityTest extends ActivityInstrumentationTestCase2<WattWelcomeActivity> {

    public HelloAndroidActivityTest() {
        super(WattWelcomeActivity.class);
    }

    public void testActivity() {
        WattWelcomeActivity activity = getActivity();
        assertNotNull(activity);
    }
}

