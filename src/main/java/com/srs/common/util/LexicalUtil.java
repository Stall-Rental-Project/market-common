package com.srs.common.util;

import org.apache.commons.lang3.StringUtils;

import java.text.Normalizer;
import java.util.Collection;
import java.util.stream.Collectors;


public class LexicalUtil {
    public static String removeWhitespace(String input) {
        return StringUtils.isNotBlank(input)
                ? input.replaceAll("\\p{javaSpaceChar}+", " ").trim()
                : "";
    }

    public static String slugify(String input) {
        if (input == null) {
            return "";
        }
        String result = Normalizer.normalize(input, Normalizer.Form.NFD);
        result = result.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        result = result.replace('đ', 'd');
        result = result.replace('Đ', 'D');
        result = result.replaceAll("[^a-z A-Z0-9-]", "");
        result = result.replaceAll(" ", "-");
        result = result.replaceAll("--", "-");
        result = result.replaceAll("\\.", "");
        return result.toLowerCase();
    }

    public static String doubleQuoteForWord(String input){
        return StringUtils.isNotBlank(input)
            ? '"'+input+'"'
            : "";
    }

    public static String[] collectionToArray(Collection<String> collection ){
        if(collection.size()>0){
            return collection.stream().toArray(String[]::new);
        } else {
            return null;
        }
    }
}
