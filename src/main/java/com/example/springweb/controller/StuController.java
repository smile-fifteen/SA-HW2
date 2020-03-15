package com.example.springweb.controller;

import com.example.springweb.dao.Student;
import com.example.springweb.service.SearchService;
import com.example.springweb.service.StuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 控制器
 */
@Controller
public class StuController {
    @Autowired
    StuService stuService;

    @RequestMapping("/")
    public String hello(Model model) {
        return "index";
    }

    @GetMapping(value = "/generateId")
    @ResponseBody
    public String GenerateID()
    {
        List<Student> list = stuService.getUserList();
        int i;
        for(i = 0; i < list.size(); i++)
        {
            if(i != Integer.parseInt(list.get(i).getId())) {
                break;
            }
        }
        String id = ""+i;
        Map<String, String> params = new HashMap<>();
        params.put("id",id);
        params.put("name","");
        params.put("sex","");
        params.put("birth","");
        params.put("nativePlace","");
        params.put("department","");
        stuService.InsertStu(params);
        return id;
    }

    @GetMapping(value = "/delete", params = {"id"})
    @ResponseBody
    public String Delete(@RequestParam(value = "id")String id)
    {
        System.out.println(id);
        stuService.DeleteByID(id);
        return "";
    }

    @GetMapping(value = "/update", params = {"id","name", "sex", "birth", "nativePlace", "department"})
    @ResponseBody
    public String Update(
                        @RequestParam(value = "id")String id,
                        @RequestParam(value = "name")String name,
                        @RequestParam(value = "sex")String sex,
                        @RequestParam(value = "birth")String birth,
                        @RequestParam(value = "nativePlace")String nativePlace,
                        @RequestParam(value = "department")String department
                         )
    {
        Map<String, String> params = new HashMap<>();
        params.put("id",id);
        params.put("name",name);
        params.put("sex",sex);
        params.put("birth",birth);
        params.put("nativePlace",nativePlace);
        params.put("department",department);
        stuService.UpdateByID(params);
        return "";
    }

    @GetMapping(value = "/search",params={"condition", "key"})
    @ResponseBody
    public String Search(
                        @RequestParam(value = "condition")String condition,
                        @RequestParam(value = "key")String key
                        )
    {
        SearchService ss = new SearchService();
//        System.out.println("c:"+ condition + " k:" + key);
        return ss.search(condition, key, stuService.getUserList());

    }
}
