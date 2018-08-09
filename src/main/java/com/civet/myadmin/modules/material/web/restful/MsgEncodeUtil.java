package com.civet.myadmin.modules.material.web.restful;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mayer on 2016/7/9.
 */
public class MsgEncodeUtil {

    private static Logger logger = LoggerFactory.getLogger("MsgEncodeUtil");

    public static String msgEncode(String str) {
        return LmBase64.encodeStr(str);
    }

    public static String msgDecode(String str) {
        return LmBase64.decodeStr(str);
    }

    public static String msgObjEncode(Object obj) {
        return  msgEncode(JSON.toJSONString(obj));
    }

    public static <T> T msgObjDecode(String str, Class<T> clazz) {
        return JSON.parseObject(msgDecode(str), clazz);
    }

    public static JSONObject msgObjDecode(String str) {
        return JSON.parseObject(msgDecode(str));
    }
}
