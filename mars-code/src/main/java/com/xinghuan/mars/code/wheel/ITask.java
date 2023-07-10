package com.xinghuan.mars.code.wheel;

/**
 * @author shenchen
 * @since 2023/7/10 15:27
 */
public abstract class ITask implements Runnable {

    private Integer offset;

    Integer getOffset() {
        return offset;
    }

    void setOffset(Integer offset) {
        this.offset = offset;
    }
}
