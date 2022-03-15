package cn.edu.chd.renxinyu.expresswayeventproxy.controller;

import cn.edu.chd.renxinyu.expresswayeventproxy.base.Constants;
import cn.edu.chd.renxinyu.expresswayeventproxy.base.Global;
import cn.edu.chd.renxinyu.expresswayeventproxy.base.Result;
import cn.edu.chd.renxinyu.expresswayeventproxy.model.WorkflowMessage;
import cn.edu.chd.renxinyu.expresswayeventproxy.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/todo")
    public Result generateTodoMessage(@RequestBody WorkflowMessage workflowMessage) {
        String workflowMessageStr = messageService.generateTodoMessage(workflowMessage);
        return Result.success("生成成功", new Global().httpPayloadPost(workflowMessageStr,
                Constants.HANDLING_HTTP_ADDRESS + "/message/add-todo-event"));
    }

    @RequestMapping("/receive")
    public void receiveMessage(@RequestBody WorkflowMessage workflowMessage) {
        messageService.receiveMessage(workflowMessage);
    }
}
