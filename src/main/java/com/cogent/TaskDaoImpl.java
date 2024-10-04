package com.cogent;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class TaskDaoImpl implements TaskDao {
    Configuration configuration;
    Session session;
    SessionFactory sessionFactory;
    Transaction transaction;

    public TaskDaoImpl() {
        configuration.configure("hibernate-cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

    }


    @Override
    public void addTask(Task task) {

            session.save(task);
            transaction.commit();
            session.close();

    }

    @Override
    public void updateTask(Task task) {
        if(task != null) {
            session.update(task);
        }else {System.out.println("not found");}
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteTask(int deleteId) {
        Task task = session.get(Task.class,deleteId);
        if (task != null) {
            session.delete(task);
        }else {System.out.println("not found");}
        transaction.commit();
        session.close();
        }


    @Override
    public List<Task> getAllTasks() {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Task> criteriaQuery = criteriaBuilder.createQuery(Task.class);
        List<Task> tasks = session.createQuery(criteriaQuery).getResultList();
        for (Object task : tasks) {
            System.out.println(task);
        }
        System.out.println("------------");
        return tasks;
    }
}