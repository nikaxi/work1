package com.bbq.mapper;

import com.bbq.beans.Student;
import java.util.List;

public interface StudentMapper {

    List<Student> getStudentByName(String name);


    Student getStudentById(long id);

    int insertStudent(Student st);

    int updateStudent(Student st);

    int batchInsertStudent(List<Student> sts);

    int deleteStudent(long id);

}
