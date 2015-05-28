package Class;

import java.util.List;

import org.hibernate.Session;

import factory.HibernateSessionFactory;
import dao.AdddrugDAO;
import model.Adddrug;
import dao.DrugstockDAO;
import model.Drugstock;

public class BuyClass {
	public void submit(String name,Double count){
		AdddrugDAO adddrugdao = new AdddrugDAO();
		Adddrug adddrug = new Adddrug();
		Session session;
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		adddrug.setDrugName(name);
		adddrug.setDrugCount(count);
		session.save((Object)adddrug);
		tx.commit();
		session.close();
	}
	public boolean isDrugExist(String name){
		DrugstockDAO drugstockdao = new DrugstockDAO();
		List list = drugstockdao.findAll();
		for(int i = 0;i < list.size();i++)
		{
			Drugstock drugstock = (Drugstock)list.get(i);
			if(drugstock.getDrugName().equals(name))
				return true;
		}
		return false;
	}
}
