package br.letscode.services.impl;

import br.letscode.dao.ClienteDao;
import br.letscode.models.PerfilEnum;
import br.letscode.services.ClienteService;
import br.letscode.models.Cliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteDao clienteDao;

//    public ClienteServiceImpl(ClienteDao clienteRepository) {
//        this.clienteDao = clienteRepository;
//    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteDao.findByEmail(email);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        cliente.setPerfil(PerfilEnum.CLIENTE);

        clienteDao.persist(cliente);

        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente) {
        cliente.setPerfil(PerfilEnum.CLIENTE);

        clienteDao.getEntityManager().merge(cliente);

        return cliente;
    }

    @Transactional
    public void excluir(long id) {

        clienteDao.deleteById(id);
    }

    @Transactional
    public Cliente getById(long id) {
        return clienteDao.findById(id);
    }

    @Transactional
    public List<Cliente> getAll() {
        return clienteDao.findAll().list();
    }
}

