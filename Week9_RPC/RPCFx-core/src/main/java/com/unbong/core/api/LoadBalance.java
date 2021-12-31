package com.unbong.core.api;

import java.util.List;

public interface LoadBalance {
    String select(List<String> urls);
}
