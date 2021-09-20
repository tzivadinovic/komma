package com.tzivadinovic.komma.util;

import java.text.Normalizer;

public class StringUtils {
    public static String normalize(String toBeNormalized) {
        return Normalizer
                .normalize(toBeNormalized, Normalizer.Form.NFKD)
                .replaceAll("[^\\p{ASCII}]", "");
    }
}
