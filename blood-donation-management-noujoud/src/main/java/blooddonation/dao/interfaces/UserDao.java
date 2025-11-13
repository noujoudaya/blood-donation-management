package blooddonation.dao.interfaces;

import blooddonation.bean.User;

public interface UserDao {
    void save(User user);
    User findByEmail(String email);
}
