package cn.edu.chd.renxinyu.expresswayeventproxy.model;

import lombok.Data;

import java.util.Map;

@Data
public class WorkflowMessage {

    private Map<String, Object> msgNode;
    private Map<String, Object> paras;
}
