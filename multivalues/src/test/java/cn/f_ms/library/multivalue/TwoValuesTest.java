package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * TwoValuesTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class TwoValuesTest {

    @Test
    public void test() {

        String valueA = "value_a";
        StringBuffer valueB = new StringBuffer("value_b");

        TwoValues<String, StringBuffer> values = new TwoValues<>(valueA, valueB);

        assertThat(valueA, is(values.first()));
        assertThat(valueB, is(values.second()));
    }

}