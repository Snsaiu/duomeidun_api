package com.lmxdawn.api.admin.dao;

import com.lmxdawn.api.admin.entity.Agent;
import com.lmxdawn.api.admin.entity.AgentContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AgentDAO {

    int Add(Agent entity);

    boolean UpdateContent(AgentContent entity);

    String GetContent();
    List<Agent> GetAll();

    boolean Update(Agent entity);

}
