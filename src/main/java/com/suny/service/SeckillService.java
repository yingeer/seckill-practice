package com.suny.service;

import com.suny.dto.Exposer;
import com.suny.dto.SeckillExecution;
import com.suny.entity.Seckill;

import java.util.List;

public interface SeckillService {

    /**
     *
     * @return
     */
    public List<Seckill> getSeckillList();

    /**
     * @param seckillId
     * @return
     */
    public Seckill getById(long seckillId);

    /**
     * 在秒杀开启时输出秒杀接口的地址,否则输出系统时间跟秒杀时间
     *
     * @param seckillId
     *
     * @return
     */
    public Exposer exportSeckillUrl(long seckillId);

    /**
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5);

    /**
     * 使用存储过程执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     */
    public SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);

}
