package com.matrix.admin.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.oj.mappers.QuestionSubmitMapper;
import com.matrix.common.pojo.oj.QuestionSubmit;
import com.matrix.admin.oj.service.QuestionSubmitService;
import com.matrix.common.vo.oj.QuestionSubmitVo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author liuweizhong
* @description 针对表【question_submit(题目提交)】的数据库操作Service实现
* @createDate 2024-10-13 09:39:43
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit> implements QuestionSubmitService {
    @Resource
    private QuestionSubmitMapper questionSubmitMapper;
    @Override
    public String submitQuestion(QuestionSubmitVo questionSubmit) {
        QuestionSubmit submit = new QuestionSubmit();
        return null;
    }
}




