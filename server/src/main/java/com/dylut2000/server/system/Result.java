package com.dylut2000.server.system;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {

    private int statusCode;
    private boolean success;
    private String message;
    private Object data;

    public Result(int statusCode, boolean success, String message) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = null;
    }

    public Result(int statusCode, boolean success, String message, Object data) {
        this.statusCode = statusCode;
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // SUCCESS (1 PARAMETER)

    public static Result success(Object data) {
        return new Result(200, true, "Success", data);
    }


    // ERROR (1 PARAMETER)

    public static Result error(String message) {
        return new Result(500, false, message, null);
    }

    // ERROR (2 PARAMETERS)

    public static Result error(int statusCode, String message) {
        return new Result(statusCode, false, message, null);
    }

}
