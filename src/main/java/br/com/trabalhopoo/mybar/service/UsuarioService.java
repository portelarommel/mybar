package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.dto.UsuarioDto;
import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontradoException;
import br.com.trabalhopoo.mybar.exception.UsuarioNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.model.Usuario;
import br.com.trabalhopoo.mybar.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario incluirUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioDto alterarUsuario(long id, Usuario usuario) {

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com id: " + id));

        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setTipo(usuario.getTipo());
        existente.setSenha(usuario.getSenha());

        Usuario salvo = usuarioRepository.save(existente);
        return UsuarioDto.fromEntity(salvo);
    }

    public List<UsuarioDto> listarUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Usuario pesquisarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com id: " + id));
        return usuario;
    }

    public List<Usuario> pesquisarUsuarioPorFiltro(String nome) {
        return usuarioRepository.buscarComFiltros(nome);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
