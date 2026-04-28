package repositories;

import config.Database;
import models.Author;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();
        var sql = "SELECT authorID, firstName, lastName FROM authors";

        try (CachedRowSet rowSet = Database.connectRowSet()) {
            if (rowSet != null) {
                rowSet.setCommand(sql);
                rowSet.execute();

                while (rowSet.next()) {
                    Author author = new Author();
                    author.setId(rowSet.getInt("authorID"));
                    author.setFirstName(rowSet.getString("firstName"));
                    author.setLastName(rowSet.getString("lastName"));
                    authors.add(author);
                }
            }

            return authors;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
            return null;
        }
    }
}
