package top.qifansfc.study_springboot.util;

public class ReturnResult {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(1);
        result.setMsg("请求处理成功");
        result.setData(object);
        return result;
    }
    public static Result failed(int code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
