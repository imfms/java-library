package cn.f_ms.library.logic;

/**
 * Desc: is it success with data?
 *
 * @author f_ms
 * @date 18-3-8
 */

public final class IsSuccess<SuccessData> {

    private final boolean isSuccess;
    private final String errorMessage;
    private final SuccessData successData;

    /**
     * get a success value with successData
     */
    public IsSuccess(SuccessData successData) {
        this(true, null, successData);
    }

    /**
     * get a error value with error message
     * @param errorMessage error message
     */
    public IsSuccess(String errorMessage) {
        this(false, errorMessage, null);
    }

    /**
     * get a IsSuccess instance
     * @param isSuccess    is success?
     * @param errorMessage error message if not success
     * @param successData  success data if success
     */
    public IsSuccess(boolean isSuccess, String errorMessage, SuccessData successData) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
        this.successData = successData;
    }

    /**
     * is a success value?
     * @return true == success, false == error
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * get success data
     * @return success data
     */
    public SuccessData data() { return successData; }

    /**
     * get error message if error
     * @return error message
     */
    public String errorMessage() {
        return errorMessage;
    }
}
