package org.thoth.jeesa.lang;

import java.util.Map;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class MyReflectionToStringBuilder {
    public static String toString(Object o) {
        if (o == null) {
            return "{null}";
        } else {
            if (o instanceof Map) {
                Map map = (Map)o;
                StringBuilder sp = new StringBuilder();
                sp.append("[");
                map.forEach((key, value) -> {
                    sp.append("{Key=" + key + ", Value=" + value + "} ");
                });
                sp.append("]");
                return sp.toString();
            }
            return ReflectionToStringBuilder.toString(o);
        }
    }
}
