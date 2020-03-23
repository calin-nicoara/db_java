package ro.cni.course.deutschebank.prepared.hibernate;

import org.hibernate.Session;

public class HibernateMain {
    public static void main(String[] args) {
        final Session session = SessionFactoryManager.getSessionFactory().openSession();


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
