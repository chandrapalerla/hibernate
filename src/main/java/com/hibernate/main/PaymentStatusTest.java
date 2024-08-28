package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.beans.PaymentStatus;
import com.hibernate.config.HibernateUtil;

public class PaymentStatusTest {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session seesion = factory.openSession();
		Transaction tx = seesion.beginTransaction();

		PaymentStatus paymentStatus = new PaymentStatus();
		paymentStatus.setPaymentId(1);
		paymentStatus.setPaymentStatus("success");
		
		seesion.save(paymentStatus);

		tx.commit();
		seesion.close();

	}

}
