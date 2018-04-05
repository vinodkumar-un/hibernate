package com.spu.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spu.entities.Book;

public class SPUTest {
	public static void main(String[] args) {
		Session session = null;
		Configuration configuration = new Configuration()
				.configure("com/spu/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		try {
			session = sfactory.getCurrentSession();
			// newBook(session);
			// delete(session, 2);
			// fetchAndDelete(session, 3);
			mergeBook(session, 1);
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			sfactory.close();
		}

	}

	private static void saveOrUpdate(Session session) {
		session.beginTransaction();
		Book book = new Book();
		book.setIsbn(3);
		book.setTitle("Let us c++");
		book.setAuthorName("Yaswanth");
		book.setPrice(110.34f);
		session.saveOrUpdate(book);
		System.out.println("book isbn : " + book.getIsbn());
		session.getTransaction().commit();
	}

	private static void updateBook(Session session) {
		Book book = null;

		session.beginTransaction();
		book = (Book) session.get(Book.class, 1);
		book.setPrice(300);
		session.update(book);
		session.getTransaction().commit();
	}

	public static void newBookUpdate(Session session) {
		Book book = null;

		session.beginTransaction();
		book = new Book();
		book.setIsbn(1);
		book.setTitle("Let us c");
		book.setAuthorName("Yaswanth Kanethkar");
		book.setPrice(250);

		session.update(book);
		session.getTransaction().commit();
	}

	public static void newBook(Session session) {
		Book book = null;

		session.beginTransaction();
		book = new Book();
		book.setTitle("Let us c");
		book.setPrice(242.23f);
		session.save(book);
		session.getTransaction().commit();
	}

	public static void delete(Session session, int isbn) {
		Book book = null;

		session.beginTransaction();
		book = new Book();
		book.setIsbn(isbn);
		session.delete(book);
		session.getTransaction().commit();
	}

	public static void fetchAndDelete(Session session, int isbn) {
		Book book = null;

		session.beginTransaction();
		book = (Book) session.get(Book.class, isbn);
		session.delete(book);
		session.getTransaction().commit();
	}

	public static void mergeBook(Session session, int isbn) {
		Book book = null;
		Book newBook = null;

		session.beginTransaction();
		book = (Book) session.get(Book.class, isbn);
		book.setTitle("Let us c++");
		session.update(book);
		System.out.println("hash code : " + book.hashCode());

		newBook = new Book();
		newBook.setIsbn(isbn);
		newBook.setPrice(200);
		newBook.setTitle("Let us c");
		newBook.setAuthorName("Yaswanth");

		newBook = (Book) session.merge(newBook);
		System.out.println("new hash code : " + newBook.hashCode());
		session.getTransaction().commit();
	}

}
