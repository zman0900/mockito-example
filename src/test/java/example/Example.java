package example;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;

public class Example {

    public interface FirstInterface<T> {
        boolean normal();
        T generic();
    }

    public interface SecondInterface<T> extends FirstInterface<T> { }

    public class TestClass<T> {
        public abstract class AbstractInner implements SecondInterface<T> { }
    }

    private TestClass.AbstractInner testMock;

    @Before
    public void setup() {
        testMock = mock(TestClass.AbstractInner.class, RETURNS_DEEP_STUBS);
    }

    @Test
    public void works() {
        testMock.normal();
    }

    @Test
    public void fails() {
        testMock.generic();
    }
}
