package cn.com.shiro.book.tp12.hibernate.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UtilDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List findByHql(String hql,List datas){
		List list = null;
		Session session = this.getCurrentSession();
		Query query = session.createQuery(hql);
		if(datas != null){
			for(int i=0;i<datas.size();i++){
				query.setParameter(i, datas.get(i));
			}
		}
		list = query.list();
		return list;
	}
	
	public List findByHql(String hql,Map<String,Object> datas){
		List list = null;
		Session session = this.getCurrentSession();
		Query query = session.createQuery(hql);
		if(datas != null){
			Set<Entry<String,Object>> entrys = datas.entrySet();
			for(Entry<String,Object> entry:entrys){
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
		list = query.list();
		return list;
	}
}
