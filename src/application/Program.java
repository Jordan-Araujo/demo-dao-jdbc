package application;

import java.text.ParseException;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		Department obj = new Department(1, "books");
		System.out.println(obj);
		
		Seller seller = new Seller(1, "joao", "joao@gmail.com", new Date() , 9000.00, obj);
		System.out.println(seller);
	}
}