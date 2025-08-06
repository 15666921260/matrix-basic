package com.matrix.common.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuweizhong
 * @since 2025-07-28 11:20
 */
@Slf4j
public class DingTalkRobotMessageUtils {

    /**
     * 发送消息
     * @param secret 校验签
     * @param content 消息内容
     * @param customRoBoyToken 机器人token
     * @param userIds @的人员id 可为空
     * @param textType 类型text
     */
    public static void send(String secret, String content, String customRoBoyToken, List<String> userIds ,String textType) {
        try {
            Long timestamp = System.currentTimeMillis();
            log.info("timestamp====>{}", timestamp);
            String stringToSign = timestamp + "\n" + secret;
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
            log.info("sign====>{}", sign);

            //sign字段和timestamp字段必须拼接到请求URL上，否则会出现 310000 的错误信息
            DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/robot/send?sign=" + sign + "&timestamp=" + timestamp);
            OapiRobotSendRequest req = new OapiRobotSendRequest();
            /**
             * 发送文本消息
             */
            //定义文本内容
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            markdown.setTitle("打扫卫生通知");
            markdown.setText(content);
            //定义 @ 对象
            OapiRobotSendRequest.At at = new OapiRobotSendRequest.At();
            at.setAtUserIds(userIds);
            //设置消息类型
            req.setMsgtype(textType);
            req.setMarkdown(markdown);
            req.setAt(at);
            OapiRobotSendResponse rsp = client.execute(req, customRoBoyToken);
            log.info("rsp.getBody()====>{}", rsp.getBody());
        } catch (ApiException e) {
            log.error("apiException====>{}", e.getMessage());
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            log.error("UnsupportedEncodingException====>{}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取值日人员
     * @param allUsers 全部人员名单
     * @param value 值日人数
     * @return 本次值日的人数
     */
    public static List<String> getDutyPerson(List<String> allUsers, Integer value) {
        return new ArrayList<>();
    }


}
