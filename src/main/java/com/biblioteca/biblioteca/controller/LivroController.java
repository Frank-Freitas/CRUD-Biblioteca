package com.biblioteca.biblioteca.controller;

import java.sql.SQLException;
import java.util.List;

import com.biblioteca.biblioteca.model.dao.IDAO;
import com.biblioteca.biblioteca.model.entity.Livro;

public class LivroController {
    private final IDAO<Livro> livroDAO;

    public LivroController(IDAO<Livro> livroDAO) {
        this.livroDAO = livroDAO;
    }

    public void cadastrarLivro(Livro livro) throws SQLException {
        livroDAO.cadastrar(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }
    
    public void devolverLivro(Livro livro) throws SQLException {
        livroDAO.devolver(livro);
        System.out.println("Livro devolvido com sucesso!");
    }

    public Livro emprestaLivro(int id) throws SQLException {
        return livroDAO.emprestar(id);
    }

    public List<Livro> listarLivros() {
        return livroDAO.listar();
    }
    public Livro buscarLivro(int id) {
        return (Livro) livroDAO.buscar(id);
      }
}
