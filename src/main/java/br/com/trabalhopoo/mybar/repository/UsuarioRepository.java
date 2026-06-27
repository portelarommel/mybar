package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
