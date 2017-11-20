package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * MultiValuesTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class MultiValuesTest {
    @Test
    public void create() throws Exception {

        String valueA = "A";
        OneValue<String> values = MultiValues.create(valueA);

        assertThat(values.first(), is(valueA));
    }

    @Test
    public void create1() throws Exception {
        String valueA = "A";
        String valueB = "B";
        TwoValues<String, String> values = MultiValues.create(valueA, valueB);

        assertThat(values.first(), is(valueA));
        assertThat(values.second(), is(valueB));
    }

    @Test
    public void create2() throws Exception {
        String valueA = "A";
        String valueB = "B";
        String valueC = "C";
        ThreeValues<String, String, String> values = MultiValues.create(valueA, valueB, valueC);

        assertThat(values.first(), is(valueA));
        assertThat(values.second(), is(valueB));
        assertThat(values.third(), is(valueC));
    }

    @Test
    public void create3() throws Exception {
        String valueA = "A";
        String valueB = "B";
        String valueC = "C";
        String valueD = "D";
        FourValues<String, String, String, String> values = MultiValues.create(valueA, valueB, valueC, valueD);

        assertThat(values.first(), is(valueA));
        assertThat(values.second(), is(valueB));
        assertThat(values.third(), is(valueC));
        assertThat(values.fourth(), is(valueD));
    }

    @Test
    public void create4() throws Exception {

        String valueA = "A";
        String valueB = "B";
        String valueC = "C";
        String valueD = "D";
        String valueE = "E";
        FiveValues<String, String, String, String, String> values = MultiValues.create(valueA, valueB, valueC, valueD, valueE);

        assertThat(values.first(), is(valueA));
        assertThat(values.second(), is(valueB));
        assertThat(values.third(), is(valueC));
        assertThat(values.fourth(), is(valueD));
        assertThat(values.fifth(), is(valueE));
    }

}