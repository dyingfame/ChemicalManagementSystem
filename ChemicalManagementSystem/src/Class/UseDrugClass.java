package Class;

import java.util.List;

import org.hibernate.Session;

import factory.HibernateSessionFactory;

import dao.DrugstockDAO;
import model.Drugstock;
import dao.UseregisterDAO;
import model.Useregister;

public class UseDrugClass {

	DrugstockDAO drugstockdao = new DrugstockDAO();
	Drugstock drugstock;
	UseregisterDAO useregisterdao = new UseregisterDAO();
	public String[] getDrugName(){
		List list = drugstockdao.findAll();
		String[] name = new String[list.size()];
		for(int i = 0;i<list.size();i++)
		{
			drugstock = (Drugstock)list.get(i);
			name[i] = drugstock.getDrugName();
		}
		return name;
	}
	public void addToRegister(String uname,String uNum,String dName,double dCount,String date){
		Session session;
		Useregister useregister = new Useregister();
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		useregister.setUserName(uname);
		useregister.setUserNum(uNum);
		useregister.setDrugName(dName);
		useregister.setDrugCount(dCount);
		useregister.setDate(date);
		useregister.setRecord(String.valueOf(UID.next()));
		session.save((Object)useregister);
		tx.commit();
		session.close();
	}
	public boolean judgeAbuse(String dName,String dNum){
		drugstock = drugstockdao.findById(dName);
		if(drugstock.getDrugLimit() < Double.valueOf(dNum))
			return false;
		return true;
	}
	public boolean judgeRemain(String dName,String dNum){
		drugstock = drugstockdao.findById(dName);
		if(drugstock.getDrugCount() < Double.valueOf(dNum))
			return false;
		return true;
	}
	public void deleteCount(String dName,String dNum){
		drugstock = drugstockdao.findById(dName);
		Session session;
		drugstock.setDrugCount(drugstock.getDrugCount() - Double.valueOf(dNum));
		session = HibernateSessionFactory.getSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.merge((Object)drugstock);
		tx.commit();
		session.close();
	}
}
