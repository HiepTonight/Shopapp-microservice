package com.hieptran.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Utility {
    public boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
