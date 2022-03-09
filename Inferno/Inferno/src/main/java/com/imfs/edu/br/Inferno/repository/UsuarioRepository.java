package com.imfs.edu.br.Inferno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imfs.edu.br.Inferno.orm.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
