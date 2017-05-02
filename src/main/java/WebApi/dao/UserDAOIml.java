package WebApi.dao;

import WebApi.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by usenk on 02.05.2017.
 */
@Repository("UserDAO")
@Transactional
@EnableTransactionManagement
public class UserDAOIml implements UserDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public UserDAOIml(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @Override
    public List<User> findById(int id) {
        Query query = getCurrentSession().createQuery("FROM User ");
        List<User> list = query.list();
        return list;
    }
}
