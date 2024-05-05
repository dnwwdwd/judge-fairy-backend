package com.hjj.judgefairy.judge;

import com.hjj.judgefairy.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题服务
 */
@Service
public interface JudgeService {
    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}
