package com.ttnd.linksharing;

public enum Visibility {

    PRIVATE,PUBLIC;

    static Visibility convert(String str) {
        for (Visibility visibility : Visibility.values()) {
            if (visibility.toString().equalsIgnoreCase(str)) {
                return visibility;
            }
        }
        return null;
    }
    }
