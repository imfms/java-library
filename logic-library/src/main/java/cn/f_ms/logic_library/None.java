package cn.f_ms.logic_library;

/**
 * None
 *
 * @author imf_m
 * @time 2017/7/15
 */

public final class None {
    private static final None NONE = new None();
    private None() {}
    public static final None NONE() { return NONE; }
}
