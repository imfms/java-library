package cn.f_ms.library.check;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * CheckNull's unit test
 *
 * @author f_ms
 * @date 17-11-20
 */
public class CheckNullTest {


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ifNullThrowNpeTest() {
        exception.expect(NullPointerException.class);
        exception.expectMessage("value can't be null");

        CheckNull.ifNullThrowNpe(null);
    }

    @Test
    public void ifNullThrowNpeTest2() {
        exception.expect(NullPointerException.class);
        String errorMessage = "I don't like null";
        exception.expectMessage(errorMessage);

        CheckNull.ifNullThrowNpe(null, errorMessage);
    }

    @Test
    public void ifNullThrowNpeTest3() {
        exception.expect(NullPointerException.class);

        CheckNull.ifNullThrowNpe(null, null);
    }

    @Test
    public void ifNullThrowNpeTest4() {
        String testStr = "test_string";

        assertThat(
                CheckNull.ifNullThrowNpe(testStr, "I don't like null"),
                is(testStr)
        );
    }

    @Test
    public void ifNullThrowArgExceptionTest() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("value can't be null");

        CheckNull.ifNullThrowArgException(null);
    }

    @Test
    public void ifNullThrowArgExceptionTest2() {
        exception.expect(IllegalArgumentException.class);
        String errorMessage = "I don't like null";
        exception.expectMessage(errorMessage);

        CheckNull.ifNullThrowArgException(null, errorMessage);
    }


    @Test
    public void ifNullThrowArgExceptionTest3() {
        exception.expect(IllegalArgumentException.class);

        CheckNull.ifNullThrowArgException(null, null);
    }

    @Test
    public void ifNullThrowArgExceptionTest4() {
        String testStr = "test_string";

        assertThat(
                CheckNull.ifNullThrowArgException(testStr, "I don't like null"),
                is(testStr)
        );
    }

    @Test
    public void ifNullThrowExceptionTest() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("runtimeException can't be null");

        CheckNull.ifNullThrowException(null, null);
    }

    @Test
    public void ifNullThrowExceptionTest2() {
        RuntimeException runtimeException = new RuntimeException("I don't like null");
        exception.expect(runtimeException.getClass());
        exception.expectMessage(runtimeException.getMessage());

        CheckNull.ifNullThrowException(null, runtimeException);
    }

    @Test
    public void ifNullThrowExceptionTest3() {
        String testStr = "test_string";

        assertThat(
                CheckNull.ifNullThrowException(testStr, new RuntimeException("I don't like null")),
                is(testStr)
        );
    }
}
