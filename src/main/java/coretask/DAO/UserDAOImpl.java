package coretask.DAO;


import coretask.model.Role;
import coretask.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        user.setRoles(Collections.singleton(new Role(2L, "ROLE_USER")));
        entityManager.persist(user);
    }

    @Override
    public void editUser(User user) {
        if (user.getRoles().contains(new Role(1L, "ROLE_ADMIN"))) {
            user.setRoles(Collections.singleton(new Role(2L, "ROLE_ADMIN")));
        } else {
            user.setRoles(Collections.singleton(new Role(1L,"ROLE_USER" )));
        }
        entityManager.merge(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("from User user WHERE user.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }
}
