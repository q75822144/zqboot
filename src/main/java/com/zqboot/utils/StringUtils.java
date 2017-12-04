package com.zqboot.utils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by zhouquan on 2015/9/15.
 */
public class StringUtils {

    public static String firstUpper(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    public static boolean isTrimEmpty(String s) {
        return s==null || "".equals(s.trim());
    }

    public static boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }


    public static String join(String join,String[] strAry){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<strAry.length;i++){
            if(i==(strAry.length-1)){
                sb.append(strAry[i]);
            }else{
                sb.append(strAry[i]).append(join);
            }
        }
        return new String(sb);
    }

    public static String encodeUCS2(String str) throws UnsupportedEncodingException {
        byte[] bs = str.getBytes("utf-8");
        StringBuilder sb = new StringBuilder();
        for(byte b : bs){
            sb.append(Integer.toHexString(b));
//            System.out.println(Integer.toHexString(b));
        }
        return sb.toString();
    }


    /**
     * 一次性判断多个或单个对象为空。
     * @param objects
     * @author zhou-baicheng
     * @return 只要有一个元素为Blank，则返回true
     */
    public static boolean isBlank(Object...objects){
        Boolean result = false ;
        for (Object object : objects) {
            if(null == object || "".equals(object.toString().trim())
                    || "null".equals(object.toString().trim())){
                result = true ;
                break ;
            }
        }
        return result ;
    }

    /**
     * 一次性判断多个或单个对象不为空。
     * @param objects
     * @author zhou-baicheng
     * @return 只要有一个元素不为Blank，则返回true
     */
    public static boolean isNotBlank(Object...objects){
        return !isBlank(objects);
    }

    /**
     * 判断一个字符串在数组中存在几个
     * @param baseStr
     * @param strings
     * @return
     */
    public static int indexOf(String baseStr,String[] strings){

        if(null == baseStr || baseStr.length() == 0 || null == strings)
            return 0;

        int i = 0;
        for (String string : strings) {
            boolean result = baseStr.equals(string);
            i = result ? ++i : i;
        }
        return i ;
    }
    /**
     * 判断一个字符串是否为JSONObject,是返回JSONObject,不是返回null
     * @param args
     * @return
     */
   /* public static net.sf.json.JSONObject isJSONObject(String args) {
        net.sf.json.JSONObject result = null ;
        if(isBlank(args)){
            return result ;
        }
        try {
            return net.sf.json.JSONObject.fromObject(args.trim());
        } catch (Exception e) {
            return result ;
        }
    }*/
    /**
     * 判断一个字符串是否为JSONArray,是返回JSONArray,不是返回null
     * @param
     * @return
     */
    /*public static net.sf.json.JSONArray isJSONArray(Object args) {
        JSONArray result = new JSONArray();
        if(isBlank(args)){
            return null ;
        }
        if(args instanceof  net.sf.json.JSONArray){

            net.sf.json.JSONArray arr = (net.sf.json.JSONArray)args;
            for (Object json : arr) {
                if(json != null && json instanceof net.sf.json.JSONObject){
                    result.add(json);
                    continue;
                }else{
                    result.add(JSONObject.fromObject(json));
                }
            }
            return result;
        }else{
            return null ;
        }

    }*/
    public static String trimToEmpty(Object str){
        return (isBlank(str) ? "" : str.toString().trim());
    }

    /**
     * 合并数据
     * @param v
     * @return
     */
    public static String merge(Object...v){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < v.length; i++) {
            sb.append(v[i]);
        }
        return sb.toString() ;
    }

    /**
     * 判断字符串是否包含汉字
     * @param txt
     * @return
     */
    public static Boolean containsCN(String txt){
        if(isBlank(txt)){
            return false;
        }
        for (int i = 0; i < txt.length(); i++) {

            String bb = txt.substring(i, i + 1);

            boolean cc = Pattern.matches("[\u4E00-\u9FA5]", bb);
            if(cc)
                return cc ;
        }
        return false;
    }
//    /**
//     * 去掉HTML代码
//     * @param news
//     * @return
//     */
//    public static String removeHtml(String news) {
//        String s = news.replaceAll("amp;", "").replaceAll("<","<").replaceAll(">", ">");
//
//        Pattern pattern = Pattern.compile("<(span)?\\sstyle.*?style>|(span)?\\sstyle=.*?>", Pattern.DOTALL);
//        Matcher matcher = pattern.matcher(s);
//        String str = matcher.replaceAll("");
//
//        Pattern pattern2 = Pattern.compile("(<[^>]+>)",Pattern.DOTALL);
//        Matcher matcher2 = pattern2.matcher(str);
//        String strhttp = matcher2.replaceAll(" ");
//
//
//        String regEx = "(((http|https|ftp)(\\s)*((\\:)|：))(\\s)*(//|//)(\\s)*)?"
//                + "([\\sa-zA-Z0-9(\\.|．)(\\s)*\\-]+((\\:)|(:)[\\sa-zA-Z0-9(\\.|．)&%\\$\\-]+)*@(\\s)*)?"
//                + "("
//                + "(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])"
//                + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
//                + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)"
//                + "(\\.|．)(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])"
//                + "|([\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*)*[\\sa-zA-Z0-9\\-]+(\\.|．)(\\s)*[\\sa-zA-Z]*"
//                + ")"
//                + "((\\s)*(\\:)|(：)(\\s)*[0-9]+)?"
//                + "(/(\\s)*[^/][\\sa-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&%\\$\\=~_\\-@]*)*";
//        Pattern p1 = Pattern.compile(regEx,Pattern.DOTALL);
//        Matcher matchhttp = p1.matcher(strhttp);
//        String strnew = matchhttp.replaceAll("").replaceAll("(if[\\s]*\\(|else|elseif[\\s]*\\().*?;", " ");
//
//
//        Pattern patterncomma = Pattern.compile("(&[^;]+;)",Pattern.DOTALL);
//        Matcher matchercomma = patterncomma.matcher(strnew);
//        String strout = matchercomma.replaceAll(" ");
//        String answer = strout.replaceAll("[\\pP‘’“”]", " ")
//                .replaceAll("\r", " ").replaceAll("\n", " ")
//                .replaceAll("\\s", " ").replaceAll("　", "");
//
//
//        return answer;
//    }
    /**
     * 把数组的空数据去掉
     * @param array
     * @return
     */
    public static List<String> array2Empty(String[] array){
        List<String> list = new ArrayList<String>();
        for (String string : array) {
            if(StringUtils.isNotBlank(string)){
                list.add(string);
            }
        }
        return list;
    }
//    /**
//     * 把数组转换成set
//     * @param array
//     * @return
//     */
//    public static Set<?> array2Set(Object[] array) {
//        Set<Object> set = new TreeSet<Object>();
//        for (Object id : array) {
//            if(null != id){
//                set.add(id);
//            }
//        }
//        return set;
//    }
    /**
     * serializable toString
     * @param serializable
     * @return
     */
    public static String toString(Serializable serializable) {
        if(null == serializable){
            return null;
        }
        try {
            return (String)serializable;
        } catch (Exception e) {
            return serializable.toString();
        }
    }

}
