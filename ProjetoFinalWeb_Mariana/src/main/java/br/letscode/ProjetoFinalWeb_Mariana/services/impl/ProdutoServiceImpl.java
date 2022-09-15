package br.letscode.ProjetoFinalWeb_Mariana.services.impl;

import br.letscode.ProjetoFinalWeb_Mariana.dao.ProdutoDao;
import br.letscode.ProjetoFinalWeb_Mariana.models.Produto;
import br.letscode.ProjetoFinalWeb_Mariana.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    ProdutoDao produtoDao;

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoDao.findAll();
    }

    @Override
    public boolean novoProduto(Produto produto) {
        try{
            produtoDao.save(produto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try{
            produtoDao.save(produto);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
