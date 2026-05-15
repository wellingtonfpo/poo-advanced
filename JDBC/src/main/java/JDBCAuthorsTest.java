import config.Database;

import java.sql.*;

void main() {
    try (Connection connection = Database.connect()) {
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
        System.exit(1);
    }
}
