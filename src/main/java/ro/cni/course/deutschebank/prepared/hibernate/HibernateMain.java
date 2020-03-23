package ro.cni.course.deutschebank.prepared.hibernate;

import org.hibernate.Session;

public class HibernateMain {
    public static void main(String[] args) {
        final Session session = SessionFactoryManager.getSessionFactory().openSession();
        System.out.println();
        session.beginTransaction();
//        saveNEwClient(session);

        final ClientOrder clientOrder = session.get(ClientOrder.class, 3);
        System.out.println(clientOrder);

        session.getTransaction().commit();
        session.close();
    }

    private static void saveNEwClient(final Session session) {
        final ClientOrder clientOrder = new ClientOrder();
        clientOrder.setId(-1);
        clientOrder.setClientName("Ionut");
        session.save(clientOrder);
    }
}
