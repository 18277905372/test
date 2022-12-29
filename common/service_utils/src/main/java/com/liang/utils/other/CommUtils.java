package com.liang.utils.other;

import org.xf.util.ObjectUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class CommUtils {

    public static <T> List<T> distinctList(List<T> list) {
        if (ObjectUtil.isEmpty(list)) {
            return list;
        }
        for (T t : list) {

        }
        return list;
    }

    /**
     * 根据文件的相对路径，加载配置文件
     * 根据value得到配置文件中的相应键的值
     *
     * @param path
     * @param value
     * @return
     */
    public static String getProperties(String path, String value) {
        InputStream in = null;
        try {
            Properties prop = new Properties();
            in = CommUtils.class.getClassLoader().getResourceAsStream(path);
            if (null == in)
                throw new RuntimeException("没有找到配置文件" + path);
            prop.load(in);
            in.close();
            String str = prop.getProperty(value).trim();
            return str;
        } catch (Exception ex) {
            RuntimeException rex = new RuntimeException(ex.getMessage());
            rex.setStackTrace(ex.getStackTrace());
            System.out.println(ex);
            throw rex;
        } finally {
            if (null != in)
                try {
                    in.close();
                } catch (Exception ex) {
                    RuntimeException rex = new RuntimeException(ex.getMessage());
                    rex.setStackTrace(ex.getStackTrace());
                    System.out.println(ex);
                    throw rex;
                }
        }
    }

    /**
     * 如何获得配置文件中所以的信息
     *
     * @param fileName 相对路径下的文件名
     * @return
     */
    public static Object conversion(String fileName) {
        InputStream in;
        Properties p = new Properties();
        try {
            in = new BufferedInputStream(new FileInputStream(
                    new File(new CommUtils().getClass().getClassLoader().getResource(fileName).getPath())));
            p.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Set<Map.Entry<Object, Object>> entrySet = p.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            entry.getKey();     //获得键
            entry.getValue();   //获得值
        }
        return entrySet;
    }


    /**
     * 获取用户真实的ip地址
     *
     * @param request
     * @return
     */
    public static String getIpAdrress(HttpServletRequest request) {
        String ip = null;

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        String unknown = "unknown";
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取后一天时间
     * @return
     */
    public static Date getAfterDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new Date(calendar.getTimeInMillis());
    }

    /**
     * 获取后一天时间
     * @return
     */
    public static Date getBeforeDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return new Date(calendar.getTimeInMillis());
    }
}
