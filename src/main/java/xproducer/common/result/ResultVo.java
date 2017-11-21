package xproducer.common.result;

/**
 * Created by SYJ on 2017/11/20.
 */
public class ResultVo<T> {

    private int code;
    private String message;
    private T data;
    private long time;

    public ResultVo() {

    }

    public ResultVo success() {
        return new ResultVo(ViewHint.success);
    }

    public ResultVo success(T data) {
        return new ResultVo(ViewHint.success, data);
    }

    public ResultVo fail() {
        return new ResultVo(ViewHint.fail);
    }

    public ResultVo(ViewHint viewHint) {
        this.message = viewHint.getMessage();
        this.code = viewHint.getCode();
        this.data = null;
        this.time = System.currentTimeMillis();
    }

    public ResultVo(ViewHint viewHint, T data) {
        this.message = viewHint.getMessage();
        this.code = viewHint.getCode();
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public ResultVo(String message, int code) {
        this(message, code, null);
    }

    public ResultVo(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.time = System.currentTimeMillis();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
