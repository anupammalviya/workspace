package com.anupam.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.anupam.hibernate.model.Cart;
import com.anupam.hibernate.model.Items;
import com.anupam.hibernate.util.HibernateUtil;

public class HibernateOneToManyMain {
	
	public static void main(String[] args) {
		 
        Cart cart = new Cart();
        cart.setName("MyCart");
         
        Items item1 = new Items("I1", 10, 1, cart);
        Items item2 = new Items("I2", 20, 2, cart);
        Set<Items> itemsSet = new HashSet<Items>();
        itemsSet.add(item1); itemsSet.add(item2);
         
        cart.setItems(itemsSet);
        cart.setTotal(10*1 + 20*2);
         
        SessionFactory sessionFactory = null;
        Session session = null;
        Session sessionAgain = null;
        Transaction tx = null;
        Transaction txAgain = null;
        try{
        //Get Session
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.getCurrentSession();
        System.out.println("Session created");
        //start transaction
        tx = session.beginTransaction();
        
        
        //Save the Model objects
        session.save(cart);
        
        session.saveOrUpdate(item1);
        
        //Cart persistedCart = (Cart)session.get(Cart.class, new Long(6));
        //Cart persistedCart = (Cart)session.load(Cart.class, new Long(6));
        //Cart persistedCart = (Cart)session.createCriteria(Cart.class).setFetchMode("items", FetchMode.JOIN).add(Restrictions.idEq(new Long(6))).uniqueResult();
        //Hibernate.initialize(persistedCart.getItems());
        //Cart deleteCart = (Cart)session.get(Cart.class, new Long(5));
        //session.delete(deleteCart);
        //session.save(item1);
        //session.save(item2);
         
        //Commit transaction
        tx.commit();
        
        sessionAgain = sessionFactory.getCurrentSession();
        txAgain = sessionAgain.beginTransaction();
        sessionAgain.lock(item1, LockMode.NONE);
        
        item1.setItemTotal(150);
        sessionAgain.saveOrUpdate(item1);
        
        txAgain.commit();
        System.out.println("Cart ID="+cart.getId());
        
        //System.out.println(persistedCart.getItems().toString());
         
        }catch(Exception e){
            System.out.println("Exception occured. "+e.getMessage());
            e.printStackTrace();
        }finally{
            if(!sessionFactory.isClosed()){
                System.out.println("Closing SessionFactory");
                sessionFactory.close();
            }
        }
    }

}
