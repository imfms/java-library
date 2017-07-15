package cn.f_ms.logic_library;

/**
 * SingleValue
 *
 * @author imf_m
 * @time 2017/7/15
 */
public class SingleValue<T> {

    private T value;

    public SingleValue() {}

    public SingleValue(T value) { this.value = value; }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
