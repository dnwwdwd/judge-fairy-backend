package com.hjj.judgefairysandbox;

import com.hjj.judgefairysandbox.model.ExecuteCodeRequest;
import com.hjj.judgefairysandbox.model.ExecuteCodeResponse;
import org.springframework.stereotype.Component;

/**
 * java 原生代码沙箱实现（直接复用模板方法）
 */
@Component
public class JavaNativeCodeSandbox extends JavaCodeSandboxTemplate {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}