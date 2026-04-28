import repositories.AuthorRepository;

void main() {
    AuthorRepository authorRepository = new AuthorRepository();

    System.out.println("All Authors:");
    authorRepository.getAllAuthors().forEach(System.out::println);

    System.out.println();

    System.out.println("Author with ID 1: \n" + authorRepository.getAuthorById(1));
}
