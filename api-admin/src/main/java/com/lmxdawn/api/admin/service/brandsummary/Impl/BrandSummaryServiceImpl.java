package com.lmxdawn.api.admin.service.brandsummary.Impl;

import com.lmxdawn.api.admin.dao.BrandSummaryDAO;
import com.lmxdawn.api.admin.entity.BrandSummary;
import com.lmxdawn.api.admin.service.brandsummary.BrandSummaryIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandSummaryServiceImpl implements BrandSummaryIService {

    @Autowired
    private BrandSummaryDAO brandSummaryDAO;

    @Override
    public BrandSummary GetById(int id) {

        return this.brandSummaryDAO.GetBrandSummaryById(id);
    }

    @Override
    public boolean UpdateBrandSummary(BrandSummary summary) {
        return this.brandSummaryDAO.UpdateSummary(summary);
    }
}
