package com.lmxdawn.api.admin.service.share;

import com.lmxdawn.api.admin.dao.ShareDAO;
import com.lmxdawn.api.admin.entity.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShareService {

    List<Share> listShare();

    int insert(Share entity);

    boolean delete(int id);


}
