package com.oto.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oto.entities.Product;
import com.oto.entities.Warranty;
import com.oto.util.HibernateUtil;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;

		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		session.beginTransaction();

		Product product = new Product();
		product.setDescription("32 inch LED Television");
		product.setCategory("Electronics");
		product.setPrice(38373f);

		Warranty warranty = new Warranty();
		warranty.setDescription("Two years full coverage, please refer to TC");
		warranty.setWarrantyInMonths(36);
		warranty.setWarrantyTerms("All spare parts");
		warranty.setWarrantyVoidTerms("Physical Damage and Water will not be covered");
		warranty.setProduct(product);

		session.save(warranty);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
