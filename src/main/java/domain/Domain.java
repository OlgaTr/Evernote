package domain;

import bl.HibernateUtil;
import org.hibernate.Session;

public class Domain {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
