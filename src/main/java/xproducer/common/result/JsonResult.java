package xproducer.common.result;

import com.alibaba.fastjson.JSON;

/**
 * Created by SYJ on 2017/11/20.
 */
public class JsonResult<T> {

    public String jsonSuccess() {
        ResultVo resultVo = new ResultVo(ViewHint.success, null);
        return JSON.toJSONString(resultVo);
    }

    public String jsonSuccess(T data) {
        ResultVo resultVo = new ResultVo(ViewHint.success, data);
        return JSON.toJSONString(resultVo);
    }

    public String jsonFail() {
        ResultVo resultVo = new ResultVo(ViewHint.fail, null);
        return JSON.toJSONString(resultVo);
    }

    public String jsonResult(ViewHint viewHint) {
        ResultVo resultVo = new ResultVo(viewHint);
        return JSON.toJSONString(resultVo);
    }

    public String jsonResult(ViewHint viewHint, T data) {
        ResultVo resultVo = new ResultVo(viewHint, data);
        return JSON.toJSONString(resultVo);
    }

    public String jsonResult(String message, int code) {
        return this.jsonResult(message, code, null);
    }

    public String jsonResult(String message, int code, T data) {
        ResultVo<T> resultVo = new ResultVo<>(message, code, data);
        return JSON.toJSONString(resultVo);
    }

}
