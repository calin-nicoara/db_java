package ro.cni.course.deutschebank.live.jdbc;

import java.sql.*;

public class JdbcMain {
    public static void main(String[] args) {
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "docker")) {
            connection.setAutoCommit(false);

            insertClient(connection);

            final Client client = getClient(connection, 1000991L);
            System.out.println(client);

//            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertClient(final Connection connection) throws SQLException {
        String insertQuery = "INSERT INTO client (id, first_name, last_name, phone_number, city) " +
                "VALUES (?, ?, ?, ?, ?)";

        final PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setLong(1, 1000991L);
        preparedStatement.setString(2, "Nocommit");
        preparedStatement.setString(3, "Albu");
        preparedStatement.setString(4, "072323239");
        preparedStatement.setString(5, "Bucuresti");

        preparedStatement.execute();
    }

    private static Client getClient(final Connection connection, final Long id) throws SQLException {
        String getClientByIdQuery = "SELECT  id, first_name,last_name, phone_number, city FROM client " +
                " where id = ?";
        final PreparedStatement statement = connection.prepareStatement(getClientByIdQuery);
        statement.setLong(1, id);

        final ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return getClient(resultSet);
        }

        return null;
    }

    private static void countQuery(final Connection connection) throws SQLException {
        String countClients = "Select count(*) from client";

        final ResultSet resultSet = connection.createStatement().executeQuery(countClients);
        resultSet.next();
        System.out.println(resultSet.getLong(1));
    }

    private static void readAllClients(final Connection connection) throws SQLException {
        final Statement statement = connection.createStatement();

        String getAllClients = "SELECT  id, first_name,last_name, phone_number, city FROM client" +
                " ORDER BY id";

        final ResultSet resultSet = statement.executeQuery(getAllClients);

        while(resultSet.next()) {
            Client client = getClient(resultSet);

            System.out.println(client);
        }
    }

    private static Client getClient(final ResultSet resultSet) throws SQLException {
        final long id = resultSet.getLong("id");
        String name = resultSet.getString("first_name");
        String last_name = resultSet.getString("last_name");
        String phone_number = resultSet.getString("phone_number");
        String city = resultSet.getString("city");
        return new Client(id, name, last_name, phone_number, city);
    }
}
