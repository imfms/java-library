package cn.f_ms.library.logic;

/**
 * IsSelectValue
 *
 * @author imf_m
 * @date 2017/7/16
 */

public class IsSelectValue<V> {

    private boolean isSelect;
    private final V value;

    public IsSelectValue(V value) { this(false, value); }
    public IsSelectValue(boolean isSelect, V value) {
        this.value = value;
        this.isSelect = isSelect;
    }

    public V value() { return value; }
    public boolean isSelect() { return isSelect; }
    public void setSelect(boolean select) { isSelect = select; }
}
