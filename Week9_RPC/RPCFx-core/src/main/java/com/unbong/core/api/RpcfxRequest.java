package com.unbong.core.api;

import lombok.Data;

@Data
public class RpcfxRequest {

    private String serviceClass;
    private String methodName;
    private  Object[] args;
}
