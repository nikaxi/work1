package com.bbq.services;


import com.bbq.beans.Student;
import com.bbq.mapper.StudentMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class StudentService {
    public static Logger logger = LogManager.getLogger(StudentService.class);

    @Autowired
    private StudentMapper mapper;

    public List<Student> getStudentByName(String name) throws Exception{
        List<Student> sts = mapper.getStudentByName(name);
        return sts;
    }
    public void getStudentById(int id) throws Exception{
        Student sts = mapper.getStudentById(id);
        logger.info(sts.getName());
    }

    // 利用sessiongTemplate 直接调用, 因为字符串无语法检查容易出错
    public long insertStudent(final Student student) throws Exception{
        mapper.insertStudent(student);
        return student.getId();
    }

    public boolean updateStudent(final Student student) throws  Exception{
        return 1 == mapper.updateStudent(student);
    }

    public boolean batchInsert(final List<Student> students) throws Exception{
        return students.size() == mapper.batchInsertStudent(students);
    }
    public  boolean deleteStudentById(final int id) throws Exception{
        return 1 == mapper.deleteStudent(id);
    }
}
