package com.lmxdawn.api.admin.service.brandsummary;

import com.lmxdawn.api.admin.entity.BrandSummary;

public interface BrandSummaryIService {
    BrandSummary GetById(int id);
     boolean UpdateBrandSummary(BrandSummary summary);
}
