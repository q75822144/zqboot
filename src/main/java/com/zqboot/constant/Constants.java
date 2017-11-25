package com.zqboot.constant;

/**
 * Created by zhouquan on 2016/3/8.
 * 常用常量池
 */
public class Constants {

    public static final String ORDER_RANDOM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static final String RANDOM_UPPER_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String RANDOM_NUMBER = "0123456789";

    public static final String UPDATE_SUCCESS = "修改成功";

    public static final String UPDATE_FAIL = "修改失败";

    public static final String SELECT_SUCCESS = "查询成功";

    public static final String SELECT_FAIL = "查询失败";

    public static final String DELETE_SUCCESS = "删除成功";

    public static final String DELETE_FAIL = "删除失败";

    public static final String ADD_SUCCESS = "添加成功";

    public static final String ADD_FAIL = "添加失败";

    public static final String IS_SUCCESS = "成功";

    public static final String IS_FAIL = "失败";

    /**
     * 记录状态：(0:无效 , 1:有效)
     */
    public enum state {
        useless(0), useful(1);
        private int value;

        state(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


}
