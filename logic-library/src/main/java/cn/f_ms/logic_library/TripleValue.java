package cn.f_ms.logic_library;

/**
 * TripleValue
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class TripleValue<First, Second, Third> {

    private final First first;
    private final Second second;
    private final Third third;

    public TripleValue(First first, Second second, Third third) {
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

        TripleValue<?, ?, ?> that = (TripleValue<?, ?, ?>) o;

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
