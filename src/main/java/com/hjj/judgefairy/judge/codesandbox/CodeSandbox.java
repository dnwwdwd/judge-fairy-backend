package com.hjj.judgefairy.judge.codesandbox;

import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeRequest;
import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
