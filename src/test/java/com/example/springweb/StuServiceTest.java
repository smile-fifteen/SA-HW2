package com.example.springweb;
import com.example.springweb.dao.Student;
import com.example.springweb.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuServiceTest {
    @Autowired
    StuService stuService;


    public void Insert(String id, String name, String sex, String birth, String nativePlace, String department)
    {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("sex", sex);
        params.put("birth", birth);
        params.put("nativePlace", nativePlace);
        params.put("department", department);

        stuService.InsertStu(params);
    }

    public void Delete(String id)
    {
        stuService.DeleteByID(id);
    }

    @Test
    public void Insert_Delete_test()
    {
        Insert("0","0","0","0","0","0");
        Insert("1","1","1","1","1","1");
        List<Student>  list = stuService.getUserList();
        assertEquals(list.size(),2);
        assertEquals(list.get(0).getId(), "0");
        assertEquals(list.get(1).getId(), "1");
        System.out.println(list.get(0).toString());
        System.out.println(list.get(1).toString());

        Delete("0");
        Delete("1");
        list = stuService.getUserList();
        assertEquals(list.size(),0);

    }

    @Test
    public void Updatetest()
    {
        Map<String, String> params = new HashMap<>();
        Insert("0","0","0","0","0","0");
        params.put("id", "0");
        params.put("name", "1");
        params.put("sex", "1");
        params.put("birth", "1");
        params.put("nativePlace", "1");
        params.put("department", "1");
        stuService.UpdateByID(params);
        List<Student> list = stuService.getUserList();
        assertNotNull(list);
        System.out.println(list.get(0).toString());
        assertEquals(list.get(0).getDepartment(), "1");
        stuService.DeleteByID("0");
    }

}
