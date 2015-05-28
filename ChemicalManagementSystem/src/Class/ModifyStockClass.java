package Class;

import model.Drugstock;
import dao.DrugstockDAO;

import org.hibernate.Session;

import factory.HibernateSessionFactory;

public class ModifyStockClass {
	public void mergeDrugStock(Drugstock drugstock){
		Session session;
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.merge((Object)drugstock);
		tx.commit();
		session.close();
	}
	public boolean isDrugExist(String drug){
		DrugstockDAO drugstockdao = new DrugstockDAO();
		Drugstock drugstock = drugstockdao.findById(drug);
		if(drugstock == null)
			return false;
		return true;
	}
	public void addNewDrug(Drugstock drugstock){
		Session session;
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save((Object)drugstock);
		tx.commit();
		session.close();
	}
}
