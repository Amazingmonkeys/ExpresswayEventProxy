package cn.edu.chd.renxinyu.expresswayeventproxy.service.impl;

import cn.edu.chd.renxinyu.expresswayeventproxy.base.Constants;
import cn.edu.chd.renxinyu.expresswayeventproxy.base.Global;
import cn.edu.chd.renxinyu.expresswayeventproxy.model.WorkflowMessage;
import cn.edu.chd.renxinyu.expresswayeventproxy.service.MessageService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public String generateTodoMessage(WorkflowMessage workflowMessage) {
        String workflowMessageStr = new Gson().toJson(workflowMessage);
        System.out.println(workflowMessageStr);
        workflowMessageStr = workflowMessageStr.substring(0, workflowMessageStr.length() - 1)
                + ",\"todoEvent\":{\"name\":\"test1111\",\"eventTime\":\"2022-03-03 18:35:33\",\"eventLocation\":\"" +
                "K100+1001\",\"eventGrade\":1,\"eventType\":1,\"eventReason\":1,\"eventSource\":1,\"reportSource\":1}}";
        return workflowMessageStr;
    }

    @Override
    public void receiveMessage(WorkflowMessage workflowMessage) {
        System.out.println("Received message: " + new Gson().toJson(workflowMessage));
        String receiptMessage = "{\"msgNode\":{\"topic\":\"流程定义号\",\"tag\": \"模块定义号\"},\"receipt\":{\"wItem\":" +
                "\"工作项号\",\"module_Name\": \"模块名称\",\"transaction_Ok\": \"1\"}}";
        Global.httpPayloadPost(receiptMessage, Constants.HANDLING_HTTP_ADDRESS + "/message/receipt");
    }
}
