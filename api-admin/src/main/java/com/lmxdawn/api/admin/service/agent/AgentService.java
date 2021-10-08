package com.lmxdawn.api.admin.service.agent;


import com.lmxdawn.api.admin.entity.Agent;
import com.lmxdawn.api.admin.entity.AgentContent;

import java.util.List;

public interface AgentService {

    public int Add(Agent entity);


    /**
     * 获得加盟内容
     * @return
     */
    String GetContent();

    boolean UpdateContent(AgentContent content);

    List<Agent> AgentList();


    boolean Update(Agent entity);
}
