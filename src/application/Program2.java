package application;

import java.text.ParseException;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDAO departmentDao = DAOFactory.createDepartmentDAO();
		
		System.out.println("=== Test 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);

		System.out.println();
		System.out.println("=== Test 2: department findAll ===");
		System.out.println(departmentDao.findAll());
		
		System.out.println();
		System.out.println("=== Test 3: department Insert ===");
		Department newDepartment = new Department(null, "Vacation");
		departmentDao.insert(newDepartment);
		System.out.println("Success! new id: " + newDepartment.getId());
		
		System.out.println();
		System.out.println("=== Test 4: department Update ===");
		dep = departmentDao.findById(8);
		dep.setName("Smart");
		departmentDao.update(dep);
		System.out.println("Sucess!");
		
		System.out.println();
		System.out.println("=== Test 5: department Delete ===");
		System.out.println("Enter with a id to be deleted: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted completed");
		
		sc.close();
	}
}