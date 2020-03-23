package ro.cni.course.deutschebank.prepared.hibernate;

import org.hibernate.Session;

public class HibernateMain {
    public static void main(String[] args) {
        final Session session = SessionFactoryManager.getSessionFactory().openSession();

        session.beginTransaction();
        final ClientOrder clientOrder = new ClientOrder();
        clientOrder.setId(-1);
        clientOrder.setClientName("Ionut");
        session.save(clientOrder);

        session.getTransaction().commit();
        session.close();
    }
}
