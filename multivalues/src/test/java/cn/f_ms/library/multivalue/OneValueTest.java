package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * OneValueTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class OneValueTest {

    @Test
    public void test() {

        String testStr = "test_string";

        OneValue<String> oneValue = new OneValue<>(testStr);

        assertThat(oneValue.first(), is(testStr));
    }

}