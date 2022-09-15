package br.letscode.ProjetoFinalWeb_Mariana.services.impl;

import br.letscode.ProjetoFinalWeb_Mariana.dao.PedidoDao;
import br.letscode.ProjetoFinalWeb_Mariana.models.Pedido;
import br.letscode.ProjetoFinalWeb_Mariana.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;
    @Override
    public List<Pedido> listarTodosPedidos() {
        return pedidoDao.findAll();
    }

    @Override
    public boolean novoPedido(Pedido pedido) {
        try{
            pedidoDao.save(pedido);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean atualizarPedido(Pedido pedido) {
        try{
            pedidoDao.save(pedido);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean removerPedido(long id) {
        try {
            pedidoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
