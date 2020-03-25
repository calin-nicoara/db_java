package ro.cni.course.deutschebank.prepared.hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        final Session session = SessionFactoryManager.getSessionFactory().openSession();

        String getAll = "SELECT co.id, co.clientName FROM ClientOrder co";
        final Query query = session.createQuery(getAll);
        final List<Object[]> list = (List<Object[]>)query.list();
        for(Object[] objectFields: list) {
            System.out.println(objectFields[0]);
            System.out.println(objectFields[1]);
        }

//        saveNEwClient(session);

//        updateAndGetAFterUpdate(session);

        session.close();
    }

    private static void updateAndGetAFterUpdate(final Session session) {
        session.beginTransaction();
        final ClientOrder clientOrder = session.get(ClientOrder.class, 3);
        System.out.println(clientOrder);
        clientOrder.setClientName("New Saved Name 3");
        session.save(clientOrder);
        session.getTransaction().commit();

        session.beginTransaction();
        final ClientOrder clientOrderAfterUpdate = session.get(ClientOrder.class, 3);
        System.out.println("After update");
        System.out.println(clientOrderAfterUpdate);
        session.getTransaction().commit();
    }

    private static void saveNEwClient(final Session session) {
        session.beginTransaction();
        final ClientOrder clientOrder = new ClientOrder();
        clientOrder.setId(-1);
        clientOrder.setClientName("Ionut");
        session.save(clientOrder);
        session.getTransaction().commit();
    }
}
