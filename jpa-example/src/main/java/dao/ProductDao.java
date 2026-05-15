package dao;

import models.Product;

public class ProductDao extends GenericDao<Product, Long> {
    public ProductDao() {
        super(Product.class);
    }

    /*
     * Aqui você pode adicionar métodos específicos para a entidade Product, se necessário.
     * Por exemplo: findByName(String name), findByCategory(String category), etc.
     */
}
