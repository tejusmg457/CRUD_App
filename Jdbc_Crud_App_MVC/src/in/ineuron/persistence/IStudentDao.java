package in.ineuron.persistence;

import in.ineuron.dto.Student;

public interface IStudentDao {

	//what are the operation need to be perform those are implement here
	
	public String addStudent(String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Student student);
	
	public String deleteStudent(Integer sid);
}
