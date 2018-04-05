package com.sc.dao;

import org.hibernate.Session;

import com.sc.entities.Book;

public class BookDao {
	public void saveBook(Session session, Book book) {
		session.save(book);
	}

	public Book getBook(Session session, Class<?> classType, int isbn) {
		return (Book) session.get(classType, isbn);
	}

	public Book loadBook(Session session, Class<?> classType, int isbn) {
		return (Book) session.load(classType, isbn);
	}
}
