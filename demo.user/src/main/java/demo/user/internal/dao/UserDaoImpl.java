package demo.user.internal.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import demo.user.dao.UserDao;
import demo.user.entity.User;

@Repository
public class UserDaoImpl  implements UserDao{
	
	@Autowired
	private HibernateTemplate template;

	
	public HibernateTemplate getHibernateTemplate(){
		return this.template;
	}
	
	@Override
	public void insert(User user) {
		getHibernateTemplate().save(user);
		
	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public List<User> getAll() {
		return getHibernateTemplate().execute(new HibernateCallback<List<User>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				List<User> list = session.createQuery("from "+User.class.getName()).list();
				return list;
			}
		});
	}

	@Override
	public User getById(long id) {
		return (User)getHibernateTemplate().find(" from "+User.class.getName()+ " where id = ?", id).get(0);
	}

}
