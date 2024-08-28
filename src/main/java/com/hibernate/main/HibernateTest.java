package com.hibernate.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.beans.PaymentDetailsBean;

public class HibernateTest {
	public static void main(String[] args) {

		Session openSession = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();

		System.out.println("session sussfully opened");
		Transaction t = openSession.beginTransaction();

		PaymentDetailsBean paymentDetailsBean = new PaymentDetailsBean();

		//paymentDetailsBean.setPaymentId(7);

		paymentDetailsBean.setPayername("koushik");
		paymentDetailsBean.setPayerBankName("sbi");
		paymentDetailsBean.setPayerAddress("LB Nagar");

		paymentDetailsBean.setBenename("komali");
		paymentDetailsBean.setBeneBankName("HDFC");
		paymentDetailsBean.setBeneAddress("Nagaram");

		paymentDetailsBean.setAmount(785848.50f);
		paymentDetailsBean.setCurrency("EUR");

		//Serializable save = openSession.save(paymentDetailsBean);
		//System.out.println(save);

		// openSession.persist(paymentDetailsBean);

		//openSession.update(paymentDetailsBean);

		// openSession.delete(paymentDetailsBean);

		 //Object merge = openSession.merge(paymentDetailsBean);
		 //System.out.println(merge.toString());

		// openSession.saveOrUpdate(paymentDetailsBean);

		// PaymentDetailsBean load = openSession.load(PaymentDetailsBean.class, 4);
		 //System.out.println(load.toString());

		openSession.load(paymentDetailsBean, 1);

		//PaymentDetailsBean paymentDetailsBean2 = openSession.get(PaymentDetailsBean.class, 3);
		//System.out.println(paymentDetailsBean2.toString());
		openSession.flush();

		t.commit();
	}
}
