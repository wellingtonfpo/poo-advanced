import java.sql.*;

public class ConfigDatabase {
    public static Connection connect() {
        final String DATABASE_URL = "jdbc:sqlite:src/main/resources/books.db";

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);

            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();

                System.out.println("Driver Name: " + metaData.getDriverName());

                // check if database is existing or new
                if (metaData.getDatabaseProductVersion().isEmpty()) {
                    System.out.println("A new database has been created.");
                }

                System.out.println("Connected to the database successfully!");
                System.out.println();

                return connection;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
