package com.hjj.judgefairysandbox;

import com.hjj.judgefairysandbox.model.ExecuteCodeRequest;
import com.hjj.judgefairysandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) throws InterruptedException;
}
