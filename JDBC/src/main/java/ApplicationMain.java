import repositories.AuthorRepository;

void main() {
    AuthorRepository authorRepository = new AuthorRepository();
    authorRepository.getAllAuthors().forEach(System.out::println);
}
