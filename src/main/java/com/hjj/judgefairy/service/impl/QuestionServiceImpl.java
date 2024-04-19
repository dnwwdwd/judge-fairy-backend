package com.hjj.judgefairy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjj.judgefairy.model.entity.Question;
import com.hjj.judgefairy.service.QuestionService;
import com.hjj.judgefairy.mapper.QuestionMapper;
import org.springframework.stereotype.Service;

/**
* @author 何佳骏
* @description 针对表【question(题目表)】的数据库操作Service实现
* @createDate 2024-04-19 19:05:28
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question>
    implements QuestionService{

}




