package com.example.ModuloIV_Web.dao;

import com.example.ModuloIV_Web.Models.Cliente;
import com.example.ModuloIV_Web.Models.PerfilEnum;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
    List<Cliente> findAllByIdOrEmail(long id, String email);
    Cliente findByEmail(String email);
    @Modifying
    @Query(value="UPDATE cliente c SET c.perfil = ?1 WHERE c.email = ?2",
    nativeQuery = true)
    void setPerfilWhereEmail(String perfil, String email);
}

