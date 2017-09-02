package cn.f_ms.multivalues;

/**
 * ThreeValues
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class FourValues<First, Second, Third, Fourth> {

    private final First first;
    private final Second second;
    private final Third third;
    private final Fourth fourth;

    public FourValues(First first, Second second, Third third, Fourth fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public First first() { return first;  }
    public Second second() {  return second; }
    public Third third() { return third; }
    public Fourth fourth() { return fourth; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FourValues<?, ?, ?, ?> that = (FourValues<?, ?, ?, ?>) o;

        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;
        if (third != null ? !third.equals(that.third) : that.third != null) return false;
        return fourth != null ? fourth.equals(that.fourth) : that.fourth == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        result = 31 * result + (fourth != null ? fourth.hashCode() : 0);
        return result;
    }
}
