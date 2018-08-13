package com.xxm.dao;

import com.xxm.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * dao作为数据交互层，和数据库进行交互，现在先用假数据模拟一下
 */

@Repository
public class StudentDao {
    public List<Student> getList(){
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("mmm1",18,"formale"));
        list.add(new Student("mmm2",18,"formale"));
        list.add(new Student("mmm3",18,"formale"));
        return list;
    }
}
