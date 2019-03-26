package com.example.pandingintent;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class CalculateFactorialService extends Service {
    private PendingIntent pendingIntent;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int number = Integer.parseInt(intent.getStringExtra(MainActivity.NUMBER));
        pendingIntent = intent.getParcelableExtra(MainActivity.PINTENT);
        calculateFactorial(number);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void calculateFactorial(final int number) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Intent intent = new Intent().putExtra(MainActivity.PARAM_RESULT, MathUtil.calculateFactorial(number));
                    pendingIntent.send(CalculateFactorialService.this, MainActivity.FINISH_CODE, intent);
                } catch (PendingIntent.CanceledException e) {
                    e.printStackTrace();
                }
                stopSelf();
            }
        }).start();
    }

}
