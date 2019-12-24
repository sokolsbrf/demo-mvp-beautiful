package ru.dimasokol.school.demomvp;

public class CounterModel {

    private static CounterModel sInstance;

    public static CounterModel getInstance() {
        if (sInstance == null) {
            sInstance = new CounterModel();
        }

        return sInstance;
    }

    private int mCounter = 0;

    public void increment(final OnCounterUpdated listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mCounter++;
                listener.counterUpdated(mCounter);
            }
        }).start();
    }

    public int getCounter() {
        return mCounter;
    }

    public interface OnCounterUpdated {
        void counterUpdated(int counter);
    }

}
