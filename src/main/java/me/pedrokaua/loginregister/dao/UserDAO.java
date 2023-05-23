package me.pedrokaua.loginregister.dao;

import me.pedrokaua.loginregister.entitites.User;
import org.hibernate.hql.spi.QueryTranslator;

import javax.persistence.*;
import java.util.List;

public class UserDAO {

        private static EntityManagerFactory managerFactory
                = Persistence
                .createEntityManagerFactory("connection");
        private static EntityManager manager
                = managerFactory.createEntityManager();;

        public UserDAO() {
        }

        public UserDAO startTransaction(){
            try {
                manager.getTransaction().begin();
                return this;
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

        public UserDAO closeTransaction(){
            try {
                manager.getTransaction().commit();
                return this;
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

        public void closeConnection(){
            manager.close();
        }

        public void restartConnection() {
            manager = null;
            managerFactory = null;

            try {
                managerFactory = Persistence
                        .createEntityManagerFactory("connection");
                manager = managerFactory.createEntityManager();
            } catch (Exception e) {
                System.out.println("Connection failure");
            }

        }

        public UserDAO insertUser(User user){
            try {
                manager.persist(user);
                return this;
            } catch (Exception e){
                throw new RuntimeException(e.getMessage());
            }
        }

    public UserDAO insertUserTransaction(User user){
        try {
            this.startTransaction().insertUser(user).closeTransaction();
            return this;
        } catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UserDAO updateUser(User user){
            manager.merge(user);
            return this;
    }

    public UserDAO updateUserTransaction(User user){
            this.startTransaction();
            manager.merge(user);
            this.closeTransaction();
            return this;
    }


    public List<User> findAll(){
        String jpql = "SELECT u FROM User u";

        TypedQuery<User> query
                = manager.createQuery(jpql ,User.class);

        return query.getResultList();
    }

    public User findById(Long id){
        return manager.find(User.class, id);
    }

    public User findByEmail(String email) {
        TypedQuery<User> query
                    = manager.createNamedQuery("findByEmail", User.class);
            query.setParameter("email", email);

            return query.getSingleResult();
    }

    public void deleteUser(Long id) {
            User user = findById(id);
            startTransaction();
            manager.remove(user);
            closeTransaction();
    }
}
