package com.wuqiang.springcass.repository;

import com.wuqiang.springcass.pojo.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

//CassandraRepository提供简单的CRUD方法
public interface StudentRepository extends CassandraRepository<Student,Long> {
}
