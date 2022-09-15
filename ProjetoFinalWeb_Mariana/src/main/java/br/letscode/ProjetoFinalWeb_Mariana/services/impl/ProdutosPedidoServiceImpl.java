package br.letscode.ProjetoFinalWeb_Mariana.services.impl;

import br.letscode.ProjetoFinalWeb_Mariana.dao.ProdutoPorPedidoDao;
import br.letscode.ProjetoFinalWeb_Mariana.models.ProdutoPorPedido;
import br.letscode.ProjetoFinalWeb_Mariana.services.ProdutosPorPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProdutosPedidoServiceImpl implements ProdutosPorPedidoService {

    @Autowired
    ProdutoPorPedidoDao produtoPorPedidoDao;

    @Override
    public List<ProdutoPorPedido> listarProdutosPorPedidos(long idPedido) {

        return produtoPorPedidoDao.findAllByIdPedido(idPedido);
        //return produtoPorPedidoDao.findAll();
    }

    @Override
    public boolean novoProdutoPedido(ProdutoPorPedido produtoPorPedido) {
        try{
            produtoPorPedidoDao.save(produtoPorPedido);
            return true;
        }catch (Exception e){
            System.out.println("ATENCAAAAAAO e.getMessage() = " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean atualizarProdutoPedido(ProdutoPorPedido produtoPorPedido) {
        try{
            produtoPorPedidoDao.save(produtoPorPedido);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    @Override
    public boolean removerProdutoPedido(long idProduto, long idPedido) {
        try {
            produtoPorPedidoDao.deleteByIdProdutoAndIdPedido(idProduto,idPedido);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
