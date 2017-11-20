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

    public ResultVo(ViewHint viewHint) {
        this.message = viewHint.getMessage();
        this.code = viewHint.getCode();
        this.data = null;
    }

    public ResultVo(ViewHint viewHint, T data) {
        this.message = viewHint.getMessage();
        this.code = viewHint.getCode();
        this.data = data;
    }

    public ResultVo(String message, int code) {
        this(message, code, null);
    }

    public ResultVo(String message, int code, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
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
