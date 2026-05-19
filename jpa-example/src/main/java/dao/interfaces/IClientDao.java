package dao.interfaces;

import models.Client;

public interface IClientDao extends Dao<Client, Long> {
    Client findByEmail(String email);
}
