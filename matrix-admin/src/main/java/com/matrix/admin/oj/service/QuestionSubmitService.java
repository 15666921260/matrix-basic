package com.matrix.admin.oj.service;

import com.matrix.common.pojo.oj.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.matrix.common.vo.oj.QuestionSubmitVo;

/**
* @author liuweizhong
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-10-13 09:39:43
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {


    /**
     * 提交题目
     * @param questionSubmit 题目提交对象
     * @return 提交结果
     */
    String submitQuestion(QuestionSubmitVo questionSubmit);

}
