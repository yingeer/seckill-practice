package com.suny.dao;

import com.suny.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SuccessKilledDao {

    /**
     * @param seckillId
     * @param userPhone
     * @return
     */
    public int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     *
     * @param seckillId
     * @return
     */
    public SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}

