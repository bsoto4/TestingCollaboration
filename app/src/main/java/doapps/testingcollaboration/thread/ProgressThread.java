package doapps.testingcollaboration.thread;

import android.app.Activity;
 import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import doapps.testingcollaboration.R;
import doapps.testingcollaboration.activity.MainActivity;
import doapps.testingcollaboration.activity.SplashActivity;

/**
 * Created by frank on 13/07/16.
 */
public class ProgressThread extends Thread {
    private static final String TAG = "ProgressThread";
    private Context context;
    private int i=0;
    private ProgressBar pg ;
    private Activity act;
    private TextView tv;
    private Handler handler;

    public ProgressThread(Context context) {
        this.context = context;
        act = ((Activity)context);
        //pg =  (((ProgressBar)((Activity)context).findViewById(R.id.progressBar)));
        pg =  (((ProgressBar)act.findViewById(R.id.progressBar)));
        tv =  (((TextView) act.findViewById(R.id.textView)));
        handler = new Handler();

    }



    @Override
    public void run() {
        while(i<101){
            Log.e(TAG,""+i);
            try{
                act.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       // (((ProgressBar)((Activity)context).findViewById(R.id.progressBar))).setProgress(i);
                        pg.setProgress(i);
                        tv.setText("Cargando ... "+i+"%");
                    }
                });
                Thread.sleep(50);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            if(i==100){
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(act, MainActivity.class);
                        act.startActivity(intent);
                        act.finish();
                    }
                }, 3000);

            }

            i++;
        }
    }
}
