package com.biblioteca.biblioteca.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.biblioteca.config.DBConfig;
import com.biblioteca.biblioteca.model.entity.Livro;

public class LivroDAO implements IDAO<Livro> {
    @Override
    public void cadastrar(Livro livro){
        String sql = "INSERT INTO Livros (titulo, autor, emprestado) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = DBConfig.getConnection().prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setString(2, livro.getAutor());
            pstmt.setBoolean(3, livro.isEmprestado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    @Override
    public void devolver(Livro livro) {
        String sql = "UPDATE Livros SET emprestado = false WHERE id = ?";
        try (PreparedStatement pstmt = DBConfig.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, livro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
    }

    @Override
    public Livro emprestar(int id) throws SQLException  {
        String sql = "UPDATE Livros SET emprestado = true WHERE id = ?";
        PreparedStatement pstmt = DBConfig.getConnection().prepareStatement(sql);
        pstmt.setInt(1, id);
        pstmt.executeUpdate();

        return buscar(id);
    }

    @Override
    public List<Livro> listar()  {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livros";
        try (Statement stmt = DBConfig.getConnection().createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String titulo = rs.getString("titulo");
                    String autor = rs.getString("autor");
                    boolean emprestado = rs.getBoolean("emprestado");
                    livros.add(new Livro(id, titulo, autor, emprestado));
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        return livros;
    }

    @Override
    public Livro buscar(int id) {
        String sql = "SELECT * FROM Livros WHERE id = ?";
        try (PreparedStatement pstmt = DBConfig.getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor");
                boolean emprestado = rs.getBoolean("emprestado");
                return new Livro(id, titulo, autor, emprestado);
            } else {
                return null;
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
    }
}
