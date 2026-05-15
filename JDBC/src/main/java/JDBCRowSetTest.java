import config.Database;

import javax.sql.rowset.CachedRowSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

void main() {
    try (CachedRowSet rowSet = Database.connectRowSet()) {
        final String QUERY = "SELECT authorID, firstName, lastName FROM authors";

        if (rowSet != null) {
            rowSet.setCommand(QUERY);
            rowSet.execute();

            System.out.printf("Authors Table of Books Database%n");

            ResultSetMetaData metaData = rowSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i).toUpperCase());

            System.out.println();

            while (rowSet.next()) {
                for (int i = 1; i <= columnCount; i++)
                    System.out.printf("%-8s\t", rowSet.getObject(i));

                System.out.println();
            }
        }

    } catch (SQLException e) {
        System.out.println(e.getMessage());
        System.exit(1);
    }
}

