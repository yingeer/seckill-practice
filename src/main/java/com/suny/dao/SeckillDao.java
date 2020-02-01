package com.suny.dao;

import com.suny.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SeckillDao {

    /**
     *  减少商品库存
     * @param seckillId  秒杀商品的id
     * @param killTime  秒杀的精确时间
     * @return
     */
    public int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /**
     * 通过 seckillId查找seckill对象
     *
     * @param seckillId
     * @return
     */
    public Seckill queryId(long seckillId);

    /**
     * 根据一个偏移量去查找商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     * @param paramMap
     */
    public void killByProcedure(Map<String,Object> paramMap);
}
