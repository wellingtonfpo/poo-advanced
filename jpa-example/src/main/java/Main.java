import dao.ClientDao;
import dao.Dao;
import dao.IClientDao;
import dao.ProductDao;
import models.Client;
import models.Product;
import utils.JPAUtil;

void main() {
    IClientDao clientDao = new ClientDao();
    Dao<Product, Long> productDao = new ProductDao();

    System.out.println("--- CADASTRANDO DADOS ---");
    Client client1 = new Client("João Silva", "joao.silva@example");
    Client client2 = new Client("Maria Oliveira", "maria.oliveira@example");
    clientDao.save(client1);
    clientDao.save(client2);
    System.out.println("Clientes cadastrados: " + clientDao.findAll().size());

    Product product1 = new Product("Notebook", 3500.00);
    Product product2 = new Product("Smartphone", 1500.00);
    productDao.save(product1);
    productDao.save(product2);
    System.out.println("Produtos cadastrados: " + productDao.findAll().size());

    System.out.println();

    System.out.println("--- BUSCANDO TODOS OS CLIENTES ---");
    clientDao.findAll().forEach(System.out::println);

    System.out.println();

    System.out.println("--- BUSCANDO TODOS OS PRODUTOS ---");
    productDao.findAll().forEach(System.out::println);

    System.out.println();

    System.out.println("--- ATUALIZANDO UM PRODUTO ---");
    Product productSaved = productDao.findById(1L);
    if (productSaved != null) {
        productSaved.setPrice(3200.00);
        productDao.update(productSaved);
    }

    System.out.println("--- BUSCANDO TODOS OS PRODUTOS APÓS UPDATE ---");
    productDao.findAll().forEach(System.out::println);

    System.out.println();

    System.out.println("--- DELETANDO UM CLIENTE ---");
    clientDao.delete(2L);
    System.out.println("Cliente deletado: " + clientDao.findById(2L));

    System.out.println();

    System.out.println("--- BUSCANDO TODOS OS CLIENTES APÓS DELEÇÃO ---");
    clientDao.findAll().forEach(System.out::println);

    System.out.println("--- BUSCANDO UM CLIENTE POR EMAIL ---");
    Client clientByEmail = clientDao.findByEmail("joao.silva@example");
    System.out.println("Cliente encontrado: " + clientByEmail);

    JPAUtil.closeFactory();
}
