package cn.f_ms.logic_library;

/**
 * DoubleValue
 *
 * @author imf_m
 * @time 2017/7/15
 */

public class DoubleValue<First, Second> {

    private First first;
    private Second second;

    public DoubleValue() {}
    public DoubleValue(First first) { this.first = first; }
    public DoubleValue(First first, Second second) {
        this.first = first;
        this.second = second;
    }

    public First getFirst() { return first;  }
    public void setFirst(First first) { this.first = first; }
    public Second getSecond() {  return second; }
    public void setSecond(Second second) { this.second = second; }
}
