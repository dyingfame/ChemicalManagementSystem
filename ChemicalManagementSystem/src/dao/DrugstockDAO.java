package dao;

import java.util.List;

import model.Drugstock;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Drugstock entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Drugstock
 * @author MyEclipse Persistence Tools
 */
public class DrugstockDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DrugstockDAO.class);
	// property constants
	public static final String DRUG_COUNT = "drugCount";
	public static final String DRUG_LIMIT = "drugLimit";
	public static final String DRUG_LIGHT = "drugLight";
	public static final String DRUG_VOLAT = "drugVolat";
	public static final String REMARK = "remark";
	public static final String DRUG_UNIT_PRICE = "drugUnitPrice";

	public void save(Drugstock transientInstance) {
		log.debug("saving Drugstock instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Drugstock persistentInstance) {
		log.debug("deleting Drugstock instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Drugstock findById(java.lang.String id) {
		log.debug("getting Drugstock instance with id: " + id);
		try {
			Drugstock instance = (Drugstock) getSession().get("model.Drugstock",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Drugstock instance) {
		log.debug("finding Drugstock instance by example");
		try {
			List results = getSession().createCriteria("model.Drugstock")
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
		log.debug("finding Drugstock instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Drugstock as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDrugCount(Object drugCount) {
		return findByProperty(DRUG_COUNT, drugCount);
	}

	public List findByDrugLimit(Object drugLimit) {
		return findByProperty(DRUG_LIMIT, drugLimit);
	}

	public List findByDrugLight(Object drugLight) {
		return findByProperty(DRUG_LIGHT, drugLight);
	}

	public List findByDrugVolat(Object drugVolat) {
		return findByProperty(DRUG_VOLAT, drugVolat);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByDrugUnitPrice(Object drugUnitPrice) {
		return findByProperty(DRUG_UNIT_PRICE, drugUnitPrice);
	}

	public List findAll() {
		log.debug("finding all Drugstock instances");
		try {
			String queryString = "from Drugstock";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Drugstock merge(Drugstock detachedInstance) {
		log.debug("merging Drugstock instance");
		try {
			Drugstock result = (Drugstock) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Drugstock instance) {
		log.debug("attaching dirty Drugstock instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Drugstock instance) {
		log.debug("attaching clean Drugstock instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}