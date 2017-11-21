package com.zqboot.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhouquan on 2015/9/15.
 */
public class TimeUtils {

    /**
     * 得到yyyy-MM-dd HH:mm:ss/yyyy-MM-dd格式日期
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getTimeByString(String date)  {
        Date d = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            d = format.parse(date);
        } catch (Exception e) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try {
                d = format.parse(date);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }

        return d;
    }

    /**
     * 得到yyyy-MM-dd格式日期
     *
     * @return
     */
    public static String getYYYY_MM_DD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyy年MM月dd日 17:06格式日期
     *
     * @return
     */
    public static String getYYYY_MM_DD_HH_MM() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyy-MM-dd格式日期
     *
     * @return
     */
    public static String getYYYYMMDD() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyyMMdd减去指定天数格式日期
     *
     * @return
     */
    public static String getYYYYMMDDSubDay(int day) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -day);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String time = format.format(cal.getTime());
        return time;
    }

    /**
     * 得到yyMMddHHmmssSSS日期格式字符串
     *
     * @return
     */
    public static String getyyMMddHHmmssSSS() {
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmssSSS");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyyMMddHHmmssSSS日期格式字符串
     *
     * @return
     */
    public static String getyyyyMMddHHmmssSSS() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyMMddHHmmssSSS日期格式字符串
     *
     * @return
     */
    public static String getyyMMddHHmm() {
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmm");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyMMddHHmmss日期格式字符串
     *
     * @return
     */
    public static String getyyMMddHHmmss() {
        SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyyMMddHHmmss日期格式字符串
     *
     * @return
     */
    public static String getyyyyMMddHHmmss() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = format.format(new Date());
        return time;
    }

    /**
     * 得到yyyy-MM格式日期
     *
     * @return
     */
    public static String getYYYY_MM(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String time = format.format(date);
        return time;
    }

    /**
     * 得到yyyy-MM-dd格式日期
     *
     * @return
     */
    public static String getYYYYMMDD(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        return time;
    }

    /**
     * 根据指定日期得到当月第一天或者最后一天日期
     *
     * @param date
     * @param flag
     * @return
     */
    public static Date getLastOrFirstDate(String date, String flag) {
        Calendar cal = Calendar.getInstance();

        String[] strs = date.split("\\-");
        cal.set(Calendar.YEAR, Integer.parseInt(strs[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(strs[1]));
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        //获取当月最后一天
        Date lastday = cal.getTime();

        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date firstday = cal.getTime();
        if (flag.equals("first")) {
            return firstday;
        } else {
            return lastday;
        }
    }

    /**
     * 获取日期的年或者月或者天
     *
     * @param date
     * @param flag
     * @return
     */
    public static String getYearMonthDay(Date date, String flag) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] time = format.format(date).split("-");
        if ("y".equals(flag)) {
            return time[0];
        } else if ("m".equals(flag)) {
            return time[1];
        } else {
            return time[2];
        }
    }

    /**
     * 获取日期的年或者月或者天
     *
     * @param date
     * @param flag
     * @return
     */
    public static String getYearMonthDay(Timestamp date, String flag) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] time = format.format(date).split("-");
        if ("y".equals(flag)) {
            return time[0];
        } else if ("m".equals(flag)) {
            return time[1];
        } else {
            return time[2];
        }
    }

    /**
     * 比较时间年月大小
     *
     * @return
     */
    public static int compareNowMonth(Timestamp t1) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        int time1 = Integer.parseInt(format.format(new Date(t1.getTime())));
        int time2 = Integer.parseInt(format.format(new Date()));
        if (time1 > time2) {
            return 1;
        } else if (time1 < time2) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 获取MMdd时间格式
     *
     * @return
     */
    public static String getMMdd() {
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        Date d = new Date();
        return format.format(d);
    }

    /**
     * 获取当前日期在年中的天
     *
     * @return
     */
    public static int getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取当前日期在月中的天
     *
     * @return
     */
    public static int getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 比较指定日期和当前日期大小
     *
     * @param date
     * @return
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
    public static boolean compareNow(String date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = format.parse(date);
        Date now = format.parse(getYYYY_MM_DD());
        if (d.getTime() >= now.getTime()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取指定日期减去指定月份后的第一天(月份不超过12）
     *
     * @param date
     * @param nums
     * @return
     */
    public static String dateCalculateMonth(Date date, int nums) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        String[] times = time.split("-");
        int newmon = Integer.parseInt(times[1]) - nums;
        if (newmon > 0) {
            return times[0] + "-" + newmon + "-1";
        } else {
            int newyear = Integer.parseInt(times[0]) - 1;
            newmon = newmon + 12;
            return newyear + "-" + newmon + "-1";
        }
    }

    /**
     * 指定日期加上指定月数
     *
     * @param date
     * @param month
     * @return
     */
    public static Timestamp dateAddMonth(Timestamp date, int month) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);
        String[] times = time.split("-");
        String newTime;
        int newmon = Integer.parseInt(times[1]) + month;
        if (newmon > 12) {
            newTime = (Integer.parseInt(times[0]) + newmon / 12) + "-" + newmon % 12 + "-" + times[2];
        } else {
            newTime = times[0] + "-" + newmon + "-" + times[2];
        }
        return new Timestamp(format.parse(newTime).getTime());
    }

    /**
     * 给定日期增减月数后的日期
     * @param date 日期字符串(如：2016-10-20)
     * @param num 天数(如：1,-1等)
     * @return
     */
    public static String dateAddMonth(String date,int num){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String reDate = "";
        try {
            Date dt = sdf.parse(date);
            Calendar cale = Calendar.getInstance();
            cale.setTime(dt);
            //cale.add(Calendar.YEAR,-1);//日期减1年
            //cale.add(Calendar.MONTH,3);//日期加3个月
            cale.add(Calendar.MONTH,num);//日期加减月
            reDate = sdf.format(cale.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reDate;

    }

    /**
     * 给定日期增减天数后的日期
     * @param date 日期字符串(如：2016-10-20)
     * @param num 天数(如：1,-1等)
     * @return
     */
    public static String dateAdd(String date,int num){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        String reDate = "";

        try {
            Date dt = sdf.parse(date);
            Calendar cale = Calendar.getInstance();
            cale.setTime(dt);
            //cale.add(Calendar.YEAR,-1);//日期减1年
            //cale.add(Calendar.MONTH,3);//日期加3个月
            cale.add(Calendar.DAY_OF_YEAR,num);//日期加减num天
            reDate = sdf.format(cale.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return reDate;

    }

    public static String getTimeStampYMD(Timestamp date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    /**
     * 判断日期的减去指定天数后是否为每个月的最后一天
     *
     * @param d
     * @return
     */
    public static boolean lastDayOfMonth(Date d, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, day);
        int nowDay = c.get(Calendar.DAY_OF_MONTH);
        int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        return nowDay == lastDay;
    }

    /**
     * UTC时间格式转本地时间
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date getUtcTime(String date)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = date.substring(0, 10) + " " + date.substring(11, 23);
        Date dt = null;
        try {
            dt = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dt;
    }

    public static void main(String[] args) throws ParseException {
//        System.out.println(getMMdd());
//        Timestamp s = dateAddMonth(new Timestamp(new Date().getTime()), 20);
//        System.out.println(s.toLocaleString());
//        System.out.println(lastDayOfMonth(new Date(2017, 6, 5), -1));
//        System.out.println(getUtcTime("2017-07-02T16:00:00.000Z"));
//        System.out.println(getUtcTime("2017-07-02T16:00:00.000Z"));
//        System.out.println(getyyMMddHHmm());
//        Timestamp timestamp = new Timestamp()
//        System.out.println(getYYYYMMDDSubDay(1));
//        System.out.println(getYYYY_MM_DD_HH_MM());
        System.out.println(!compareNow("2017-10-14"));
    }

    //Date转TimeStamp
    public static Timestamp getTimeStampByDate(Date date){
        return new Timestamp((date).getTime());
    }


}
