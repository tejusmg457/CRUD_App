package in.ineuron.ServiceFactory;

import in.ineuron.service.*;
public class StudentServiceFactory {

	private StudentServiceFactory() {

	}
	
	private static IStudentService studentService = null;
	
	public static IStudentService getStudentService() {
		 
		//single-ton pattren code
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
