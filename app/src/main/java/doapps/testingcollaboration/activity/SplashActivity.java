package doapps.testingcollaboration.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import doapps.testingcollaboration.R;
import doapps.testingcollaboration.thread.ProgressThread;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private ProgressThread thread ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        setContentView(R.layout.activity_splash2);

        thread=new ProgressThread(SplashActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

        thread.start();

    }


}
