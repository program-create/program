package com.qfedu.activemq;

import com.alibaba.fastjson.JSON;
import com.qfedu.pojo.Awardrecord;
import com.qfedu.service.AwardrecordService;
import com.qfedu.service.WalletService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author Amos
 * @Date 2018/9/26 0026 15:42
 */
public class myConsumer implements MessageListener {
    @Autowired
    private WalletService wS;
    @Autowired
    private AwardrecordService aS;

    @Override
    public void onMessage (Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String json = textMessage.getText();
            JSONObject object = JSON.parseObject(json);
            Integer code = object.getInteger("code");
            System.out.println("activeMQ.code---" + code);

            switch (code) {
                case 1:
                    Integer scores = object.getInteger("scores");
                    Integer uid = object.getInteger("id");
                    wS.updateXXCoin(scores, uid);
                    System.out.println("签到奖励已到账：" + scores + "个!");
                    Awardrecord awardrecord = new Awardrecord();
                    awardrecord.setUid(uid);
                    awardrecord.setMoney(scores);
                    boolean b = aS.insert(awardrecord);
                    System.out.println("奖励记录已更新：" + b);
                    break;
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
