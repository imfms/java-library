package cn.f_ms.logic_library;

/**
 * Multivalues Helper
 *
 * @author imf_m
 * @time 2017/9/3
 */

public final class MultiValues {

    public static <First> OneValue<First> create(First first) {
        return new OneValue<>(first);
    }

    public static <First, Second> TwoValues<First, Second> create(First first, Second second) {
        return new TwoValues<>(first, second);
    }

    public static <First, Second, Third> ThreeValues<First, Second, Third> create(First first, Second second, Third third) {
        return new ThreeValues<>(first, second, third);
    }

    public static <First, Second, Third, Fourth> FourValues<First, Second, Third, Fourth> create(First first, Second second, Third third, Fourth fourth) {
        return new FourValues<>(first, second, third, fourth);
    }
}
