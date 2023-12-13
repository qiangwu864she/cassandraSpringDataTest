package com.wuqiang.springcass.service;

import com.wuqiang.springcass.pojo.Student;
import com.wuqiang.springcass.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询所有对象
     * @return
     */
    public List<Student> queryAll() {
        return studentRepository.findAll();
    }

    /**
     * 根据主键id查询对象
     * @param id
     * @return
     */
    public Student queryOne(Long id ) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    /**
     * 保存
     * @param student
     */
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    /**
     * 根据id删除数据
     * @param id
     */
    public void deleteByid(Long id) {
        studentRepository.deleteById(id);
    }
}
