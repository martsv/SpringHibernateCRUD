package ru.martsv.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.martsv.model.User;

import java.util.List;

/**
 * Created by mart on 17.05.16.
 */
@Repository
public class UserDAOHibernate implements UserDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserDAOHibernate.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void add(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User saved successfully, User details=" + user);
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated successfully, User details=" + user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session.createCriteria(User.class).list();
        for(User user : usersList){
            logger.info("User list::" + user);
        }
        return usersList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findPart(Integer offset, Integer maxResults, String search) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        if (search != null && !"".equals(search))
            criteria = criteria
                    .add(Restrictions.eq("name", search));
        criteria = criteria
                .setFirstResult(offset != null? offset: 0)
                .setMaxResults(maxResults != null? maxResults: 5);
        List<User> usersList = criteria.list();
        for(User user : usersList){
            logger.info("User list::" + user);
        }
        return usersList;
    }

    @Override
    public Long count() {
        Session session = this.sessionFactory.getCurrentSession();
        Long count = (Long)session
                .createCriteria(User.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
        logger.info("Users count=" + count);
        return count;
    }

    @Override
    public Long count(String search) {
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class);
        if (search != null && !"".equals(search))
            criteria = criteria
                    .add(Restrictions.eq("name", search));
        Long count = (Long)criteria
                .setProjection(Projections.rowCount())
                .uniqueResult();
        logger.info("Users count=" + count);
        return count;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findByName(String name) {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> usersList = session
                .createCriteria(User.class)
                .add(Restrictions.eq("name", name))
                .list();
        for(User user : usersList){
            logger.info("User list::" + user);
        }
        return usersList;
    }

    @Override
    public User getById(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Long(id));
        logger.info("User loaded successfully, User details=" + user);
        return user;
    }

    @Override
    public void delete(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Long(id));
        if (null != user){
            session.delete(user);
        }
        logger.info("User deleted successfully, User details=" + user);
    }
}
