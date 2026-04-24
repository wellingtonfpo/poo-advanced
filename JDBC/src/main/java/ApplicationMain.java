import java.sql.*;

private Connection connectDatabase() {
    String DATABASE_URL = "jdbc:sqlite:src/main/resources/books.db";

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

void main() {
    try (Connection connection = connectDatabase()) {
        final String QUERY = "SELECT authorID, firstName, lastName FROM authors";

        System.out.printf("Authors Table of Books Database%n");

        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i).toUpperCase());

            System.out.println();

            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));

                System.out.println();
            }
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
}
