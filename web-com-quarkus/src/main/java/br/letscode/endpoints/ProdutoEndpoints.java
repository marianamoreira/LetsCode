package br.letscode.endpoints;


import br.letscode.models.Produto;
import br.letscode.services.ProdutoService;
import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/produto")
public class ProdutoEndpoints {

    @Inject
    ProdutoService produtoService;

    @Operation(description = "Salvar um produto")
    @POST
    public Response salvar(@Valid Produto produto) {
        return Response.ok(produtoService.salvar(produto)).build();
    }

    @Operation(description = "Atualizar um produto")
    @PUT
    public Response atualizar(@Valid Produto produto) {
        return Response.ok(produtoService.atualizar(produto)).build();
    }

    @Operation(description = "Retorna todos os produtos")
    @GET
    public Response listarTodos() {
        return Response.ok(produtoService.getAll()).build();
    }

    @Operation(description = "Retorna produto pelo id")
    @GET
    @Path("/{id}")
    public Response listarPorId(@PathParam("id") Long id) {
        return Response.ok(produtoService.getById(id)).build();
    }

    @Operation(description = "Excluir um cliente")
    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {

        produtoService.excluir(id);
    }
}

