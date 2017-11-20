package xproducer.common.result;

/**
 * Created by SYJ on 2017/11/20.
 */
public enum ViewHint {

    success("成功", 200),
    fail("失败", 500);

    private String message;
    private int code;

    ViewHint(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
