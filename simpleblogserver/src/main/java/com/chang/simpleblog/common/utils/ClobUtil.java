package com.chang.simpleblog.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;

/**
 * @Author: chang.tong
 * @Date: 2019/8/13 15:59
 * @Version 1.0
 */
public class ClobUtil {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ClobUtil.class);

    public ClobUtil() {
    }

    public static String clobToString(Clob clob) {
        return clobToString(clob, "");
    }

    public static String clobToString(Clob clob, String sprtStr) {
        StringBuffer content = new StringBuffer();
        if (clob != null) {
            Reader in = null;

            try {
                char[] buff = new char[1024];
                in = clob.getCharacterStream();

                int p;
                while((p = in.read(buff, 0, 1024)) != -1) {
                    content.append(new String(buff, 0, p));
                }
            } catch (Exception e) {
                LOGGER.error("read clob failed.", e);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException var13) {
                        var13.printStackTrace();
                    }
                }

            }
        }

        return content.length() > 0 ? content.toString() : sprtStr;
    }
}
