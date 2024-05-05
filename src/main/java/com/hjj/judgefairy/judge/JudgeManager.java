package com.hjj.judgefairy.judge;

import com.hjj.judgefairy.judge.strategy.DefaultJudgeStrategy;
import com.hjj.judgefairy.judge.strategy.JavaLanguageJudgeStrategy;
import com.hjj.judgefairy.judge.strategy.JudgeContext;
import com.hjj.judgefairy.judge.strategy.JudgeStrategy;
import com.hjj.judgefairy.model.dto.questionsubmit.JudgeInfo;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    JudgeInfo doJudge(JudgeContext judgeContext) {
        String language = judgeContext.getQuestionSubmit().getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
