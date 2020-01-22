package ru.dimasokol.school.demomvp;

import androidx.annotation.NonNull;

public class CounterPresenter extends BasePresenter<CounterView> implements CounterModel.OnCounterUpdated {

    private final ThreadNotifier mUiNotifier;

    @NonNull
    private CounterView mView = new DumbView();
    private final CounterModel mModel;

    public CounterPresenter(ThreadNotifier uiNotifier, CounterModel model) {
        mUiNotifier = uiNotifier;
        mModel = model;
    }

    @Override
    public void attachView(CounterView view) {
        mView = view;
        mView.setCount(mModel.getCounter());
    }

    @Override
    public void detachView() {
        mView = new DumbView();
    }

    public void increment() {
        mModel.increment(this);
    }

    @Override
    public void counterUpdated(final int counter) {
        mUiNotifier.runOnTargetThread(new Runnable() {
            @Override
            public void run() {
                mView.setCount(counter);
            }
        });
    }

    private static class DumbView implements CounterView {
        @Override
        public void setCount(int count) {
        }
    }
}
