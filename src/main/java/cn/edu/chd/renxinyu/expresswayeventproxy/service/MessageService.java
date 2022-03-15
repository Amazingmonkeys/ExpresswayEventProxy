package cn.edu.chd.renxinyu.expresswayeventproxy.service;

import cn.edu.chd.renxinyu.expresswayeventproxy.model.WorkflowMessage;

public interface MessageService {

    String generateTodoMessage(WorkflowMessage workflowMessage);

    void receiveMessage(WorkflowMessage workflowMessage);
}
