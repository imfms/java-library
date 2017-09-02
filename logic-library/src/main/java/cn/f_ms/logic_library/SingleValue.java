package cn.f_ms.logic_library;

/**
 * SingleValue
 *
 * @author imf_m
 * @time 2017/7/15
 */
public class SingleValue<T> {

    private final T value;

    public SingleValue(T value) { this.value = value; }

    public T value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleValue<?> that = (SingleValue<?>) o;

        return value != null ? value.equals(that.value) : that.value == null;

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
