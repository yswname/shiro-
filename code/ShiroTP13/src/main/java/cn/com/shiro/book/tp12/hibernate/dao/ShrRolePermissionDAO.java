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

import cn.com.shiro.book.tp12.entity.ShrRolePermission;

/**
 * A data access object (DAO) providing persistence and search support for
 * ShrRolePermission entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see cn.com.shiro.book.tp12.entity.ShrRolePermission
 * @author MyEclipse Persistence Tools
 */
//@Transactional
public class ShrRolePermissionDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ShrRolePermissionDAO.class);
	// property constants
	public static final String PRM_OPERATION_CODE = "prmOperationCode";

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

	public void save(ShrRolePermission transientInstance) {
		log.debug("saving ShrRolePermission instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(ShrRolePermission persistentInstance) {
		log.debug("deleting ShrRolePermission instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public ShrRolePermission findById(java.lang.Integer id) {
		log.debug("getting ShrRolePermission instance with id: " + id);
		try {
			ShrRolePermission instance = (ShrRolePermission) getCurrentSession()
					.get("cn.com.shiro.book.tp12.entity.ShrRolePermission", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(ShrRolePermission instance) {
		log.debug("finding ShrRolePermission instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria(
							"cn.com.shiro.book.tp12.entity.ShrRolePermission")
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
		log.debug("finding ShrRolePermission instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from ShrRolePermission as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPrmOperationCode(Object prmOperationCode) {
		return findByProperty(PRM_OPERATION_CODE, prmOperationCode);
	}

	public List findAll() {
		log.debug("finding all ShrRolePermission instances");
		try {
			String queryString = "from ShrRolePermission";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public ShrRolePermission merge(ShrRolePermission detachedInstance) {
		log.debug("merging ShrRolePermission instance");
		try {
			ShrRolePermission result = (ShrRolePermission) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(ShrRolePermission instance) {
		log.debug("attaching dirty ShrRolePermission instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(ShrRolePermission instance) {
		log.debug("attaching clean ShrRolePermission instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ShrRolePermissionDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ShrRolePermissionDAO) ctx.getBean("ShrRolePermissionDAO");
	}
}