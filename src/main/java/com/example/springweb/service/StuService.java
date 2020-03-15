package com.example.springweb.service;

import com.example.springweb.dao.Student;
import com.example.springweb.mapper.StuMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 业务逻辑层封装sql语句
 */
@Service
public class StuService {
    @Resource
    private StuMapper stuMapper;

    /**
     *获取所有学生列表
     */
    public List<Student> getUserList() {
        List<Student> list = stuMapper.findAll();
        return list;
    }

    /**
     *插入新学生
     */
    public void InsertStu(Map<String, String> params){
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.convertValue(params, Student.class);
        stuMapper.Insert(student);
    }

    /**
     * 获得一个学生信息
     */
    public Student getOne(String id){
        Student result = stuMapper.SelectById(id);
        System.out.println("getOne:"+result);
        if (result==null)
        {
            result=new Student();
            //索引为空的时候，返回null，需要这时候对其getId,getName就会出错。
        }
        System.out.println(result.toString());
        return result;
    }

    /**
     * 更新学生信息
     */
    public void UpdateByID(Map<String, String> params){
        String id = params.get("id");

        Student temp = stuMapper.SelectById(id);
        if(params.get("name")!=null) {
            temp.setName(params.get("name"));
        }
        if(params.get("sex")!=null) {
            temp.setSex(params.get("sex"));
        }
        if(params.get("birth")!=null) {
            temp.setBirth(params.get("birth"));
        }
        if(params.get("nativePlace")!=null) {
            temp.setNativePlace(params.get("nativePlace"));
        }
        if(params.get("department")!=null) {
            temp.setDepartment(params.get("department"));
        }

        stuMapper.UpdateById(temp);
    }

    /**
     *删除学生信息
     */
    public void DeleteByID(String id){
        stuMapper.DeleteById(id);
        System.out.println("AfterDelete:"+stuMapper.SelectById(id));
    }
}
