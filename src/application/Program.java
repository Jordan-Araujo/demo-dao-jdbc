package application;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("=== Test 1: seller findById ===");
		Seller seller = sellerDao.findById(6);
		System.out.println(seller);
		
		System.out.println();
		System.out.println("=== Test 2: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("=== Test 3: seller findAll ===");
		list = sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}		
		
		System.out.println();
		System.out.println("=== Test 4: seller Insert ===");
		Seller newSeller = new Seller(null, "john", "john@gmail.com", new Date(), 4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());	
		
		System.out.println();
		System.out.println("=== Test 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("John Wick");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println();
		System.out.println("=== Test 6: seller Delete ===");
		System.out.println("Enter an id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}
}