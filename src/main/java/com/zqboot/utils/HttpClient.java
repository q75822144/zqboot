package com.zqboot.utils;


import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Map;

/**
 * Created by zhouquan on 2016/3/29.
 */
public class HttpClient {


    public static String sendGet(String url, Map<String, String> param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString;
            if (param == null) {
                urlNameString = url;
            } else {
                urlNameString = url + "?";
                for (String key : param.keySet()) {
                    urlNameString += key + "=" + param.get(key) + "&";
                }
                urlNameString = urlNameString.substring(0, urlNameString.length() - 1);
            }

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user1-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String, String> param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user1-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            String urlNameString = "";

            for (String key : param.keySet()) {
                urlNameString += key + "=" + param.get(key) + "&";
            }
            urlNameString = urlNameString.substring(0, urlNameString.length() - 1);
            out.print(urlNameString);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static String sendXmlPost(String urlStr, String request) {
        String result = "";
        try {
            URL realUrl = new URL(urlStr);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("Pragma:", "no-cache");
            conn.setRequestProperty("Cache-Control", "no-cache");
            conn.setRequestProperty("Content-Type", "text/xml");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            // 获取URLConnection对象对应的输出流
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
            out.write(request);
            // flush输出流的缓冲
            out.flush();
            out.close();
            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getLocalImg(String urlStr, Map<String, String> param, String topath) {
        InputStream in = null;
        FileOutputStream outputStream = null;
        String newname = null;
        try {
            String urlNameString;
            if (param == null) {
                urlNameString = urlStr;
            } else {
                urlNameString = urlStr + "?";
                for (String key : param.keySet()) {
                    urlNameString += key + "=" + param.get(key) + "&";
                }
                urlNameString = urlNameString.substring(0, urlNameString.length() - 1);
            }

            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user1-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
//            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
//            for (String key : map.keySet()) {
//                System.out.println(key + "--->" + map.get(key));
//            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = connection.getInputStream();
            newname = topath + new Date().getTime() + ".jpg";
            File f = new File(topath);
            if(!f.exists()){
                f.mkdirs();
            }
            outputStream = new FileOutputStream(new File(newname));
            int len = 0;
            byte[] buffer = new byte[1024 * 1024];
            //使用一个输入流从buffer里把数据读取出来
            while ((len = in.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outputStream.write(buffer, 0, len);
            }

        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return newname;
    }


//    public static void main(String[] args) {
//        Map<String, String> params = new HashMap<String, String>();
//        params.put("access_token","qkcDH214femJ_48SCS-a-r3hchL6hfGDkE1fnHup3dHzHwl-uVBr2INCNazn9h0GeiqaEDJ-J2xkrQVd_cCo6CK18-eaIfXKdsgVvFfAVKzULtuvW_vc6YmF5MI-3mK3HXLjAJARHV");
//        params.put("type", "jsapi");
////        params.put("grant_type", "client_credential");
////        params.put("appid", Config.instance().getAppid());
////        params.put("secret", Config.instance().getAppSecret());
////        String resxml = sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
//        String resxml = sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
//        System.out.println(resxml);
//
//
////        String s = sendXmlPost("http://localhost:8080/NB_Ocean/weixinjscallbakc", "<xml><return_code><![CDATA[鸟毛]]></return_code><return_msg><![CDATA[pay error]]></return_msg></xml>");
////        System.out.println(s);
//    }
}
