/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.modelo.Usuario;
import java.sql.SQLException;
import javax.inject.Named;

/**
 *
 * @author Aine
 */
@Named("UsuarioDao")

public class UsuarioDao {
    private Usuario usuario = new Usuario();
    
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
 
    private final String SELECT=" SELECT * FROM USUARIO ";
    private final String INSERT=" INSERT INTO USUARIO(NOME,EMAIL,SENHA) VALUES (?,?,?) ";
    private final String UPDATE=" UPDATE USUARIO SET NOME = ?,EMAIL = ? WHERE SENHA = ? ";
    private final String DELETE=" DELETE FROM USUARIO WHERE EMAIL = ? ";
 
    /**
     * metodo seleciona registros de USUARIO
     * @return
     * @throws java.sql.SQLException
     */
    public List selecionar() throws SQLException{
        List Usuario = new ArrayList();
        Usuario emp=null;
        try {
            conn=AcessoBD.conectar();
            pstm=conn.prepareStatement(SELECT);
            rs=pstm.executeQuery();
 
            while(rs.next()){
                emp = new Usuario();
                emp.setNome(rs.getString("Nome"));
                emp.setEmail(rs.getString("Email"));
                emp.setSenha(rs.getString("Senha"));
                Usuario.add(emp);
            }
 
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro, causa:"+e.getMessage());
        }finally{
            rs.close();
            pstm.close();
            conn.close();
        }
 
        return Usuario;
    }
 
    /**
     * faz a inserção de USUARIO
     * @param emp
     * @throws java.sql.SQLException
     */
    public void inserir(Usuario emp) throws SQLException{
        try {
            conn=AcessoBD.conectar();
            pstm=conn.prepareStatement(INSERT);
            pstm.setString(1, emp.getNome());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getSenha());
 
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro, causa:"+e.getMessage());
        }finally{
            rs.close();
            pstm.close();
            conn.close();
        }
    }
 
    /**
     * faz a atualização de USUARIO
     * @param emp
     * @throws java.sql.SQLException
     */
    public void atualizar(Usuario emp) throws SQLException{
        try {
            conn=AcessoBD.conectar();
            pstm=conn.prepareStatement(UPDATE);
            pstm.setString(1, emp.getNome());
            pstm.setString(2, emp.getEmail());
            pstm.setString(3, emp.getSenha());
 
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro, causa:"+e.getMessage());
        }finally{
            rs.close();
            pstm.close();
            conn.close();
        }
    }
 
    /**
     * faz a exclusão de Usuario
     * @param Nome
     * @throws java.sql.SQLException
     */
    public void excluir(String Nome) throws SQLException{
        try {
            conn=AcessoBD.conectar();
            pstm=conn.prepareStatement(DELETE);
            pstm.setString(1, Nome);
 
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Ocorreu um erro, causa:"+e.getMessage());
        }finally{
            rs.close();
            pstm.close();
            conn.close();
        }
    }
    public Usuario getUsuario() {
          return usuario;
     }
      
     public void setUsuario(Usuario usuario) {
          this.usuario = usuario;
     }

}
    

