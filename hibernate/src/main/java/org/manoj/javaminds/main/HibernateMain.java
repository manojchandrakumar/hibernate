package org.manoj.javaminds.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.manoj.javaminds.dao.impl.AuthorDAOImpl;
import org.manoj.javaminds.dao.impl.BooksDAOImpl;
import org.manoj.javaminds.dao.impl.EmployeeDAOImpl;
import org.manoj.javaminds.dao.impl.ShoppingDAOImpl;
import org.manoj.javaminds.dao.impl.UserDAOImpl;
import org.manoj.javaminds.entity.Address;
import org.manoj.javaminds.entity.Author;
import org.manoj.javaminds.entity.Books;
import org.manoj.javaminds.entity.Cart;
import org.manoj.javaminds.entity.ContractEmployee;
import org.manoj.javaminds.entity.Employee;
import org.manoj.javaminds.entity.Items;
import org.manoj.javaminds.entity.RegularEmployee;
import org.manoj.javaminds.entity.UserDetails;

public class HibernateMain {

	public static void main(String[] args) {

		UserDAOImpl userDAO = new UserDAOImpl();
		BooksDAOImpl booksDAO = new BooksDAOImpl();
		AuthorDAOImpl authorDAO = new AuthorDAOImpl();
		EmployeeDAOImpl empDAO = new EmployeeDAOImpl();
		ShoppingDAOImpl shopDAO = new ShoppingDAOImpl();

		/* User Details */
		List<Integer> authorIds = null;
		List<Author> authorsList = null;
		UserDetails userDetails = new UserDetails();
		userDetails.setName("Manoj");
		userDetails.setEmail("manoj.s@gmail.com");
		Address address = new Address();
		address.setDoorNo("1");
		address.setStreet("STRT1");
		address.setCity("CBE");
		address.setState("TN");
		address.setCountry("IN");
		address.setZip(641006);
		userDetails.setAddress(address);

		/* Books */
		Books books = new Books();
		books.setTitle("Hibernate Made Easy");
		books.setDescription("Simplified Data Persistence with Hibernate and JPA");
		books.setPublishedDate(new Date());
		Author author = new Author("Cameron Wallace McKenzie", "Cameron@gmail.com");
		books.setAuthor(author);

		/* Author */
		authorIds = new ArrayList<Integer>();
		authorIds.add(1);
		authorIds.add(2);
		Author author2 = new Author();
		author2.setAuthorName("Salivahanan V");
		author2.setAuthorEmail("Salivahanan.v@gmail.com");

		/* Employee */
		Employee emp = new Employee();
		emp.setEmployeeName("Manoj");

		RegularEmployee regEmp = new RegularEmployee();
		regEmp.setEmployeeName("Sri");
		regEmp.setSalary(15000.00);
		regEmp.setBonus(5000.00);

		ContractEmployee cntrctEmp = new ContractEmployee();
		cntrctEmp.setPayPerHour(100);
		cntrctEmp.setContractPeriod("1 Year");
		try {

			userDAO.addUserDetails(userDetails);

			/* Books */
			booksDAO.addBooks(books);

			/* Authors */
			authorDAO.addAuthor(author2);
			authorsList = authorDAO.getAuthors(authorIds);
			for (Author authorDetail : authorsList) {
				System.out.println(authorDetail.getAuthorId() + " - " + authorDetail.getAuthorName());
			}

			/* Employee */
			empDAO.addEmployee(emp);
			empDAO.addRegularEmployee(regEmp);
			empDAO.addCtrctEmployee(cntrctEmp);

			/* Cart - Items */
			List<Items> itemsList = new ArrayList<>();
			Cart cart1 = new Cart();
			cart1.setName("Cart1");
			Items item1 = new Items();
			item1.setCart(cart1);
			item1.setItemId("I10");
			item1.setItemTotal(200.00);
			item1.setQuantity(1);
			Items item2 = new Items();
			item2.setCart(cart1);
			item2.setItemId("I20");
			item2.setItemTotal(50.00);
			item2.setQuantity(1);
			itemsList.add(item1);
			itemsList.add(item2);
			cart1.setItems(itemsList);
			cart1.setTotal(250.50);
			shopDAO.addItems(itemsList);
			shopDAO.addItemsToCart(cart1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
