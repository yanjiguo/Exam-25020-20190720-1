package com.yjg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  @author jiguo.yan@hand-china.com
 *  @date 2019/7/20
 *  @Description: 读取数据库配置文件
 */
public class Evn extends Properties {

   //定义一个常量
    private static final long serialVersionUID = 1L;
    private static Evn evn = null;

    /**
     * 构造方法私有化
     */
    private Evn() {
        readProperties();
    }

    /**
     * 提供公共方法获取对象
     * @return evn
     */

    public synchronized static Evn newInstance() {
        if (evn == null) {
            evn = new Evn();
        }
        return evn;
    }

    /**
     * 读取db.properties文件
     */
    private void readProperties() {
        InputStream io = this.getClass().getResourceAsStream("/db.properties");
        try {
            load(io);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
