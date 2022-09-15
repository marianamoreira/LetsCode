package br.letscode.ProjetoFinalWeb_Mariana.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private long id;

    @Column(name = "cpf_cliente")
    private String CPF_Cliente;

    @Column(name="data_pedido")
    private LocalDate data;

    public Pedido(String CPF_Cliente) {
        this.CPF_Cliente = CPF_Cliente;
        this.data = LocalDate.now();
    }
}