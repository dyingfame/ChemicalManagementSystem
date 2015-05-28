package dao;

import java.util.List;

import model.Useregister;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Useregister entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see dao.Useregister
 * @author MyEclipse Persistence Tools
 */
public class UseregisterDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(UseregisterDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_NUM = "userNum";
	public static final String DRUG_NAME = "drugName";
	public static final String DRUG_COUNT = "drugCount";
	public static final String DATE = "date";

	public void save(Useregister transientInstance) {
		log.debug("saving Useregister instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Useregister persistentInstance) {
		log.debug("deleting Useregister instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Useregister findById(java.lang.String id) {
		log.debug("getting Useregister instance with id: " + id);
		try {
			Useregister instance = (Useregister) getSession().get(
					"model.Useregister", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Useregister instance) {
		log.debug("finding Useregister instance by example");
		try {
			List results = getSession().createCriteria("model.Useregister")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Useregister instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Useregister as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserNum(Object userNum) {
		return findByProperty(USER_NUM, userNum);
	}

	public List findByDrugName(Object drugName) {
		return findByProperty(DRUG_NAME, drugName);
	}

	public List findByDrugCount(Object drugCount) {
		return findByProperty(DRUG_COUNT, drugCount);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findAll() {
		log.debug("finding all Useregister instances");
		try {
			String queryString = "from Useregister";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Useregister merge(Useregister detachedInstance) {
		log.debug("merging Useregister instance");
		try {
			Useregister result = (Useregister) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Useregister instance) {
		log.debug("attaching dirty Useregister instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Useregister instance) {
		log.debug("attaching clean Useregister instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}