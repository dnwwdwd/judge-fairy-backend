package com.hjj.judgefairy.model.vo;

import cn.hutool.json.JSONUtil;
import com.hjj.judgefairy.model.dto.question.JudgeCase;
import com.hjj.judgefairy.model.dto.question.JudgeConfig;
import com.hjj.judgefairy.model.entity.Question;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 返回给管理员和创建改题目的人 VO 类
 */
@Data
public class QuestionAdminVO implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 标签列表（json 数组）
     */
    private List<String> tags;

    /**
     * 提交人数
     */
    private Integer submitNum;

    /**
     * 通过人数
     */
    private Integer accessNum;

    /**
     * 题目配置（json 对象）
     */
    private JudgeConfig judgeConfig;

    /**
     * 题目用例（json 数组）
     */
    private List<JudgeCase> judgeCase;

    /**
     * 点赞数
     */
    private Integer thumbNum;

    /**
     * 收藏数
     */
    private Integer favourNum;

    /**
     * 创建用户 id
     */
    private UserVO userVO;

    private String answer;
    /**
     * 包装类转对象
     *
     * @param questionVO
     * @return
     */
    public static Question voToObj(QuestionVO questionVO) {
        if (questionVO == null) {
            return null;
        }
        Question question = new Question();
        BeanUtils.copyProperties(questionVO, question);
        List<String> tagList = questionVO.getTags();
        if (CollectionUtils.isNotEmpty(tagList)) {
            question.setTags(JSONUtil.toJsonStr(tagList));
        }
        JudgeConfig voJudgeConfig = questionVO.getJudgeConfig();
        if (voJudgeConfig != null) {
            question.setJudgeConfig(JSONUtil.toJsonStr(voJudgeConfig));
        }
        question.setTags(JSONUtil.toJsonStr(tagList));
        return question;
    }

    /**
     * 对象转包装类
     *
     * @param question
     * @return
     */
    public static QuestionVO objToVo(Question question) {
        if (question == null) {
            return null;
        }
        QuestionVO questionVO = new QuestionVO();
        BeanUtils.copyProperties(question, questionVO);
        String tags = question.getTags();
        List<String> tagList = JSONUtil.toList(tags, String.class);
        questionVO.setTags(tagList);
        String judgeConfig = question.getJudgeConfig();
        questionVO.setJudgeConfig(JSONUtil.toBean(judgeConfig, JudgeConfig.class));
        return questionVO;
    }

    private static final long serialVersionUID = 1L;
}
