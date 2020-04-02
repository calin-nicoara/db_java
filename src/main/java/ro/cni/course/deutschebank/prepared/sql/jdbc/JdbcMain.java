package ro.cni.course.dbcourse.prepared.sql.jdbc;

public class JdbcMain {
    public static void main(String[] args) {
        ProductRepository productRepository = ProductRepository.getInstance();

        System.out.println(productRepository.getAllProducts());
    }
}
