package com.hibernate.mappings.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.hibernate.config.HibernateUtil;

public class ManyToManyJoinTable {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add subscription
		SubscriptionEntity subOne = new SubscriptionEntity();
		subOne.setSubscriptionName("Entertainment");

		SubscriptionEntity subTwo = new SubscriptionEntity();
		subTwo.setSubscriptionName("Horror");
		
		SubscriptionEntity subTree = new SubscriptionEntity();
		subTree.setSubscriptionName("java");
		
		SubscriptionEntity subTree2 = new SubscriptionEntity();
		subTree2.setSubscriptionName("collection");
		
		SubscriptionEntity subTree3 = new SubscriptionEntity();
		subTree3.setSubscriptionName("Hibernate");
		
		SubscriptionEntity subTree4 = new SubscriptionEntity();
		subTree4.setSubscriptionName("spring");

		Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
		subs.add(subOne);
		subs.add(subTwo);
		
		Set<SubscriptionEntity> ebookSub = new HashSet<SubscriptionEntity>();
		ebookSub.add(subTree);
		ebookSub.add(subTree2);
		ebookSub.add(subTree3);
		ebookSub.add(subTree4);

		// Add readers
		ReaderEntity readerOne = new ReaderEntity();
		readerOne.setEmail("chandupalerla@gmail.com");
		readerOne.setFirstName("chandu");
		readerOne.setLastName("palerla");

		ReaderEntity readerTwo = new ReaderEntity();
		readerTwo.setEmail("komali@gmail.com");
		readerTwo.setFirstName("komali");
		readerTwo.setLastName("palerla");
		
		ReaderEntity readerEntity = new ReaderEntity();
		readerEntity.setEmail("kaushik@gmail.com");
		readerEntity.setFirstName("Kaushik");
		readerEntity.setLastName("palerla");

		Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		readers.add(readerOne);
		readers.add(readerTwo);

		readerOne.setSubscriptions(subs);
		readerTwo.setSubscriptions(subs);
		readerEntity.setSubscriptions(ebookSub);

		session.save(readerOne);
		session.save(readerTwo);
		session.save(readerEntity);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
