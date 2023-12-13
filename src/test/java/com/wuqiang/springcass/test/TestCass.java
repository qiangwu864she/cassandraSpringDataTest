package com.wuqiang.springcass.test;

import com.wuqiang.springcass.pojo.Student;
import com.wuqiang.springcass.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 测试类
 */
public class TestCass {
    private StudentService studentService;
    //初始化
    @Before
    public void init(){
        //读取配置文件，初始化spring，获取上下文
        ConfigurableApplicationContext ctx
                = new ClassPathXmlApplicationContext("springContext.xml");
        //从上下文中获取studentService
        studentService =(StudentService) ctx.getBean("studentService");
    }

    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll(){
        List<Student> studentList = studentService.queryAll();
        for (Student student : studentList) {
            System.out.println(student);
            System.out.println("=======================================================");
        }
    }
    /**
     * 根据主键id查询单条数据
     */
    @Test
    public void testFindById(){
      Student student = studentService.queryOne(1023L);
        System.out.println(student);
    }

    /**
     * 新增（保存）数据
     */
    @Test
    public void testSaveData(){
        HashSet<String> interest = new HashSet<>();
        interest.add("看书23");
        interest.add("看电影23");

        ArrayList<String> phone = new ArrayList<>();
        phone.add("020-6666666623");
        phone.add("1366666666623");

        HashMap<String, String> education = new HashMap<>();
        education.put("小学","城市第23小学");
        education.put("中学","城市第23中学");
        Student student = new Student(1023L,
                "朝阳路23号",
                "吴强",
                23,
                1,
                interest,
                phone,
                education);
        studentService.saveStudent(student);
    }

    /**
     * 根据主键id删除数据
     */
    @Test
    public void testDeleteById(){
        studentService.deleteByid(1023L);
    }
}
