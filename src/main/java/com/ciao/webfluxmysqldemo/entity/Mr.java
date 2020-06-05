package com.ciao.webfluxmysqldemo.entity;


import com.ciao.webfluxmysqldemo.constant.CommonConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Serializable;
import java.util.List;


/**
 * MonoResponse MR
 *
 * @param <T>
 */
@Data
@ToString(callSuper = true)
//这个是类注解,表示该类实例化的对象里，值为null的字段不参与序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mr<T> implements Serializable {
    /**
     * 消息提示。
     */
    String msg = CommonConstants.SUCCESS_MSG;
    /**
     * 业务状态码
     */
    Integer code = CommonConstants.SUCCESS;
    /**
     * 数据
     */
    T data;

    /**
     * 加密字段
     */
    String sign;

    // ----------------------------Mono支持---------------------------------------

    public static <T> Mono<Mr<T>> ok(Mono<T> monoBody) {
        return responseBodyCreate(monoBody, CommonConstants.SUCCESS, CommonConstants.SUCCESS_MSG);
    }

    public static <T> Mono<Mr<T>> ok(Mono<T> monoBody, String msg) {
        return responseBodyCreate(monoBody, CommonConstants.SUCCESS, msg);
    }

    public static <T> Mono<Mr<T>> ok(Mono<T> monoBody, int code, String msg) {
        return responseBodyCreate(monoBody, code, msg);
    }

    @Deprecated
    public static <T> Mono<Mr<T>> failedTmp(Mono<T> monoBody) {
        return responseBodyCreate(monoBody, CommonConstants.FAIL, CommonConstants.FAIL_MSG);
    }

    @Deprecated
    public static <T> Mono<Mr<T>> failed(Mono<T> monoBody, String msg) {
        return responseBodyCreate(monoBody, CommonConstants.FAIL, msg);
    }

    @Deprecated
    public static <T> Mono<Mr<T>> failed(Mono<T> monoBody, int code, String msg) {
        return responseBodyCreate(monoBody, code, msg);
    }

    public static Mono<Mr<?>> failed(Mono<String> errorMsg) {
        return responseBodyCreate( CommonConstants.FAIL, errorMsg);
    }

    // ----------------------------Flex支持---------------------------------------

    public static <T> Mono<Mr<List<T>>> ok(Flux<T> monoBody) {
        return responseBodyCreate(monoBody.collectList(), CommonConstants.SUCCESS, CommonConstants.SUCCESS_MSG);
    }

    public static <T> Mono<Mr<List<T>>> ok(Flux<T> monoBody, String msg) {
        return responseBodyCreate(monoBody.collectList(), CommonConstants.SUCCESS, msg);
    }

    public static <T> Mono<Mr<List<T>>> ok(Flux<T> monoBody, int code, String msg) {
        return responseBodyCreate(monoBody.collectList(), code, msg);
    }

    @Deprecated
    public static <T> Mono<Mr<List<T>>> failed(Flux<T> monoBody) {
        return responseBodyCreate(monoBody.collectList(), CommonConstants.FAIL, CommonConstants.FAIL_MSG);
    }

    @Deprecated
    public static <T> Mono<Mr<List<T>>> failed(Flux<T> monoBody, String msg) {
        return responseBodyCreate(monoBody.collectList(), CommonConstants.FAIL, msg);
    }

    @Deprecated
    public static <T> Mono<Mr<List<T>>> failed(Flux<T> monoBody, int code, String msg) {
        return responseBodyCreate(monoBody.collectList(), code, msg);
    }

    /**
     * Flux没有对应错误响应体的Flux响应体,请转Mono后掉一共Mono的错误响应体
     */

    // ----------------------------常规支持---------------------------------------

    public static <T> Mr<T> ok() {
        return responseBodyOtherCreate(null, CommonConstants.SUCCESS, CommonConstants.SUCCESS_MSG);
    }

    public static <T> Mr<T> ok(T monoBody) {
        return responseBodyOtherCreate(monoBody, CommonConstants.SUCCESS, CommonConstants.SUCCESS_MSG);
    }

    public static <T> Mr<T> ok(T monoBody, String msg) {
        return responseBodyOtherCreate(monoBody, CommonConstants.SUCCESS, msg);
    }

    public static <T> Mr<T> ok(T monoBody, int code, String msg) {
        return responseBodyOtherCreate(monoBody, code, msg);
    }

    @Deprecated
    public static <T> Mr<T> failed(T monoBody) {
        return responseBodyOtherCreate(monoBody, CommonConstants.FAIL, CommonConstants.FAIL_MSG);
    }

    @Deprecated
    public static <T> Mr<T> failed(T monoBody, String msg) {
        return responseBodyOtherCreate(monoBody, CommonConstants.FAIL, msg);
    }

    @Deprecated
    public static <T> Mr<T> failed(T monoBody, int code, String msg) {
        return responseBodyOtherCreate(monoBody, code, msg);
    }

    /**
     * 推荐使用
     * @param msg 信息
     * @return 响应体
     */
    public static Mr<?> failed(String msg) {
        return responseBodyOtherCreate(null, CommonConstants.FAIL, msg);
    }

    public static Mr<?> failed(int code, String msg) {
        return responseBodyOtherCreate(null, code, msg);
    }

    private static Mono<Mr<?>> responseBodyCreate(int code, Mono<String> errorMsgMono) {
        return errorMsgMono.map(errorMsg -> {
            final Mr<?> mr = new Mr<>();
            mr.setCode(code);
            mr.setMsg(errorMsg);
            return mr;
        });
    }

    private static <T> Mono<Mr<T>> responseBodyCreate(Mono<T> monoData, int code, String msg) {
        return monoData.map(data -> {
            final Mr<T> mr = new Mr<>();
            mr.setCode(code);
            mr.setData(data);
            mr.setMsg(msg);
            return mr;
        });
    }

    public static <T> Mr<T> responseBodyOtherCreate(T data, int code, String msg) {
        final Mr<T> mr = new Mr<>();
        mr.setCode(code);
        mr.setData(data);
        mr.setMsg(msg);
        return mr;
    }

    /**
     * 判断请求是否成功
     *
     * @return 成功与否
     */
    public Boolean successful() {
        return code.equals(CommonConstants.SUCCESS);
    }


}
