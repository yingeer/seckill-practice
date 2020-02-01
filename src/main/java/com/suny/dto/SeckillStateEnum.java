package com.suny.dto;

public enum SeckillStateEnum {
    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEAT_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATE_REWRITE(-3, "数据被篡改");

    private int state;
    private String info;

    SeckillStateEnum() {
    }

    SeckillStateEnum(int state, String info) {
        this.info = info;
        this.state = state;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public static SeckillStateEnum stateOf(int index) {
        for (SeckillStateEnum seckillStateEnum: values()) {
            if (index == seckillStateEnum.getState()) {
                return seckillStateEnum;
            }
        }
        return null;
    }

}
