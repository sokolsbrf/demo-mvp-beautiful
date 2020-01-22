package ru.dimasokol.school.demomvp;

public class CounterModel {

    public CounterModel(TaskRunner taskRunner) {
        mTaskRunner = taskRunner;
    }

    private int mCounter = 0;
    private final TaskRunner mTaskRunner;

    public void increment(final OnCounterUpdated listener) {
        mTaskRunner.runTask(new Runnable() {
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
        });
    }

    public int getCounter() {
        return mCounter;
    }

    public interface OnCounterUpdated {
        void counterUpdated(int counter);
    }

}
