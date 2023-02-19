package application;

import java.text.ParseException;
import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
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
	}
}