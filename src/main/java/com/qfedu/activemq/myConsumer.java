package com.qfedu.activemq;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.vo.R;
import com.qfedu.pojo.Awardrecord;
import com.qfedu.service.AwardrecordService;
import com.qfedu.service.WalletService;
import com.alibaba.fastjson.JSONObject;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Author Amos
 * @Date 2018/9/26 0026 15:42
 */
public class myConsumer implements MessageListener {
    private WalletService wS;
    private AwardrecordService aS;

    public myConsumer () {
    }

    public myConsumer (WalletService wS, AwardrecordService aS) {

        this.wS = wS;
        this.aS = aS;
    }

    @Override
    public void onMessage (Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String json = textMessage.getText();
            System.out.println("json   :   "+json);
            JSONObject object = JSON.parseObject(json);
            Integer code = object.getInteger("code");
            System.out.println("code---"+code);
            Integer scores = object.getInteger("scores");
            System.out.println("scores---"+scores);
            Integer id = object.getInteger("id");
            System.out.println("id---"+id);
            if (code == 1) {
                //todo:activeMQ运行到此无法继续，需检查原因
                wS.updateXXCoin(scores, id);
                System.out.println("签到奖励已到账：" + scores + "个!");
                Awardrecord awardrecord = new Awardrecord();
                awardrecord.setUid(id);
                awardrecord.setMoney(scores);
                boolean b = aS.insert(awardrecord);
                System.out.println("奖励记录已更新：" + b);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
