package xyz.soulspace.connect_test.result;

import org.springframework.http.HttpStatus;

public class Result<T> {
    //响应码
    private HttpStatus status;
    private T body;

    public Result(HttpStatus status){
        this.status = status;
    }

    public Result(HttpStatus status, T body){
        this.status = status;
        this.body = body;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", body='" + body + '\'' +
                '}';
    }
}

