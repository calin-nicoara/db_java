package ro.cni.course.deutschebank.live.jdbc;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ro.cni.course.deutschebank.prepared.hibernate.SessionFactoryManager;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        final Session session = SessionFactoryManager.getSessionFactory().openSession();
//
//        getAllIds(session);
//        selectMultipleFieds(session);
//        update(session);
//        insert(session);



//        session.beginTransaction();
//        final Client client = session.get(Client.class, 7L);
//        session.delete(client);
//        session.getTransaction().commit();

//        session.beginTransaction();
//        final Client client = session.get(Client.class, 9L);
//        ClientAddress clientAddress = new ClientAddress(1L, "Dorobanti", "224G", "010232", client);
//
//        session.save(clientAddress);
//        session.getTransaction().commit();
//
        final ClientAddress clientAddress = session.get(ClientAddress.class, 1L);
        final Client client = clientAddress.getClient();
        System.out.println(client);

        System.out.println(clientAddress);
    }

    private static void update(final Session session) {
        session.beginTransaction();
        Client client = session.get(Client.class, 7L);
        client.setFirstName("New Update");
        session.update(client);

        session.getTransaction().commit();
    }

    private static void insert(final Session session) {
        session.beginTransaction();
        Client client1 = new Client(100000012, "New", "FromHibernate", "072322326", "Drobeta");
        final Serializable save = session.save(client1);
        System.out.println(save);
        session.getTransaction().commit();
    }

    private static void selectMultipleFieds(final Session session) {
        String getMoreItems = "Select c.id, c.firstName FROM Client c";
        final Query query = session.createQuery(getMoreItems);
        final List<Object[]> list1 = (List<Object[]>)query.list();

        for(Object[] row: list1) {
            for(Object field: row) {
                System.out.print(field + " ");
            }
            System.out.println();
        }

        session.close();
    }

    private static void getAllIds(final Session session) {
        String getAllClients = "Select c.id FROM Client c";
        final Query query = session.createQuery(getAllClients);
        final List<Long> list = (List<Long>)query.list();

        System.out.println(list);
    }
}
