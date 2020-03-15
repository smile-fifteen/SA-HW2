package com.example.springweb.service;

import com.example.springweb.dao.Student;

import java.util.List;

/**
 * @author 提供搜索逻辑
 */
public class SearchService {
    public String search(String condition, String key, List<Student> list)
    {
        if(condition.equals("000000"))
        {
            return "";
        }
        else if(key.equals(""))
        {
            String results = "";
            for(int i = 0; i < list.size();i++)
            {
                results += list.get(i).toString() + " ";
            }
            return results;
        }
        else if(condition.equals("100000"))
        {
            return id_search(key,list);
        }
        else
        {
            return include_search(condition,key,list);
        }
    }

    private String id_search(String key, List<Student> list)
    {
        String results = "";
        if(key.charAt(0) == '=')
        {
            key = key.substring(1);
//            System.out.println(key);
            for(int i = 0; i < list.size(); i++)
            {
                if(list.get(i).getId().equals(key))
                {
                    results += list.get(i).toString()+" ";
                }
            }
        }
        else if(key.length() >=2 && key.substring(0,2).equals(">="))
        {
            key = key.substring(2);
//            System.out.println(key);
            for(int i = 0; i < list.size(); i++)
            {
                if(Integer.parseInt(list.get(i).getId()) >= Integer.parseInt(key))
                {
                    results += list.get(i).toString()+" ";
                }
            }
        }
        else if(key.length() > 2 && key.substring(0,2).equals("<="))
        {
            key = key.substring(2);
//            System.out.println(key);
            for(int i = 0; i < list.size(); i++)
            {
                if(Integer.parseInt(list.get(i).getId()) <= Integer.parseInt(key))
                {
                    results += list.get(i).toString()+" ";
                }
            }
        }
        else if(key.length() > 1 && key.charAt(0) == '>')
        {
            key = key.substring(1);
//            System.out.println(key);
            for(int i = 0; i < list.size(); i++)
            {
                if(Integer.parseInt(list.get(i).getId()) > Integer.parseInt(key))
                {
                    results += list.get(i).toString()+" ";
                }
            }
        }
        else if(key.length() > 1 && key.charAt(0) == '<')
        {
            key = key.substring(1);
//            System.out.println(key);
            for(int i = 0; i < list.size(); i++)
            {
                if(Integer.parseInt(list.get(i).getId()) <= Integer.parseInt(key))
                {
                    results += list.get(i).toString()+" ";
                }
            }
        }
        else
        {
//            System.out.println("in id search");
            return include_search("100000", key, list);
        }
        return results;
    }

    private String include_search(String condition,String key, List<Student> list)
    {
        String results = "";
        for(int i = 0; i < list.size(); i++)
        {
            boolean select = false;
            if(condition.charAt(0) == '1')
            {
                if(list.get(i).getId().contains(key)){
                    select = true;
                }
            }
            if(condition.charAt(1) == '1')
            {
                if(list.get(i).getName().contains(key)){
                    select = true;
                }
            }
            if(condition.charAt(2) == '1')
            {
                if(list.get(i).getSex().contains(key)){
                    select = true;
                }
            }
            if(condition.charAt(3) == '1')
            {
                if(list.get(i).getBirth().contains(key)){
                    select = true;
                }
            }
            if(condition.charAt(4) == '1')
            {
                if(list.get(i).getNativePlace().contains(key)){
                    select = true;
                }
            }
            if(condition.charAt(5) == '1')
            {
                if(list.get(i).getDepartment().contains(key)){
                    select = true;
                }
            }
            if(select)
            {
                results += list.get(i).toString() + " ";
            }
        }
        return results;
    }
}
