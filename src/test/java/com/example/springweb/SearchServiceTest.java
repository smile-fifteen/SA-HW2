package com.example.springweb;

import com.example.springweb.service.SearchService;
import com.example.springweb.service.StuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {
    SearchService ss = new SearchService();
    @Autowired
    StuService stuService;
    @Test
    public void SearchTest()
    {
        String results = "";
        results = ss.search("110000","",stuService.getUserList());
        assertNotNull(results);
        assertTrue(results.contains("0"));
        results = ss.search("100000", ">=5",stuService.getUserList());
        assertFalse(results.contains("4"));
        assertTrue(results.contains("5"));
    }
}
