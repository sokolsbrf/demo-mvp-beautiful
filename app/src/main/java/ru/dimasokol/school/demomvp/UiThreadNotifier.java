package ru.dimasokol.school.demomvp;

import android.os.Handler;
import android.os.Looper;

public class UiThreadNotifier implements ThreadNotifier {

    private Handler mHandler;

    @Override
    public void runOnTargetThread(Runnable code) {
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }

        mHandler.post(code);
    }
}
