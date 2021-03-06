package com.wits.witssrcconnect.fragments;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.wits.witssrcconnect.R;
import com.wits.witssrcconnect.utils.ServerUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(AndroidJUnit4.class)
public class AllSrcActivitiesFragmentTest {

    private Context c = getTargetContext();

    @Test
    public void init() {
        getInstrumentation().runOnMainSync(()->{
            try {
                JSONArray testJsonArray = new JSONArray();
                JSONObject testJsonObject = new JSONObject();
                testJsonObject.put(ServerUtils.ACTIVITY_ID, anyInt());
                testJsonObject.put(ServerUtils.ACTIVITY_TITLE, anyString());
                testJsonObject.put(ServerUtils.ACTIVITY_DESC, anyString());
                testJsonObject.put(ServerUtils.SRC_USERNAME, anyString());
                testJsonObject.put(ServerUtils.ACTIVITY_DATE, anyString());
                testJsonObject.put(ServerUtils.ACTIVITY_TIME, anyString());

                testJsonArray.put(testJsonObject);
                testJsonArray.put(testJsonObject);
                AllSrcActivitiesFragment.v = View.inflate(c, R.layout.fragment_src_activity_view, null);
                AllSrcActivitiesFragment.init(testJsonArray);
                AllSrcActivitiesFragment.v = null;
                AllSrcActivitiesFragment.init(testJsonArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }
}