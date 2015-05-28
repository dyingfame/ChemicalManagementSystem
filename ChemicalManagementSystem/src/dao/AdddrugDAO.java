package dao;

import java.util.List;

import model.Adddrug;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Adddrug entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see dao.Adddrug
 * @author MyEclipse Persistence Tools
 */
public class AdddrugDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(AdddrugDAO.class);
	// property constants
	public static final String DRUG_COUNT = "drugCount";

	public void save(Adddrug transientInstance) {
		log.debug("saving Adddrug instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adddrug persistentInstance) {
		log.debug("deleting Adddrug instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adddrug findById(java.lang.String id) {
		log.debug("getting Adddrug instance with id: " + id);
		try {
			Adddrug instance = (Adddrug) getSession().get("model.Adddrug", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Adddrug instance) {
		log.debug("finding Adddrug instance by example");
		try {
			List results = getSession().createCriteria("model.Adddrug")
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
		log.debug("finding Adddrug instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adddrug as model where model."
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

	public List findAll() {
		log.debug("finding all Adddrug instances");
		try {
			String queryString = "from Adddrug";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adddrug merge(Adddrug detachedInstance) {
		log.debug("merging Adddrug instance");
		try {
			Adddrug result = (Adddrug) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adddrug instance) {
		log.debug("attaching dirty Adddrug instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adddrug instance) {
		log.debug("attaching clean Adddrug instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}