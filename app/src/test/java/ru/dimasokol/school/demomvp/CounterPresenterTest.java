package ru.dimasokol.school.demomvp;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CounterPresenterTest {

    private CounterPresenter mPresenter;
    private CounterModel mModel;
    private ThreadNotifier mNotifier;

    @Before
    public void setUp() throws Exception {
        mModel = mock(CounterModel.class);
        mNotifier = new StubThreadNotifier();
        mPresenter = new CounterPresenter(mNotifier, mModel);
    }

    @Test
    public void attachView() {
        CounterView view = mock(CounterView.class);
        mPresenter.attachView(view);
        verify(view).setCount(0);
    }

    @Test
    public void detachView() {
        mPresenter.detachView();
    }

    @Test
    public void increment() {
        mPresenter.increment();
        verify(mModel).increment(mPresenter);
    }

    @Test
    public void counterUpdated() {
        CounterView view = mock(CounterView.class);
        mPresenter.attachView(view);
        mPresenter.counterUpdated(43);
        verify(view).setCount(43);
    }
}