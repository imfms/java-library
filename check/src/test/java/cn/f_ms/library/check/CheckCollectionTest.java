package cn.f_ms.library.check;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * CheckCollection's Test
 *
 * @author f_ms
 * @date 17-11-19
 */
public class CheckCollectionTest {

    @Test
    public void isEmptyWithNullTest() {

        /*
        override Collection<T> collection
         */
        assertThat(
                CheckCollection.isEmptyWithNull((Collection) null), is(true)
        );

        assertThat(
                CheckCollection.isEmptyWithNull(new ArrayList()), is(true)
        );

        ArrayList<Object> collection = new ArrayList<>();
        collection.add(null);
        assertThat(
                CheckCollection.isEmptyWithNull(collection), is(false)
        );

        /*
        override T[]
         */
        assertThat(
                CheckCollection.isEmptyWithNull((Object[]) null), is(true)
        );

        assertThat(
                CheckCollection.isEmptyWithNull(new Object[0]), is(true)
        );

        assertThat(
                CheckCollection.isEmptyWithNull(new Object[1]), is(false)
        );
    }

    @Test
    public void ifExistNullThrowExceptionTest() {
         /*
        override T[] arr
         */
        {
            try {
                CheckCollection.ifExistNullThrowException((Object[]) null, new RuntimeException("error message"));
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertThat(e, isA((Class) IllegalArgumentException.class));
                assertThat(e.getMessage(), equalTo("array can't be null"));
            }

            try {
                CheckCollection.ifExistNullThrowException(new Object[0], null);
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertThat(e, isA((Class) IllegalArgumentException.class));
                assertThat(e.getMessage(), equalTo("runtimeException can't be null"));
            }

            Object[] data1 = new Object[0];
            assertThat(
                    data1, is(CheckCollection.ifExistNullThrowException(data1, new RuntimeException("error message")))
            );

            RuntimeException exception = new RuntimeException("error message");
            try {
                Object[] data2 = {"", null};
                CheckCollection.ifExistNullThrowException(data2, exception);
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertEquals(exception, e);
            }
        }

        /*
        override Iterable<T> iterable
         */
        {
            try {
                CheckCollection.ifExistNullThrowException((Iterable) null, new RuntimeException("error message"));
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertThat(e, isA((Class) IllegalArgumentException.class));
                assertThat(e.getMessage(), equalTo("iterator can't be null"));
            }

            try {
                CheckCollection.ifExistNullThrowException(Arrays.asList(), null);
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertThat(e, isA((Class) IllegalArgumentException.class));
                assertThat(e.getMessage(), equalTo("runtimeException can't be null"));
            }

            List<String> data1 = Arrays.asList("");
            assertThat(
                    data1, is(CheckCollection.ifExistNullThrowException(data1, new RuntimeException("error message")))
            );

            RuntimeException exception = new RuntimeException("error message");
            try {
                List<String> data2 = Arrays.asList("", null);
                CheckCollection.ifExistNullThrowException(data2, exception);
                fail("expect throw exception but none");
            } catch (Exception e) {
                assertEquals(exception, e);
            }
        }
    }

    @Test
    public void isAllNullTest() {

        try {
            CheckCollection.isAllNull(null);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("iterable can't be null"));
        }

        assertThat(
                CheckCollection.isAllNull(Arrays.asList(null, null, null)), is(true)
        );

        assertThat(
                CheckCollection.isAllNull(Arrays.asList("")), is(false)
        );
    }

    @Test
    public void isExistNullTest() {

        /*
        override T[]
         */
        try {
            CheckCollection.isExistNull((Object[])null);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("array can't be null"));
        }

        Object[] testData = {"", ""};
        assertThat(
                CheckCollection.isExistNull(testData), is(false)
        );

        Object[] testData2 = {"", null, ""};
        assertThat(
                CheckCollection.isExistNull(testData2), is(true)
        );

        /*
        override Iterable<T>
         */
        try {
            CheckCollection.isExistNull((Iterable<String>) null);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("iterator can't be null"));
        }

        assertThat(
                CheckCollection.isExistNull(Arrays.asList("", "")), is(false)
        );

        assertThat(
                CheckCollection.isExistNull(Arrays.asList("", null, "")), is(true)
        );
    }

    @Test
    public void ifExistNullThrowArgExceptionTest() {

        /*
        override T[]
         */
        try {
            CheckCollection.ifExistNullThrowArgException((Object[])null);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("array can't be null"));
        }

        Object[] testData = {"", ""};
        assertThat(
                CheckCollection.ifExistNullThrowArgException(testData), is(testData)
        );

        Object[] testData2 = {"", null};
        try {
            CheckCollection.ifExistNullThrowArgException(testData2);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("index value '1' is null, array element can't container null element"));
        }

        /*
        override Iterable<T>
         */
        try {
            CheckCollection.ifExistNullThrowArgException((Iterable<String>) null);
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("iterator can't be null"));
        }

        List<String> testData3 = Arrays.asList("", "");
        assertThat(
                CheckCollection.ifExistNullThrowArgException(testData3), is(testData3)
        );

        try {
            CheckCollection.ifExistNullThrowArgException(Arrays.asList("", null, ""));
            fail("expect throw exception but none");
        } catch (Exception e) {
            assertThat(e, isA((Class) IllegalArgumentException.class));
            assertThat(e.getMessage(), equalTo("iterator element can't container null value"));
        }
    }
}
