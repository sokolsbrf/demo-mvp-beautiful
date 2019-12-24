package ru.dimasokol.school.demomvp;

public class CounterPresenter extends BasePresenter<CounterView> implements CounterModel.OnCounterUpdated {

    private final ThreadNotifier mUiNotifier;

    private CounterView mView;
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
        mView = null;
    }

    public void increment() {
        mModel.increment(this);
    }

    @Override
    public void counterUpdated(final int counter) {
        mUiNotifier.runOnTargetThread(new Runnable() {
            @Override
            public void run() {
                if (mView != null) {
                    mView.setCount(counter);
                }
            }
        });
    }
}
