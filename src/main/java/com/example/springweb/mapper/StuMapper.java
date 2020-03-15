package com.example.springweb.mapper;

import com.example.springweb.dao.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author mysql语句
 */
@Mapper
public interface StuMapper {

    @Select("Select * from students")
    @Results(
            {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "sex", column = "sex"),
                    @Result(property = "birth", column = "birth"),
                    @Result(property = "nativePlace", column = "nativePlace"),
                    @Result(property = "department", column = "department")
            })
    List<Student> findAll(); //查找所有学生信息


    @Select("Select * from students where id = #{Id}")
    @Results(
            {
                    @Result(property = "id", column = "id"),
                    @Result(property = "name", column = "name"),
                    @Result(property = "sex", column = "sex"),
                    @Result(property = "birth", column = "birth"),
                    @Result(property = "nativePlace", column = "nativePlace"),
                    @Result(property = "department", column = "department")
            })
    Student SelectById(String Id); //获得某id学生信息

    @Insert("Insert into students values(#{id}, #{name}, #{sex}, #{birth}, #{nativePlace}, #{department})")
    void Insert(Student student); //插入学生信息

    @Delete("Delete from students where id = #{id}")
    void DeleteById(String id); //删除某学生信息

    @Update("Update students " +
            "set " +
            "name = #{name}, sex = #{sex}, birth = #{birth}, nativePlace = #{nativePlace}, department = #{department}" +
            "where id = #{id}")
    void UpdateById(Student student); //修改学生信息


}
