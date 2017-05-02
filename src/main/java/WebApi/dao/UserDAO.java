package WebApi.dao;

import WebApi.model.User;

import java.util.List;

/**
 * Created by usenk on 02.05.2017.
 */
public interface UserDAO {
    List<User> findById(int id);
}
