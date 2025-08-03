package com.biblioteca.biblioteca;

import java.sql.SQLException;

import com.biblioteca.biblioteca.config.DBConfig;
import com.biblioteca.biblioteca.controller.LivroController;
import com.biblioteca.biblioteca.model.dao.LivroDAO;
import com.biblioteca.biblioteca.view.BibliotecaView;

public class AppStart {
	public static void main(String[] args) throws SQLException {

        DBConfig.createTables(); 
       final LivroDAO livroDAO = new LivroDAO();
       final LivroController livroController = new LivroController(livroDAO);
       final BibliotecaView bibliotecaView = new BibliotecaView(livroController);
       bibliotecaView.iniciar();
    }
}