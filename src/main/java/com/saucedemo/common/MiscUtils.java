package com.saucedemo.common;

import java.util.Collections;
import java.util.List;

public class MiscUtils {

    public static List<?> sortList(List<? extends Comparable> list, boolean isReverseOrder) {
        if (isReverseOrder) {
            list.sort(Collections.reverseOrder());
        } else {
            Collections.sort(list);
        }
        return list;
    }
}
