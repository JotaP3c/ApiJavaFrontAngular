package com.example.demo.api.apiModelo;

//Jakarta é para usada como um ''modelo'' de entidade para um banco de dados usando essa api que eu criei, jpa é isso

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
//A entidade vai definir que a classe que eu criei do jpa. é para ser usada como uma Tabela dentro do banco //


@Entity
//Estou definindo o nome da tabela que vai para o banco.
@Table(name = "usuarios")
@Data
public class user {

    /*
    Id = É a Pk do banco de dados
    GeneratedValue = Define a estratégia de geração de valores do campo de Id que é chave primária do banco.
    A estratégia que é mencionada é IDENTITY isso significa que o banco que será responsável por gerar os valores da pk.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Valor único da pk
    private Long id;

    //Mapeados para colunas da tabela de usuarios
    private String Nome;
    private String Email;

    //Se minha lógica tiver certa, o campo de data_criacao deve ser enviado para a data de criacao dentro da tabela.
    @Column(name = "data_criacao", updatable = false)

    //Esse cara é para setar a data e hora da criação.
    public LocalDateTime dataCriacao;

    /*
       Esse método debaixo, é pra definir o valor do campo de datacriada.
       sempre que um novo usuário foi criado no banco, datacriacao será preenchido com a data de criação.
       Pelo oq eu entendi é semelhante a função de datsis do lsp

    */
    @PrePersist
    public void prePersist()  {this.dataCriacao = LocalDateTime.now(); }

    public void setId(Long id) {
    }
}