package com.lmxdawn.api.admin.service.share.impl;

import com.lmxdawn.api.admin.dao.ShareDAO;
import com.lmxdawn.api.admin.entity.Share;
import com.lmxdawn.api.admin.service.share.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareDAO shareDAO;

    @Override
    public List<Share> listShare() {
        return this.shareDAO.listShare();
    }

    @Override
    public int insert(Share entity) {
        return this.shareDAO.insert(entity);
    }

    @Override
    public boolean delete(int id) {
        return this.shareDAO.delete(id);
    }
}
