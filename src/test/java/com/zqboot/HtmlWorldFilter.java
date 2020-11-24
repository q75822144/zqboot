package com.zqboot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HtmlWorldFilter {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("D:\\ideaWork\\zqboot\\src\\test\\java\\com\\zqboot\\temp")));//构造一个BufferedReader类来读取文件

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        String res = sb.toString();
        System.out.println(res.replaceAll("<([^>]*)>", "").replaceAll("&ensp;", " "));
    }
}
