package cn.f_ms.logic_library;

/**
 * IsSelectValue
 *
 * @author imf_m
 * @time 2017/7/16
 */

public class IsSelectValue<V> extends SingleValue<V> {

    private boolean isSelect;

    public IsSelectValue(V value) { super(value); }
    public IsSelectValue(boolean isSelect, V value) {
        super(value);
        this.isSelect = isSelect;
    }

    public boolean isSelect() { return isSelect; }
    public void setSelect(boolean select) { isSelect = select; }
}
