package com.zqboot.utils;

/**
 * Created by zhouquan on 2016/3/8.
 */
public class Constants {

    public static final String ORDER_RANDOM = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static final String RANDOM_UPPER_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String RANDOM_NUMBER = "0123456789";

    public static final String ACCOUNT_HAVE = "用户名已存在";

    public static final String ACCOUNT_NONE = "用户不存在";

    public static final String ACCOUNT_PASSWORD_ERROR = "用户名或密码错误";

    public static final String UPDATE_SUCCESS = "修改成功";

    public static final String COLLECTION_SUCCESS = "收藏成功";

    public static final String COLLECTION_HAVED = "请勿重复收藏";

    public static final String COLLECTION_FAIL = "收藏失败";

    public static final String UPDATE_FAIL = "修改失败";

    public static final String SELECT_SUCCESS = "查询成功";

    public static final String SELECT_FAIL = "查询失败";

    public static final String DELETE_SUCCESS = "删除成功";

    public static final String DELETE_FAIL = "删除失败";

    public static final String ADD_SUCCESS = "添加成功";

    public static final String CODE_ERROR = "验证码错误或失效";

    public static final String GET_CODE_FAIL = "获取验证码失败";

    public static final String ADD_FAIL = "添加失败";

    public static final String IS_SUCCESS = "成功";

    public static final String IS_FAIL = "失败";

    public static final String PAY_FAIL = "支付失败";

    public static final String NO_MONEY = "余额不足";

    public static final String PAY_SUCCESS = "支付成功";

    public static final String ADD_BILL_ERROR = "充值金额必须大于0";

    public static final String NO_OPENID = "用户未授权";

    public static final String OLD_PWD_ERROR = "旧密码错误";

    public static final String FUNCTIONALITY_IS_NOT_SUPPORTED = "该功能暂不支持";

    /**
     * 记录状态：1 有效，0无效
     */
    public enum state {
        useful(0), notuse(1);
        private int value;

        state(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 用户是否在线（1：在线，2：不在线）
     */
    public enum isAvailable {
        onLine(1),notOnLine(2);
        private int value;

        isAvailable(int value) {
            this.value =  value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 是否是明星老师（1：是，2：否）
     */
    public enum isStarTutor {
        yes(1),no(2);
        private int value;

        isStarTutor(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}
