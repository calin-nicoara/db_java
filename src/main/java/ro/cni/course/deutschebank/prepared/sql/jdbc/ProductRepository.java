package ro.cni.course.deutschebank.prepared.sql.jdbc;


import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    private static ProductRepository productRepository = null;

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        if(productRepository == null) {
            productRepository = new ProductRepository();
        }

        return productRepository;
    }

    private static final String PRODUCT_SELECT = "Select id, name, price, brand from product";

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(PRODUCT_SELECT);

            while(resultSet.next()) {
                Product product = getProduct(resultSet);
                products.add(product);
            }

//            resultSet.first();
//            System.out.println(resultSet.getLong("id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Optional<Product> getProduct(Long id) {
        String singleSelect = PRODUCT_SELECT + " where id = ?";

        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    singleSelect,
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            Product product = null;
            while(resultSet.next()) {
                product = getProduct(resultSet);
            }

            statement.close();
            return Optional.ofNullable(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private Product getProduct(final ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        BigDecimal price = resultSet.getBigDecimal("price");
        String brand = resultSet.getString("brand");

        return new Product(id, name, price, brand);
    }

    public void addProductRaw(Product product) {
        final String insertQuery = "INSERT INTO product VALUES (%d, '%s', %f, '%s')";

        String finalInsert = String.format(insertQuery, product.getId(), product.getName(),
                product.getPrice().doubleValue(), product.getBrand());

        Connection connection = getConnection();

        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute(finalInsert);

            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        Connection connection = getConnection();
        final String insertQuery = "INSERT INTO product VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setBigDecimal(3, product.getPrice());
            preparedStatement.setString(4, product.getBrand());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProducts(List<Product> products) {
        Connection connection = getConnection();
        final String insertQuery = "INSERT INTO product VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for(Product product: products) {
                preparedStatement.setLong(1, product.getId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setBigDecimal(3, product.getPrice());
                preparedStatement.setString(4, product.getBrand());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        Connection connection = getConnection();
        final String updateQuery = "UPDATE product SET " +
                " name = ?," +
                " price = ?," +
                " brand = ?" +
                " where id = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setBigDecimal(2, product.getPrice());
            preparedStatement.setString(1, product.getBrand());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432" +
                    "/postgres?currentSchema=public", "postgres", "docker");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Connection to db not working!");
        }
    }


}
