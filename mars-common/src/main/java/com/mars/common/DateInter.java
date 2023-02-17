package com.mars.common;

import java.util.Date;

/**
 * @author shenchen
 * @version 1.0
 * @date 2023/2/15 22:48
 */
public class DateInter extends Pair<Date> {

    @Override
    public Date getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Date value) {
        super.setValue(value);
    }

    public static void main(String[] args) {
        DateInter inter = new DateInter();
        inter.setValue(new Date());
//        inter.setValue(new Object());
    }

}
