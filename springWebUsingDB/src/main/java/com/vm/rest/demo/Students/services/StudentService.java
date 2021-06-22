package com.vm.rest.demo.Students.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vm.rest.demo.Students.entity.Student;


@Service
public class StudentService {

	List<Student> students;
	
	public List<Student> createStudents()
	{
		students=new ArrayList<Student>();
		students.add(new Student(1,"aaa",11,111));
		students.add(new Student(2,"bbb",22,222));
		students.add(new Student(3,"ccc",33,333));
		students.add(new Student(4,"ddd",44,444));
		students.add(new Student(5,"eee",55,555));
		
		return students;
		
	}
	public  List<Student> getStudents() {
		if(students==null) {
		createStudents();
		}
		return students;
	}
	public Student getStudentById(int id) {
		
	                                                    //returns only first object
		return students.stream().filter(s->s.getId()==id).findFirst().get();
		
	}
	
	public void addStudent(Student student) {
		students.add(student);
		
	}
	public void updateStudent(Student student, int id) {
		// TODO Auto-generated method stub
		for(int i = 0; i< students.size(); i++)
		{
			Student s = students.get(i);
			if(s.getId()== id) 
			{
				students.set(id, student); 	
				return;
			}
		}
		
	}
	public void removeStudent(int id) {
		students.removeIf(s -> s.getId() == id);
	}
	
	

}
