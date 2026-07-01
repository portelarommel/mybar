package br.com.trabalhopoo.mybar.dto;

import br.com.trabalhopoo.mybar.model.Usuario;
import br.com.trabalhopoo.mybar.model.enums.TipoDeUsuario;

public class UsuarioDto {

    private Long id;
    private String codigo;
    private String nome;
    private String email;
    private TipoDeUsuario tipo;

    public UsuarioDto() {
    }

    public UsuarioDto(Long id, String codigo, String nome, String email, TipoDeUsuario tipo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TipoDeUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeUsuario tipo) {
        this.tipo = tipo;
    }

    public static UsuarioDto fromEntity(Usuario usuario) {
        UsuarioDto dto = new UsuarioDto();

        dto.setId(usuario.getId());
        dto.setCodigo(usuario.getCodigo());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTipo(usuario.getTipo());

        return dto;
    }

}
