package cn.f_ms.logic_library;

/**
 * ProgressBean
 *
 * @param <T> FinalData
 */
public class ProgressBean<T> {

    private long total;
    private long progress;
    private T data;

    public ProgressBean(long total, long progress) {
        this(total, progress, null);
    }

    public ProgressBean(long total, long progress, T data) {
        this.total = total;
        this.progress = progress;
        this.data = data;
    }

    public long total() { return total; }
    public long progress() { return progress; }
    public T data() { return data; }

    @Override
    public String toString() {
        return "ProgressBean{" +
                "total=" + total +
                ", progress=" + progress +
                ", data=" + data +
                '}';
    }
}