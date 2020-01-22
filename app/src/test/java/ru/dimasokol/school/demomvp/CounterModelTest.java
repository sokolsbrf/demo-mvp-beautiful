package ru.dimasokol.school.demomvp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CounterModelTest {

    private CounterModel mModel;
    private CounterModel.OnCounterUpdated mListener;

    @Before
    public void setUp() throws Exception {
        mModel = new CounterModel(new StubTaskRunner());
        mListener = mock(CounterModel.OnCounterUpdated.class);
    }

    @Test
    public void increment() {
        mModel.increment(mListener);
        verify(mListener).counterUpdated(1);
    }

    @Test
    public void getCounter() {
        assertEquals(0, mModel.getCounter());
        mModel.increment(mListener);
        assertEquals(1, mModel.getCounter());
    }
}