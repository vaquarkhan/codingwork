package com.github.viquar.service;

import com.github.viquar.model.Student;

public interface StudentService {
	Student save(Student student);
	boolean findByLogin(String userName, String password);
	boolean findByUserName(String userName);
}
