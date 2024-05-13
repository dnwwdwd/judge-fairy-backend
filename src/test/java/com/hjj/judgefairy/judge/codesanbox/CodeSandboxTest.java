package com.hjj.judgefairy.judge.codesanbox;

import com.hjj.judgefairy.MainApplication;
import com.hjj.judgefairy.judge.codesandbox.CodeSandbox;
import com.hjj.judgefairy.judge.codesandbox.CodeSandboxFactory;
import com.hjj.judgefairy.judge.codesandbox.CodeSandboxProxy;
import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeRequest;
import com.hjj.judgefairy.judge.codesandbox.model.ExecuteCodeResponse;
import com.hjj.judgefairy.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootTest(classes = MainApplication.class)
public class CodeSandboxTest {

    @Value("${codesandbox.type:remote}")
    String type;

    @Test
    void executeCode() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Integer a = Integer.valueOf(args[0]);\n" +
                "        Integer b = Integer.valueOf(args[1]);\n" +
                "        System.out.println(a + b);\n" +
                "    }\n" +
                "}\n";
        String language = "java";
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);
    }

    @Test
    void executeCodeByProxy() {
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);

        String code = "public class Main {\n" +
                "    public static void main(String[] args) {\n" +
                "        Integer a = Integer.valueOf(args[0]);\n" +
                "        Integer b = Integer.valueOf(args[1]);\n" +
                "        System.out.println(a + b);\n" +
                "    }\n" +
                "}\n";
        String language = QuestionSubmitLanguageEnum.C.getValue();
        List<String> inputList = Arrays.asList("1 2", "3 4");
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        System.out.println(executeCodeResponse);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String type = scanner.next();
            CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
            String code = "int main {}";
            String language = QuestionSubmitLanguageEnum.C.getValue();
            List<String> inputList = Arrays.asList("1 2", "3 4");
            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        }
    }


}
