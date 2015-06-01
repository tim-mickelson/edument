package se.addskills.day2.excercise7;

/**
 * Created by purple.tim on 27/5/2015.
 */
public class HttpException extends Exception {
    private HttpError httpError;

    public HttpException(HttpError httpErrorv){
        this.httpError = httpError;
    }

    public HttpException(HttpError httpError, String message){
        super(message);
        this.httpError = httpError;
    }

    public HttpError getHttpError(){
        return httpError;
    }

    /**
     * Enumerator for common HTTP codes.
     *
     * @author Tim Mickelson
     * @since 26/05/2015
     */
    public enum HttpError{
        OK(200), ACCEPTED(202), BAD_REQUEST(400), FORBIDDEN(403), NOT_FOUND(404);
        private int value;

        /**
         * Private constructor injecting the value
         * @param value
         */
        private HttpError(int value){
            this.value = value;
        }  // end constructor

        /**
         * Nice String with name and code of enumerator.
         * @return Returns the name and code of this enum constant, as contained in the declaration.
         */
        @Override
        public String toString(){
            return super.toString()+" ("+value+")";
        }

        public int value(){
            return value;
        }

        /**
         * Utility function to map int code to corresponding Social enumerator.
         *
         * @param value code of Social enumerator
         * @throws IllegalArgumentException if value not valid
         * @return The mapped Social entity
         */
        public static HttpError httpError(int value){
            for(HttpError error: HttpError.values()){
                if(error.equals(value))
                    return error;
            }
            // If we come here the int value is not valid
            throw new IllegalArgumentException("value = "+value+" is not a valid enumerator code!");
        }  // end public static function social

    }  // end enumerator HttpError

}  // end HttpException