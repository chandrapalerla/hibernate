package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.beans.Book;
import com.hibernate.config.SessionFactoryConfig;

public class BookTest {

	public static void main(String[] args) {
		Session seesion = SessionFactoryConfig.getSeesion();
		Transaction tx = seesion.beginTransaction();

		Book book = new Book();
		book.setIsbn(103);
		book.setBookName("spring");
		book.setAuthorName("chandu");
		book.setCategory("Computers");
		book.setPrice(500.00);

		seesion.save(book);
		seesion.flush();

		tx.commit();
		seesion.close();

	}

}
