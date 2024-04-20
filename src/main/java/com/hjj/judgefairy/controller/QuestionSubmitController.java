package com.hjj.judgefairy.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hjj.judgefairy.common.BaseResponse;
import com.hjj.judgefairy.common.ErrorCode;
import com.hjj.judgefairy.common.ResultUtils;
import com.hjj.judgefairy.exception.BusinessException;
import com.hjj.judgefairy.exception.ThrowUtils;
import com.hjj.judgefairy.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.hjj.judgefairy.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.hjj.judgefairy.model.dto.user.UserQueryRequest;
import com.hjj.judgefairy.model.entity.QuestionSubmit;
import com.hjj.judgefairy.model.entity.User;
import com.hjj.judgefairy.model.vo.QuestionSubmitVO;
import com.hjj.judgefairy.model.vo.QuestionVO;
import com.hjj.judgefairy.model.vo.UserVO;
import com.hjj.judgefairy.service.QuestionSubmitService;
import com.hjj.judgefairy.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 题目提交接口
 *
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;

    /**
     * 提交题目
     * @param questionSubmitAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
            HttpServletRequest request) {
        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "题目不存在");
        }
        // 登录才能提交
        final User loginUser = userService.getLoginUser(request);
        long result = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
        return ResultUtils.success(result);
    }

    /**
     * 分页获取题目提交列表（除管理员外，普通用户只能看到非答案、提交代码等公开信息）
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitVOByPage(
            @RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
            HttpServletRequest request) {
        if (questionSubmitQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long current = questionSubmitQueryRequest.getCurrent();
        long size = questionSubmitQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        // 获取登录用户
        User loginUser = userService.getLoginUser(request);
        // 从数据库中查询原始的题目提交分页信息
        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
    }
}
