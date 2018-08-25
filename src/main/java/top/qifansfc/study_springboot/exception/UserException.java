package top.qifansfc.study_springboot.exception;

public class UserException extends RuntimeException {
    private int code;
    public UserException(int code,String message){
        super(message);
        this.code=code;
    }
    public int getCode(){
        return code;
    }
    public void setCode(int code){
        this.code=code;
    }
}
