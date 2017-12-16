import com.bbq.beans.Student;
import com.bbq.mapper.StudentMapper;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class TestStudentDao {

   @Autowired
   private SqlSessionTemplate sessionTemplate;


    @Test
    public void testGetStudentByName() throws Exception{
       StudentMapper mapper = sessionTemplate.getMapper(StudentMapper.class);
        List<Student> st = mapper.getStudentByName("重八");
        Assert.assertNotNull(st);
        Assert.assertTrue(st.size() == 2);
    }

    @Test
    public void testDeleteById() throws Exception {
        int row = sessionTemplate.delete("com.bbq.mapper.StudentMapper.deleteStudent", 14934155L);
        Assert.assertEquals(row, 1);
    }
}
