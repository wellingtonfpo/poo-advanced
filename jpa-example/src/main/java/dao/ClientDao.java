package dao;

import models.Client;

public class ClientDao extends GenericDao<Client, Long> {
    public ClientDao() {
        super(Client.class);
    }

    /*
    * Aqui você pode adicionar métodos específicos para a entidade Client, se necessário.
    * Por exemplo: findByEmail(String email), findByCpf(String cpf), etc.
    */
}
