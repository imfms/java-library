package cn.f_ms.multivalues;

/**
 * ThreeValues
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class ThreeValues<First, Second, Third> {

    private final First first;
    private final Second second;
    private final Third third;

    public ThreeValues(First first, Second second, Third third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public First first() { return first;  }
    public Second second() {  return second; }
    public Third third() { return third; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreeValues<?, ?, ?> that = (ThreeValues<?, ?, ?>) o;

        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;
        return third != null ? third.equals(that.third) : that.third == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        return result;
    }
}
