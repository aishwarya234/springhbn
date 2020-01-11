package mvchbn;

import java.util.List;

//import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

//import hbn.Employee;

@Repository
public class CustomerDao {
	@Autowired
SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionfactory=sessionFactory;
	}
	
public void addCustomer(Customer cust){
	
	Session session=sessionfactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	session.save(cust);
	try{
	tx.commit();}
	
	catch(Exception e){
		e.printStackTrace();
	}
	session.close();
	
}
public List<Customer> getCustomers(){
	Session session=sessionfactory.openSession();
	@SuppressWarnings("unchecked")
	
	List<Customer> customerlist=session.createQuery("from Customer").list();
	return customerlist;
}

public void updateCustomers(Customer cust){
	
	Session session=sessionfactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	session.update(cust);
	try{
	tx.commit();}
	
	catch(Exception e){
		e.printStackTrace();
	}
	session.close();
	
	
}

public Customer getCustomers(int code) {
	Session session=sessionfactory.openSession();
	Customer cust= (Customer) session.get(Customer.class, code);
	return cust;
	
}

public void deleteCustomer(Customer cust) {
	
	Session session=sessionfactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	session.delete(cust);
	try{
	tx.commit();}
	
	catch(Exception e){
		e.printStackTrace();
	}
	session.close();
	
}

}
