package com.xuanchen.glkt.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xuanchen.glkt.model.activity.CouponInfo;
import com.xuanchen.glkt.model.activity.CouponUse;
import com.xuanchen.glkt.vo.activity.CouponUseQueryVo;

public interface CouponInfoService extends IService<CouponInfo> {
    IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);
}
