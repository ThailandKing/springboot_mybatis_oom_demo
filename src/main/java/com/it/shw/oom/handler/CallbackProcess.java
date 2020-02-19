package com.it.shw.oom.handler;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Copyright: Harbin Institute of Technology.All rights reserved.
 * @Description: 回调处理过程
 * @author: thailandking
 * @since: 2020/2/19 16:03
 * @history: 1.2020/2/19 created by thailandking
 */
public class CallbackProcess {

    // 输出流-浏览器
    private final HttpServletResponse response;

    // 构造函数
    public CallbackProcess(HttpServletResponse response) {
        this.response = response;
    }

    // 处理数据
    public <E> void processData(List<E> records) {
        try {
            for (E record : records) {
                // 需要重写toString,属性通过","分割
                response.getWriter().write(record.toString());
                response.getWriter().write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
