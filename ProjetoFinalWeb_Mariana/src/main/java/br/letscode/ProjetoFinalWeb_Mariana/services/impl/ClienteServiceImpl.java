package br.letscode.ProjetoFinalWeb_Mariana.services.impl;

import br.letscode.ProjetoFinalWeb_Mariana.dao.ClienteDao;
import br.letscode.ProjetoFinalWeb_Mariana.dto.ClienteDto;
import br.letscode.ProjetoFinalWeb_Mariana.models.Cliente;
import br.letscode.ProjetoFinalWeb_Mariana.models.PerfilEnum;
import br.letscode.ProjetoFinalWeb_Mariana.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final PasswordEncoder passwordEncoder;

    public ClienteServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    ClienteDao clienteDao;

    public Cliente listarClientePorCPF(String CPF) throws ChangeSetPersister.NotFoundException {
        return clienteDao.findByCPF(CPF).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteDao.findAll();
    }

    public boolean novoCliente(ClienteDto clienteDto) {
        try {
            if (clienteDto.getId() == 0) {
                clienteDto.setSenha(passwordEncoder.encode(clienteDto.getSenha()));
            }
            Cliente cliente = new Cliente(clienteDto.getId(), clienteDto.getCPF(), clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getSenha(), PerfilEnum.CLIENTE);
            clienteDao.save(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizarCliente(Cliente cliente) {
        try {
            Optional<Cliente> cli = clienteDao.findById(cliente.getId());
            if(cli.isPresent()) {
                if (!passwordEncoder.encode(cliente.getSenha()).equals(cli.get().getSenha()))
                    cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
                if (!cli.get().getPerfil().equals(cliente.getPerfil()))
                    cliente.setPerfil(cli.get().getPerfil());
            }
            else{
                cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
                cliente.setPerfil(PerfilEnum.CLIENTE);
            }
            clienteDao.save(cliente);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean removerClientePorCPF(String cpf) {
        try {
            clienteDao.deleteByCPF(cpf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean atualizarPerfil(String cpf, PerfilEnum perfilEnum) {
        try {
            clienteDao.setPerfilWhereCPF(perfilEnum.name(), cpf);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
