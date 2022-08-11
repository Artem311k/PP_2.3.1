package MainApp.DAO;

import MainApp.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> showUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void deleteUserById(int id) {
    entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.find(User.class, id);

    }

    @Override
    public void updateUser(User userToUpdate) {
        entityManager.merge(userToUpdate);
    }
}
