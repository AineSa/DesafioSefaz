/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Aine
 */
public class AcessoBD {
      public static Connection conectar(){
      Connection con = null;
      try {
           Class.forName("org.h2.Driver");
           String url = "jdbc:h2:~/test";
           String user = "admin";
           String password = "admin";
           con = DriverManager.getConnection(url, user, password);  
      } catch (Exception e){
           e.printStackTrace();{
      }
      return con;
      }
          return null;
      }
}

 
    

