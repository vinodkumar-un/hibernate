package com.mtmwx.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mtmwx.entities.Customer;
import com.mtmwx.entities.CustomerStock;
import com.mtmwx.entities.CustomerStockId;
import com.mtmwx.entities.Stock;

public class MTMWXTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		/*Stock stock = new Stock();
		stock.setStockNm("CIPLA");
		stock.setHoldingCompany("CIPLA LTD");
		stock.setPrice(353.4f);
		session.save(stock);

		Customer customer = new Customer();
		customer.setFirstNm("John");
		customer.setLastNm("K");
		customer.setGender("M");
		customer.setAge(24);
		session.save(customer);

		CustomerStock customerStock = new CustomerStock();
		CustomerStockId id = new CustomerStockId();
		id.setpCustomer(customer);
		id.setpStock(stock);
		customerStock.setId(id);
		customerStock.setQuantity(242);
		customerStock.setPurchaseDate(new Date());
		session.save(customerStock);*/
		
		Customer c = (Customer) session.get(Customer.class, 1);
		CustomerStock cs = c.getStocks().iterator().next();
		System.out.println(cs.getId().getpStock().getStockNm());
		session.getTransaction().commit();
		sfactory.close();
	}
}
