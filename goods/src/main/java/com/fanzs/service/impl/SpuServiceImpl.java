package com.fanzs.service.impl;

import com.fanzs.entity.Spu;
import com.fanzs.helper.DbHelper;
import com.fanzs.service.SpuService;
import org.apache.commons.collections4.CollectionUtils;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

public class SpuServiceImpl implements SpuService {

//    private static final Logger LOGGER = LoggerFactory.getLogger(SpuServiceImpl.class);

    @Override
    public List<Spu> listSpuBySpuCodeList(List<Long> spuCodeList) {
        if (CollectionUtils.isEmpty(spuCodeList)) {
            return Collections.emptyList();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, spu_code AS spuCode, spu_name AS spuName, valid FROM f_spu WHERE valid = 1 AND spu_code IN ( ");
        for (Long spuCode : spuCodeList) {
            sql.append(spuCode).append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append("); ");

        Connection conn = DbHelper.getConnection();
        return DbHelper.queryEntityList(Spu.class, conn, sql.toString());
    }

    @Override
    public List<Spu> listAllSpu() {
        String sql = "SELECT id, spu_code AS spuCode, spu_name AS spuName, valid FROM f_spu WHERE valid = 1";
        Connection conn = DbHelper.getConnection();
        return DbHelper.queryEntityList(Spu.class, conn, sql);
    }

    @Override
    public Spu getSpuBySpuCode(Long spuCode) {
        return null;
    }

    @Override
    public Long addSpu(Spu spu) {
        return null;
    }

    @Override
    public void updateSpuByPrimaryId(Spu spu) {

    }

    @Override
    public void deleteSpuBySpuCodeList(List<Long> spuCodeList) {

    }
}
