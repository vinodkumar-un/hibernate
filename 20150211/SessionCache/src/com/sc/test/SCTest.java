package com.sc.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sc.dao.BookDao;
import com.sc.entities.Book;

public class SCTest {
	public static void main(String[] args) {
		Session session = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;

		configuration = new Configuration()
				.configure("com/sc/common/hibernate.cfg.xml");
		try {
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();

			// saveBook(session, 1, "Let us c",232.34f);
			BookDao bookDao = new BookDao();

			Book book1 = bookDao.getBook(session, Book.class, 1);
			Book book2 = bookDao.getBook(session, Book.class, 2);
			//session.evict(book1);
			session.clear();
			Book book3 = bookDao.getBook(session, Book.class, 1);
			Book book4 = bookDao.getBook(session, Book.class, 2);
			System.out.println("book1 == book3 : ? " + (book1 == book3));

			/*
			 * Book book1 = bookDao.loadBook(session, Book.class, 1);
			 * System.out.println(book1.getTitle()); Book book2 =
			 * bookDao.loadBook(session, Book.class, 1);
			 * System.out.println(book2.getTitle());
			 * System.out.println(book2.getClass().getName());
			 * System.out.println("book1 == book2 : ? " + (book1 == book2));
			 */

			/*
			 * saveBook(session, 2, "Pointers in c", 242.23f); Book book1 =
			 * bookDao.getBook(session, Book.class, 2);
			 * System.out.println(book1.getTitle());
			 */
		} finally {
			if (session != null) {
				session.close();
			}
			if (sessionFactory != null) {
				sessionFactory.close();
			}
		}
	}

	private static void saveBook(Session session, int isbn, String title,
			float amount) {
		BookDao bookDao = null;
		Book book = null;

		book = new Book();
		book.setIsbn(isbn);
		book.setTitle(title);
		book.setAmount(amount);
		try {
			bookDao = new BookDao();
			session.beginTransaction();
			bookDao.saveBook(session, book);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
