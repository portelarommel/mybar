package br.com.trabalhopoo.mybar.repository;

import br.com.trabalhopoo.mybar.model.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE " +
           "(:nome IS NULL OR LOWER(u.nome) LIKE LOWER(CONCAT('%', :nome, '%'))) " +
           "ORDER BY u.nome ASC")
    List<Usuario> buscarComFiltros(@Param("nome") String nome);
}
