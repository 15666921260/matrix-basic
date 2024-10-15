package com.matrix.admin.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.matrix.admin.oj.mappers.QuestionMapper;
import com.matrix.common.pojo.oj.Question;
import com.matrix.admin.oj.service.QuestionService;
import org.springframework.stereotype.Service;

/**
* @author liuweizhong
* @description 针对表【question(题目表)】的数据库操作Service实现
* @createDate 2024-10-13 09:29:01
*/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}




