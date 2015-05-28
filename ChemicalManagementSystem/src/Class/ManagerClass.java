package Class;

import java.util.List;

import org.hibernate.Session;




import factory.HibernateSessionFactory;


import dao.UseregisterDAO;
import dao.DrugstockDAO;
import dao.AdddrugDAO;
import model.Adddrug;
import model.Drugstock;

public class ManagerClass {
	public List findALLRegister(){
		UseregisterDAO useregisetrdao = new UseregisterDAO();
		List list = useregisetrdao.findAll();
		return list;
	}
	public List findAllDrug(){
		DrugstockDAO drugdao = new DrugstockDAO();
		List list = drugdao.findAll();
		return list;
	}
	public List findAllAdd(){
		AdddrugDAO adddrugdao = new AdddrugDAO();
		List list = adddrugdao.findAll();
		return list;
	}
	public void deleteAdd(){
		AdddrugDAO add = new AdddrugDAO();
		Adddrug adddrug = new Adddrug();
		Session session;
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		List list = add.findAll();
		for(int i = 0;i < list.size();i++)
		{
			adddrug = (Adddrug)list.get(i);
			session.delete(adddrug);
		}
		tx.commit();
		session.close();
	}
	public void addStock(){
		DrugstockDAO drugdao = new DrugstockDAO();
		Session session;
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		List list = drugdao.findAll();
		for(int i = 0;i < list.size();i++)
		{
			Drugstock drugstock = (Drugstock)list.get(i);
			if(drugstock.getDrugCount() < 5.0){
				Adddrug adddrug = new Adddrug();
				adddrug.setDrugName(drugstock.getDrugName());
				adddrug.setDrugCount(drugstock.getDrugCount());
				session.save((Object)adddrug);
			}
		}
		tx.commit();
		session.close();
	}
}
