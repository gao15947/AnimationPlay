package com.six.animationplay.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/29.
 */

public class EncodeSignUtils {

    public static String encodeSign(Map<String, String> params, String secret) {
        List<String> keyLists = new ArrayList<>();
        for (String key : params.keySet()) {
            keyLists.add(key);
        }
        Collections.sort(keyLists);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < keyLists.size(); i++) {
            builder.append(keyLists.get(i));
            builder.append("=");
            builder.append(params.get(keyLists.get(i)));
            if (i != keyLists.size()) {
                builder.append("&");
            }
        }

        return MD5(builder.toString() + secret);
    }

    private static String MD5(String formal) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(formal.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
