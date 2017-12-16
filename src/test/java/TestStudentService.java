import com.bbq.beans.Student;
import com.bbq.services.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestStudentService {

    @Autowired
    private StudentService studentService;

    @Test
    public void testGetStudentByName() throws Exception {
        List<Student> students = studentService.getStudentByName("重八");
        Assert.assertEquals(students.size(), 1);
    }

    @Rollback(false)
    @Transactional
    @Test
    public void testupdateStudent() throws Exception {
        List<Student> students = studentService.getStudentByName("重八");
        students.get(0).setName("王麻子");
        studentService.updateStudent(students.get(0));
    }

    @Transactional
    @Rollback(false)
    @Test
    public void testInsertStudent()throws  Exception {
        Date now = new Date(System.currentTimeMillis()/1000);
        Student st = new Student();
        st.setName("王麻子");
        st.setQQ("131426578");
        st.setIdOnSite("飞哥刚死");
        st.setDailyReportUrl("http://dailywork.com/report/");
        st.setSchool("中原大学第"+"分校");
        st.setEntryDate(now);
        st.setCareerType(2);
        st.setUpdateAt(System.currentTimeMillis());
        st.setUpdateAt(System.currentTimeMillis());
        st.setDesire("燕雀安知鸿鹄之志");
        st.setBrotherName("静尚颜");
        long id = studentService.insertStudent(st);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testDeleteStudentById() throws  Exception {
        boolean ret = studentService.deleteStudentById(14934154);
        Assert.assertTrue(ret);
    }
}
