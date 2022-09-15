package br.letscode.ProjetoFinalWeb_Mariana.services;

import br.letscode.ProjetoFinalWeb_Mariana.dto.ClienteDto;
import br.letscode.ProjetoFinalWeb_Mariana.models.Cliente;
import br.letscode.ProjetoFinalWeb_Mariana.models.PerfilEnum;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ClienteService {

    List<Cliente> listarTodosClientes();

    Cliente listarClientePorCPF(String cpf) throws ChangeSetPersister.NotFoundException;

    boolean novoCliente(ClienteDto clienteDto);

    boolean atualizarCliente(Cliente cliente);

    boolean removerClientePorCPF(String cpf);

    boolean atualizarPerfil(String email, PerfilEnum perfilEnum);
}
