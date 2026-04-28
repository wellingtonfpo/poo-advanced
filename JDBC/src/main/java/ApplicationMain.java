import models.Author;
import repositories.AuthorRepository;

void main() {
    List<Author> authors;
    AuthorRepository authorRepository = new AuthorRepository();

    authors = authorRepository.getAllAuthors();

    for (Author author : authors) {
        System.out.println(author);
    }
}
