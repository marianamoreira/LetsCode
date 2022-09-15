package br.letscode.dao;


import br.letscode.models.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutoDao implements PanacheRepositoryBase<Produto, Long> {

}
