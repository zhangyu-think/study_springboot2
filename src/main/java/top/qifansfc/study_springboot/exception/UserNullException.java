package top.qifansfc.study_springboot.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.qifansfc.study_springboot.util.Result;
import top.qifansfc.study_springboot.util.ReturnResult;

@ControllerAdvice
public class UserNullException {
    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result userNull(Exception e){
        if(e instanceof UserException){
            UserException userException=(UserException)e;
            return ReturnResult.failed(userException.getCode(),userException.getMessage());
        }else{
            return ReturnResult.failed(-1,"未知错误");
        }
    }
}