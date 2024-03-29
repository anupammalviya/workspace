package com.anupam.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.anupam.hibernate.model.Cart;
import com.anupam.hibernate.model.Item;
import com.anupam.hibernate.util.HibernateUtil;

public class HibernateManyToManyMain {
	
	public static void main(String[] args) {
        
        Item iphone = new Item();
        iphone.setPrice(100); iphone.setDescription("iPhone");
         
        Item ipod = new Item();
        ipod.setPrice(50); ipod.setDescription("iPod");
         
        Set<Item> items = new HashSet<Item>();
        items.add(iphone); items.add(ipod);
         
        Cart cart = new Cart();
        cart.setItems(items);
        cart.setTotal(150);
         
        Cart cart1 = new Cart();
        Set<Item> items1 = new HashSet<Item>();
        items1.add(iphone);
        cart1.setItems(items1);
        cart1.setTotal(100);
         
        SessionFactory sessionFactory = null;
        try{
        sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        //session.save(cart);
        //session.save(cart1);
        
        Cart persistedCart = (Cart)session.get(Cart.class, new Long(7));
        
        session.delete(persistedCart);
        System.out.println("Before committing transaction");
        tx.commit();
        sessionFactory.close();
         
        System.out.println("Cart ID="+cart.getId());
        System.out.println("Cart1 ID="+cart1.getId());
        System.out.println("Item1 ID="+iphone.getId());
        System.out.println("Item2 ID="+ipod.getId());
         
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(sessionFactory != null && !sessionFactory.isClosed()) sessionFactory.close();
        }
         
    }

}
