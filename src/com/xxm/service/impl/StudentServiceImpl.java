package com.xxm.service.impl;

import com.xxm.dao.StudentDao;
import com.xxm.pojo.Student;
import com.xxm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentDao studentDao;

    @Override
    public List<Student> getStudentList() {
        return studentDao.getList();
    }
}
