package com.lmxdawn.api.admin.service.agent.impl;

import com.lmxdawn.api.admin.dao.AgentDAO;
import com.lmxdawn.api.admin.entity.Agent;
import com.lmxdawn.api.admin.entity.AgentContent;
import com.lmxdawn.api.admin.service.agent.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentDAO agentDAO;

    @Override
    public int Add(Agent entity) {

        return this.agentDAO.Add(entity);

    }

    @Override
    public String GetContent() {
        return  this.agentDAO.GetContent();
    }

    @Override
    public boolean UpdateContent(AgentContent content) {
        return  this.agentDAO.UpdateContent(content);
    }

    @Override
    public List<Agent> AgentList() {
        return this.agentDAO.GetAll();
    }
}
