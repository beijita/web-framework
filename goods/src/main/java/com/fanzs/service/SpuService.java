package com.fanzs.service;

import com.fanzs.entity.Spu;

import java.util.List;

public interface SpuService {

    /**
     * 根据商品编码集合查询商品信息
     *
     * @param spuCodeList
     * @return
     */
    List<Spu> listSpuBySpuCodeList(List<Long> spuCodeList);


    List<Spu> listAllSpu();

    /**
     * 根据商品编码查询商品信息
     *
     * @param spuCode
     * @return
     */
    Spu getSpuBySpuCode(Long spuCode);

    /**
     * 新增
     *
     * @param spu
     * @return
     */
    Long addSpu(Spu spu);

    /**
     * 根据主键ID更新
     *
     * @param spu
     */
    void updateSpuByPrimaryId(Spu spu);

    /**
     * 根据spu编码集合删除spu
     *
     * @param spuCodeList
     */
    void deleteSpuBySpuCodeList(List<Long> spuCodeList);
}
