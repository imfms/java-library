package cn.f_ms.library.logic;

/**
 * None
 *
 * @author imf_m
 * @time 2017/7/15
 */

public final class None implements INone {
    private static final None NONE = new None();

    private None() {}

    public static final None instance() { return NONE; }
}
