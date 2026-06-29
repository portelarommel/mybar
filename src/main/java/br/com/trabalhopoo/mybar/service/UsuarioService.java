package br.com.trabalhopoo.mybar.service;

import br.com.trabalhopoo.mybar.exception.ItemCardapioNaoEncontradoException;
import br.com.trabalhopoo.mybar.exception.UsuarioNaoEncontradoException;
import br.com.trabalhopoo.mybar.model.ItemCardapio;
import br.com.trabalhopoo.mybar.model.TipoItem;
import br.com.trabalhopoo.mybar.model.Usuario;
import br.com.trabalhopoo.mybar.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario incluirUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario alterarUsuario(long id, Usuario usuario) {

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com id: " + id));

        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setSenha(usuario.getSenha());
        existente.setCodigo(usuario.getCodigo());
        existente.setTipo(usuario.getTipo());

        return usuarioRepository.save(existente);
    }

    public List<Usuario> listarUsuarios()
    {
        return usuarioRepository.findAll();
    }

    public Usuario pesquisarUsuario(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuário não encontrado com id: " + id));
    }
    public List<Usuario> pesquisarUsuarioPorFiltro(String nome)
    {
        return usuarioRepository.buscarComFiltros(nome);
    }

    public void deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
    }
}
