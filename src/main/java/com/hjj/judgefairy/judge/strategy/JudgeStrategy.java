package com.hjj.judgefairy.judge.strategy;

import com.hjj.judgefairy.model.dto.questionsubmit.JudgeInfo;

public interface JudgeStrategy {

    /**
     * 执行判题
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);

}
