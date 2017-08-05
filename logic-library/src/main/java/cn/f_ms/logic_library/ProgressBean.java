package cn.f_ms.logic_library;

import java.util.LinkedList;

/**
 * ProgressBean
 *
 * @param <T> FinalData
 */
public class ProgressBean<T> {

    private static final int MAX_POOL_SIZE = 20;

    private static LinkedList<ProgressBean> sPoolList;

    private long total = 0;
    private long progress = 0;
    private T data = null;

    private boolean isRecycle = false;

    public ProgressBean() { this(0, 0, null); }
    public ProgressBean(long total, long progress) { this(total, progress, null); }
    public ProgressBean(long total, long progress, T data) {
        this.total = total;
        this.progress = progress;
        this.data = data;
    }

    public long total() { return total; }
    public long progress() { return progress; }
    public T data() { return data; }

    public void total(long total) { this.total = total; }
    public void progress(long progress) { this.progress = progress; }
    public void data(T data) { this.data = data; }

    public void recycle() {
        synchronized (ProgressBean.class) {

            if (sPoolList == null) {
                sPoolList = new LinkedList<>();
            }

            if (sPoolList.size() > MAX_POOL_SIZE) {
                return;
            }

            if (isRecycle) {
                return;
            }
            emptyData(this);
            this.isRecycle = true;
            sPoolList.add(this);
        }
    }

    public static <T> ProgressBean obtain() { return obtain(0, 0, null); }
    public static <T> ProgressBean obtain(long total, long progress) { return obtain(total, progress, null); }
    public static <T> ProgressBean obtain(long total, long progress, T data) {
        synchronized (ProgressBean.class) {

            if (sPoolList != null
                    && !sPoolList.isEmpty()) {
                ProgressBean bean = sPoolList.remove();
                bean.isRecycle = false;

                bean.total(total);
                bean.progress(progress);
                bean.data(data);

                return bean;
            }
        }
        return new ProgressBean<>();
    }

    private static void emptyData(ProgressBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("bean can't be null");
        }

        bean.progress = 0;
        bean.total =  0;
        bean.data = null;
    }

    @Override
    public String toString() {
        return "ProgressBean{" +
                "total=" + total +
                ", progress=" + progress +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProgressBean<?> that = (ProgressBean<?>) o;

        if (total != that.total) return false;
        if (progress != that.progress) return false;
        return data.equals(that.data);

    }

    @Override
    public int hashCode() {
        int result = (int) (total ^ (total >>> 32));
        result = 31 * result + (int) (progress ^ (progress >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}