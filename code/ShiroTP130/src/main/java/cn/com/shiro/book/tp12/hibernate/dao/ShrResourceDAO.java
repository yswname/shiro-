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

import cn.com.shiro.book.tp12.entity.ShrResource;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShrResource entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.shiro.book.tp12.entity.ShrResource
 * @author MyEclipse Persistence Tools
 */
//@Transactional
public class ShrResourceDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShrResourceDAO.class);
	// property constants
	public static final String RSC_NAME = "rscName";
	public static final String RSC_REMARK = "rscRemark";

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

	public void save(ShrResource transientInstance) {
		log.debug("saving ShrResource instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShrResource persistentInstance) {
		log.debug("deleting ShrResource instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShrResource findById(java.lang.Integer id) {
		log.debug("getting ShrResource instance with id: " + id);
		try {
			ShrResource instance = (ShrResource) getCurrentSession().get(
					"cn.com.shiro.book.tp12.entity.ShrResource", id);
			//System.out.println(instance.getShrUserPermissions());
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ShrResource instance) {
		log.debug("finding ShrResource instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("cn.com.shiro.book.tp12.entity.ShrResource")
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
		log.debug("finding ShrResource instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from ShrResource as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRscName(Object rscName) {
		return findByProperty(RSC_NAME, rscName);
	}

	public List findByRscRemark(Object rscRemark) {
		return findByProperty(RSC_REMARK, rscRemark);
	}

	public List findAll() {
		log.debug("finding all ShrResource instances");
		try {
			String queryString = "from ShrResource";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShrResource merge(ShrResource detachedInstance) {
		log.debug("merging ShrResource instance");
		try {
			ShrResource result = (ShrResource) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShrResource instance) {
		log.debug("attaching dirty ShrResource instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShrResource instance) {
		log.debug("attaching clean ShrResource instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShrResourceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShrResourceDAO) ctx.getBean("ShrResourceDAO");
	}
}