package com.liu.matrixcommon.utils;

import com.liu.matrixcommon.enums.system.ConfigStatus;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 加密工具类
 * @author liuweizhong
 * @since 2024-02-27
 */
@Slf4j
public class EncryptUtils {

    /**
     * 字符串按照md5加密
     * @param str 待加密字符串
     * @return 加密后的字符串
     */
    public static String encryptMd5(String str) {
        String encryptMd5 = DigestUtils.md5DigestAsHex(str.getBytes(StandardCharsets.UTF_8));
        log.info("MD5加密=======:\n待加密字符串:{} \n加密后字符串:{}", str, encryptMd5);
        return encryptMd5;
    }

    /**
     * 加密处理
     * @param str 要加密的字符串，需要与盐值整合
     * @return 加密后的数据
     */
    public static String encryptBase64(String str) {
        // 加盐处理
        String temp = str + "{" + ConfigStatus.ENCRYPT_BASE_SALT.getStrValue() + "}";
        byte[] data = temp.getBytes();
        for (int i = 0; i < ConfigStatus.ENCRYPT_BASE_REPEAT.getIntValue(); i++) {
            // 重复加密
            data = Base64.getEncoder().encode(data);
        }
        String encryptBase64 = new String(data);
        log.info("Base64加密=======:\n待加密字符串:{} \n加密后字符串:{}", str, encryptBase64);
        return encryptBase64;
    }

    /**
     * 解密处理
     * @param str 需要解密的内容
     * @return 解密后的原始数据
     */
    public static String decryptBase64(String str) {
        // 获取加密的内容
        byte[] data = str.getBytes();
        for (int i = 0; i < ConfigStatus.ENCRYPT_BASE_REPEAT.getIntValue(); i++) {
            // 多次解密
            data = Base64.getDecoder().decode(data);
        }
        // 删除盐值格式
        String res = new String(data).replaceAll("\\{\\w+\\}", "");
        log.info("Base64解密=======:\n待解密字符串:{} \n解密后字符串:{}", str, res);
        return res;
    }

}
