package com.biblioteca.biblioteca;

import java.sql.SQLException;

public class BibliotecaApplication {


    

	public static void main(String[] args) throws SQLException {

        DBConfig.createTables(); 
       final LivroDAO livroDAO = new LivroDAO();
       final LivroController livroController = new LivroController(livroDAO);
       final BibliotecaView bibliotecaView = new BibliotecaView(livroController);
       bibliotecaView.iniciar();
    }
}