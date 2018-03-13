package cn.f_ms.library.logic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Desc: IsSuccessTest
 *
 * @author f_ms
 * @time 18-3-13
 */
public class IsSuccessTest {

    @Test
    public void conSuccess() {
        IsSuccess<Integer> isSuccess = new IsSuccess<>(1);
        assertThat(isSuccess.isSuccess(), is(true));
        assertThat(isSuccess.data(), equalTo(1));
        assertThat(isSuccess.errorMessage(), nullValue());
    }

    @Test
    public void conError() {
        IsSuccess<Integer> isSuccess = new IsSuccess<>("error");
        assertThat(isSuccess.isSuccess(), is(false));
        assertThat(isSuccess.data(), nullValue());
        assertThat(isSuccess.errorMessage(), equalTo("error"));
    }

}