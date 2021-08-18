package com.matrixboot.vanguard.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * create in 2021/8/16 4:24 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Data
@Builder
@AllArgsConstructor
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 1686870626835587413L;

    private Integer status;

    private String message;

    private T data;

    public ResultVO() {
    }

    public ResultVO(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

//    public static <T extends Serializable> ResultVO<T> success() {
//        return ResultVO.<T>builder().status(200).message("执行成功").build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> success(String message) {
//        return ResultVO.<T>builder().status(200).message(message).build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> success(String message, T data) {
//        return ResultVO.<T>builder().status(200).message(message).data(data).build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> success(T data) {
//        return ResultVO.<T>builder().status(200).message("执行成功").data(data).build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> failure() {
//        return ResultVO.<T>builder().status(500).message("执行失败").build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> failure(String message) {
//        return ResultVO.<T>builder().status(500).message(message).build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> failure(String message, T data) {
//        return ResultVO.<T>builder().status(500).message(message).data(data).build();
//    }
//
//    public static <T extends Serializable> ResultVO<T> failure(T data) {
//        return ResultVO.<T>builder().status(500).message("执行失败").data(data).build();
//    }

}
