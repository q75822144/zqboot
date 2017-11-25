package com.zqboot.utils.alipay.configandutil;

/**
 * Created by zhouquan on 2017/11/25.
 * 提现需要参数实体类
 */
public class WithdrawSubmit {

    //订单号
    private String out_biz_no;

    //提现帐号
    private String payee_account;

    //提现金额（1元起提现）
    private double amount;

    //提现类型
    private String payee_type = "ALIPAY_LOGONID";

    //付款方名字
    private String payer_show_name;

    //收款人
    private String payee_real_name;

    //备注
    private String remark;

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }

    public String getPayee_account() {
        return payee_account;
    }

    public void setPayee_account(String payee_account) {
        this.payee_account = payee_account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayer_show_name() {
        return payer_show_name;
    }

    public void setPayer_show_name(String payer_show_name) {
        this.payer_show_name = payer_show_name;
    }

    public String getPayee_real_name() {
        return payee_real_name;
    }

    public void setPayee_real_name(String payee_real_name) {
        this.payee_real_name = payee_real_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayee_type() {
        return payee_type;
    }

    public void setPayee_type(String payee_type) {
        this.payee_type = payee_type;
    }

    @Override
    public String toString() {
        return "{" +
                "\"out_biz_no\":\"" + out_biz_no + "\"," +
                "\"payee_type\":\"" + payee_type + "\"," +
                "\"payee_account\":\"" + payee_account + "\"," +
                "\"amount\":\"" + amount + "\"," +
                "\"payer_show_name\":\"" + payer_show_name + "\"," +
                "\"payee_real_name\":\"" + payee_real_name + "\"," +
                "\"remark\":\"" + remark + "\"" +
                "}";
    }
}
