package com.unbong.core.api;

import java.io.IOException;

public interface RpcfxResolver {

    Object resolve(String serviceClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException;


}
