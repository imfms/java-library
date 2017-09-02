package cn.f_ms.multivalues;

/**
 * ThreeValues
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class FiveValues<First, Second, Third, Fourth, Fifth> {

    private final First first;
    private final Second second;
    private final Third third;
    private final Fourth fourth;
    private final Fifth fifth;

    public FiveValues(First first, Second second, Third third, Fourth fourth, Fifth fifth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
    }

    public First first() { return first;  }
    public Second second() {  return second; }
    public Third third() { return third; }
    public Fourth fourth() { return fourth; }
    public Fifth fifth() { return fifth; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FiveValues<?, ?, ?, ?, ?> that = (FiveValues<?, ?, ?, ?, ?>) o;

        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        if (second != null ? !second.equals(that.second) : that.second != null) return false;
        if (third != null ? !third.equals(that.third) : that.third != null) return false;
        if (fourth != null ? !fourth.equals(that.fourth) : that.fourth != null) return false;
        return fifth != null ? fifth.equals(that.fifth) : that.fifth == null;

    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        result = 31 * result + (third != null ? third.hashCode() : 0);
        result = 31 * result + (fourth != null ? fourth.hashCode() : 0);
        result = 31 * result + (fifth != null ? fifth.hashCode() : 0);
        return result;
    }
}
