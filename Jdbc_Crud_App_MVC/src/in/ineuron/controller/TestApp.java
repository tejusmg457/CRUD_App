package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import in.ineuron.ServiceFactory.StudentServiceFactory;
import in.ineuron.dto.Student;
import in.ineuron.service.IStudentService;

//controller logic
public class TestApp {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {

			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("Enter your option :: ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deletOperation();
				break;
			case "5":
				System.out.println("******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("Invalid option plz try agin with valid options....");
				break;
			}
		}
	}
		private static void deletOperation() throws IOException {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the student id to be deleted :: ");
			int sid = scanner.nextInt();
			IStudentService studentService  = StudentServiceFactory.getStudentService();
			String msg = studentService.deleteStudent(sid);
			if(msg.equalsIgnoreCase("success")) {
				System.out.println("record deleted successfully");
			}else if(msg.equalsIgnoreCase("not found")) {
				System.out.println("record not available for given id :: "+ sid );
			}else {
				System.out.println("record deletion failed..");
			}	
		}
		private static void selectOperation() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the student id to see the details :: ");
			int sid = scanner.nextInt();
			IStudentService studentService  = StudentServiceFactory.getStudentService();
			Student std = studentService.searchStudent(sid);
			if(std!=null) {
				System.out.println(std);
				System.out.println("SID\tSNAME\tSAGE\tSADDR");
				System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
			}else {
				System.out.println("Record not found for the given id :: " + sid);
			}
		}
		private static void insertOperation() {
				
			IStudentService studentService  = StudentServiceFactory.getStudentService();
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the student name :: ");
			String sname = scanner.next();
			System.out.print("Enter the student age :: ");
			int sage = scanner.nextInt();
			System.out.print("Enter the student address :: ");
			String saddress = scanner.next();
			String msg = studentService.addStudent(sname, sage, saddress);
			if(msg.equalsIgnoreCase("success")) {
				System.out.println("record insertion successfully");
			}else {
				System.out.println("record insertion failed");
			}
		}
		
		
		private static void updateOperation() throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the student id to be updated :: ");
			String sid = br.readLine();
			IStudentService studentService  = StudentServiceFactory.getStudentService();
			Student student = studentService.searchStudent(Integer.parseInt(sid));
			
			if(student!=null) {
				Student newStudent = new Student();
				System.out.println("Student id is :: "+ student.getSid());
				newStudent.setSid(student.getSid());
				System.out.print("Student oldname is :: " +student.getSname()+" Enter new name :: ");
				String newName = br.readLine();
				if (newName.equals("") || newName == "") {
					newStudent.setSname(student.getSname());
				} else {
					newStudent.setSname(newName);
				}
				System.out.print("Student oldage is :: " +student.getSage()+" Enter new age :: ");
				String newAge = br.readLine();
				if (newAge.equals("") || newAge == "") {
					newStudent.setSage(student.getSage());
				} else {
					newStudent.setSage(Integer.parseInt(newAge));
				}
				System.out.print("Student old address is :: " +student.getSaddress()+" Enter new address :: ");
				String newAdd = br.readLine();
				if (newAdd.equals("") || newAdd == "") {
					newStudent.setSaddress(student.getSaddress());
				} else {
					newStudent.setSaddress(newAdd);
				}
				System.out.println();
				System.out.println("Updated student data is :: "+ newStudent);
				System.out.println();
				String status = studentService.updateStudent(newStudent);
				if(status.equalsIgnoreCase("success")) {
					System.out.println("record updated successfully");
				}else {
					System.out.println("record updation failed..");
				}
				
			}else {
				System.out.println("Student record not available for the given id :: "+sid+" for updation");
			}
		}
}
