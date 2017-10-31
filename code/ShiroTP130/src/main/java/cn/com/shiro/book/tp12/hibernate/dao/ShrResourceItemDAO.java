package cn.com.shiro.book.tp12.hibernate.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import cn.com.shiro.book.tp12.entity.ShrResourceItem;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShrResourceItem entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.shiro.book.tp12.entity.ShrResourceItem
 * @author MyEclipse Persistence Tools
 */
//@Transactional
public class ShrResourceItemDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShrResourceItemDAO.class);
	// property constants
	public static final String ITM_TYPE = "itmType";
	public static final String ITM_URL = "itmUrl";
	public static final String ITM_REMARK = "itmRemark";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(ShrResourceItem transientInstance) {
		log.debug("saving ShrResourceItem instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShrResourceItem persistentInstance) {
		log.debug("deleting ShrResourceItem instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShrResourceItem findById(java.lang.Integer id) {
		log.debug("getting ShrResourceItem instance with id: " + id);
		try {
			ShrResourceItem instance = (ShrResourceItem) getCurrentSession()
					.get("cn.com.shiro.book.tp12.entity.ShrResourceItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ShrResourceItem instance) {
		log.debug("finding ShrResourceItem instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("cn.com.shiro.book.tp12.entity.ShrResourceItem")
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
		log.debug("finding ShrResourceItem instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ShrResourceItem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByItmType(Object itmType) {
		return findByProperty(ITM_TYPE, itmType);
	}

	public List findByItmUrl(Object itmUrl) {
		return findByProperty(ITM_URL, itmUrl);
	}

	public List findByItmRemark(Object itmRemark) {
		return findByProperty(ITM_REMARK, itmRemark);
	}

	public List findAll() {
		log.debug("finding all ShrResourceItem instances");
		try {
			String queryString = "from ShrResourceItem";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShrResourceItem merge(ShrResourceItem detachedInstance) {
		log.debug("merging ShrResourceItem instance");
		try {
			ShrResourceItem result = (ShrResourceItem) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShrResourceItem instance) {
		log.debug("attaching dirty ShrResourceItem instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShrResourceItem instance) {
		log.debug("attaching clean ShrResourceItem instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShrResourceItemDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShrResourceItemDAO) ctx.getBean("ShrResourceItemDAO");
	}
}