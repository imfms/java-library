package cn.f_ms.library.multivalue;

/**
 * TwoValues
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class TwoValues<First, Second> {

    private final First first;
    private final Second second;

    public TwoValues(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First first() { return first;  }
    public Second second() {  return second; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TwoValues<?, ?> that = (TwoValues<?, ?>) o;

        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        return second != null ? second.equals(that.second) : that.second == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }
}
