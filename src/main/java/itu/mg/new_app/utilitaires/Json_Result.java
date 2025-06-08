package itu.mg.new_app.utilitaires;

public class Json_Result <T> {
    
    
    private T data;
    private String exception;
    private String exc_type;


    public Json_Result () {}

    public String getExc_type() { return exc_type; }
    public String getException() { return exception; }
    public T getData() { return data; }

    public void setExc_type(String exc_type) { this.exc_type = exc_type; }
    public void setException(String exception) { this.exception = exception; }
    public void setData(T data) { this.data = data; }
}
