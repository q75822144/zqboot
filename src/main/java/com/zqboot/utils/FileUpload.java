package com.zqboot.utils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by zhouquan on 2015/9/15.
 */
public class FileUpload {
    @SuppressWarnings("deprecation")
    public static String upload(HttpServletRequest request, String topath) {
        String filepath;
        String file_list = null;
        try {
            //获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //获取文件需要上传到的路径
            String path = request.getRealPath("/medias");

            //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
            //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            /**
             * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，
             * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
             * 然后再将其真正写到 对应目录的硬盘上
             */
            //将上传的文件保存到服务器，如果没有对应的文件夹，创建文件夹

            factory.setRepository(new File(path));
            //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024 * 10);
            //高水平的API文件上传处理
            ServletFileUpload upload = new ServletFileUpload(factory);

            //可以上传多个文件
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //获取表单的属性名字
                if (!item.isFormField()) {
                    String name = item.getName();
                    if (!name.trim().equals("")) {
                        String temp_path = path + "/" + topath;
                        File locate = new File(temp_path);
                        if (!locate.exists()) {
                            try {
                                boolean isok = locate.mkdirs();
                                if (!isok) {
                                    throw new Exception("服务器创建文件夹失败！");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        //获取路径名
                        name = RandomCode.getPicture() + name.substring(name.lastIndexOf("."), name.length());
                        filepath = temp_path + "/" + name;
                        OutputStream out = new FileOutputStream(filepath);
                        InputStream in = item.getInputStream();
                        int i = -1;
                        byte[] buf = new byte[1024 * 1024 * 5];
                        while ((i = in.read(buf)) != -1) {
                            out.write(buf, 0, i);
                        }
                        out.flush();
                        in.close();
                        out.close();

                        if (file_list == null) {
                            file_list = getRootPath(request) + "/medias/" + topath + "/" + name;
                        } else {
                            file_list = file_list + "," + getRootPath(request) + "/medias/" + topath + "/" + name;
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return file_list;
    }

    public static String getRootPath(HttpServletRequest request) {
        int port = request.getServerPort();
        String contextPath = request.getContextPath();
        if (port == 80) {
            return "http://" + request.getServerName() + contextPath;
        } else if (port == 443) {
            return "https://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
        } else {
            return "http://" + request.getServerName() + ":" + request.getServerPort() + contextPath;
        }
    }

}
