package se.edument.exercise.seven;

/**
 * Created by purple.tim on 27/5/2015.
 */
public class HttpException extends Exception {
    private HttpCode httpCode;

    public HttpException(HttpCode httpCode){
        this.httpCode = httpCode;
    }

    public HttpException(HttpCode httpCode, String message){
        super(message);
        this.httpCode = httpCode;
    }

    public HttpCode getHttpCode(){
        return httpCode;
    }

    public enum HttpCode{
        OK(200), NOT_FOUND(403);
        private int value;

        private HttpCode(int value){
            this.value = value;
        }

        public int value(){
            return value;
        }

        public static HttpCode httpCode(int code){
            for(HttpCode httpCode:HttpCode.values()){
                if(httpCode.value==code)
                    return httpCode;
            }
            throw new IllegalArgumentException(String.format("The http code %d is invalid", code));
        }
    }
}  // end HttpException