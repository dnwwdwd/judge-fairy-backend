package com.hjj.judgefairy.judge.codesandbox.impl;

import com.hjj.judgefairy.judge.codesandbox.CodeSandbox;
import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeRequest;
import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 第三方代码沙箱
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("第三方代码沙箱");
        return null;
    }
}
