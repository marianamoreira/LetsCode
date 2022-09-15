package br.letscode.ProjetoFinalWeb_Mariana.dao;

import br.letscode.ProjetoFinalWeb_Mariana.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    void deleteByCPF(String cpf);

    Optional<Cliente> findByCPF(String cpf);
    @Modifying
    @Query(value="UPDATE cliente c SET c.perfil = ?1 WHERE c.cpf = ?2",
            nativeQuery = true)
    void setPerfilWhereCPF(String name, String cpf);
}
