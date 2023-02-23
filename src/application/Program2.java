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
		
		
		/*
		System.out.println();
		System.out.println("=== Test 4: department Insert ===");
		
		
		
		System.out.println();
		System.out.println("=== Test 5: department Update ===");
		
		
		System.out.println();
		System.out.println("=== Test 6: department Delete ===");
		*/
		sc.close();
	}
}