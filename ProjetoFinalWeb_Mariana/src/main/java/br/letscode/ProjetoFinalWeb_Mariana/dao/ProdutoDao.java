package br.letscode.ProjetoFinalWeb_Mariana.dao;

import br.letscode.ProjetoFinalWeb_Mariana.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoDao extends JpaRepository<Produto, Long> {
}
