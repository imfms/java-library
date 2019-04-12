package ms.imf.paging;

import java.util.List;

public class PagingHelper {

    public static final int PAGE_CONTENT_COUNT = 20;
    public static final int PAGE_CONTENT_INIT = 1;

    private final int mFirstPageNum;
    private final int mEachPageItemNum;
    private int mCurrentPage;

    public PagingHelper() {
        this(PAGE_CONTENT_INIT, PAGE_CONTENT_COUNT);
    }

    public PagingHelper(int firstPageNum, int eachPageItemNum) {

        if (eachPageItemNum < 1) {
            throw new IllegalArgumentException("eachPageItemNum can't less 1, but found '" + eachPageItemNum + "'");
        }

        mFirstPageNum = firstPageNum;
        mEachPageItemNum = eachPageItemNum;
        mCurrentPage = firstPageNum;
    }

    public int pageNum() {
        return mCurrentPage;
    }

    public int eachPageItemNum() {
        return mEachPageItemNum;
    }

    public int firstPageNum() {
        return mFirstPageNum;
    }

    public void toFirstPage() {
        mCurrentPage = mFirstPageNum;
    }

    public void increase() {
        mCurrentPage++;
    }

    public void reduce() {
        if (pageNum() > firstPageNum()) {
            mCurrentPage--;
        }
    }

    public boolean isFirstPage() {
        return mCurrentPage == mFirstPageNum;
    }

    public void onRefresh() {
        toFirstPage();
    }

    public void onLoadmore() {
        increase();
    }

    public void onGetedData(boolean isEmpty) {
        if (isEmpty) {
            reduce();
        }
    }

    public void onGetedDatas(List<?> datas) {
        if (datas == null
                || datas.isEmpty()) {
            reduce();
        }
    }

    public void onGetDataError() {
        reduce();
    }

}
