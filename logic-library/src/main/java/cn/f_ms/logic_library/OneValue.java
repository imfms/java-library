package cn.f_ms.logic_library;

/**
 * OneValue
 *
 * @author imf_m
 * @time 2017/7/15
 */
public class OneValue<T> {

    private final T first;

    public OneValue(T value) { this.first = value; }

    public T value() {
        return first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OneValue<?> that = (OneValue<?>) o;

        return first != null ? first.equals(that.first) : that.first == null;

    }

    @Override
    public int hashCode() {
        return first != null ? first.hashCode() : 0;
    }
}
