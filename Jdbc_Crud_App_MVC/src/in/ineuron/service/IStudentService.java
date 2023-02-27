package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {
	
	//performing operations
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);

}
