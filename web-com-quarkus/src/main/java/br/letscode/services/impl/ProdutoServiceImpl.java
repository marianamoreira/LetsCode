package br.letscode.services.impl;

import br.letscode.dao.ProdutoDao;
import br.letscode.models.Produto;
import br.letscode.services.ProdutoService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoDao produtoDao;

//    public ClienteServiceImpl(ClienteDao clienteRepository) {
//        this.clienteDao = clienteRepository;
//    }


    @Transactional
    public Produto salvar(Produto Produto) {

        produtoDao.persist(Produto);

        return Produto;
    }

    @Transactional
    public Produto atualizar(Produto produto) {

        produtoDao.getEntityManager().merge(produto);

        return produto;
    }

    @Transactional
    public void excluir(long id) {

        produtoDao.deleteById(id);
    }

    @Transactional
    public Produto getById(long id) {
        return produtoDao.findById(id);
    }

    @Transactional
    public List<Produto> getAll() {
        return produtoDao.findAll().list();
    }
}

