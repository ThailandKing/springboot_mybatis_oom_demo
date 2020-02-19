package com.it.shw.oom.handler;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @Copyright: Harbin Institute of Technology.All rights reserved.
 * @Description: 结果集分批次处理器
 * @author: thailandking
 * @since: 2020/2/19 15:41
 * @history: 1.2020/2/19 created by thailandking
 */
public class UserResultHandler<T> implements ResultHandler<T> {
    // 每批处理的大小
    private final int batchSize;
    // 每批当前待处理数据个数
    private int count;
    // 存储每批数据的临时容器
    private List<T> results;
    // 处理器
    private final CallbackProcess callbackProcess;

    // 构造函数
    public UserResultHandler(CallbackProcess callbackProcess, int batchSize) {
        super();
        this.callbackProcess = callbackProcess;
        this.batchSize = batchSize;
        count = 0;
        results = new ArrayList<>();
    }

    @Override
    public void handleResult(ResultContext resultContext) {
        T resultObject = (T) resultContext.getResultObject();
        results.add(resultObject);
        count++;
        if (count == batchSize) {
            callbackProcess.processData(results);
            // 重置临时数据容器
            clear();
        }
    }

    // 用来完成最后一批数据处理
    public void end() {
        if (count > 0) {
            callbackProcess.processData(results);
            // 重置临时数据容器
            clear();
        }
    }

    // 重置临时数据容器
    public void clear() {
        count = 0;
        results.clear();
    }
}
