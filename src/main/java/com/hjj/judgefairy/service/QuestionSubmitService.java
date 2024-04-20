package com.hjj.judgefairy.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hjj.judgefairy.model.dto.question.QuestionQueryRequest;
import com.hjj.judgefairy.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.hjj.judgefairy.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.hjj.judgefairy.model.entity.Question;
import com.hjj.judgefairy.model.entity.QuestionSubmit;
import com.hjj.judgefairy.model.entity.User;
import com.hjj.judgefairy.model.vo.QuestionSubmitVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 何佳骏
* @description 针对表【question_submit(题目提交表)】的数据库操作Service
* @createDate 2024-04-19 19:06:27
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交信息
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取帖子封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取帖子封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}
