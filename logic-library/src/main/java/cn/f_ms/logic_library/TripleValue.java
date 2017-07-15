package cn.f_ms.logic_library;

/**
 * TripleValue
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class TripleValue<First, Second, Third> {

    private First first;
    private Second second;
    private Third third;

    public TripleValue() {}
    public TripleValue(First first) { this.first = first; }
    public TripleValue(First first, Second second) {
        this.first = first;
        this.second = second;
    }
    public TripleValue(First first, Second second, Third third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public First getFirst() { return first;  }
    public void setFirst(First first) { this.first = first; }
    public Second getSecond() {  return second; }
    public void setSecond(Second second) { this.second = second; }
    public Third getThird() { return third; }
    public void setThird(Third third) { this.third = third; }
}
