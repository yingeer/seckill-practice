package com.suny.entity;

import java.io.Serializable;
import java.util.Date;

public class SuccessKilled implements Serializable {
    private long seckillId;
    private long userPhone;
    private int state;
    private Date createTime;

    private Seckill seckill;

    @Override
    public String toString() {
        return "SuccessKilled {" +
                "seckill_id" + seckillId +
                "user_phone" + userPhone +
                "state= " + state +
                "create_time" + createTime +
                "}";
    }
    public Seckill getSeckill() {
        return this.seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
