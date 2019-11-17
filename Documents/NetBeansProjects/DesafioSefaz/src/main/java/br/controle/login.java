/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controle;

import br.modelo.LoginDao;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
/**
 *
 * @author Aine
 */
@ManagedBean(name="LoginDao")
public class login {

    private final LoginDao usuario = new LoginDao();
    public String EfetuarLogin() {
    if(usuario.getUsuario() != null &&
       usuario.getSenha() != null) {
         return "\"/cadastro.xhtml?faces-redirect=true\";";
    }else{
      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
      FacesContext.getCurrentInstance().addMessage("erro", msg);
      return null;
    }
        


 
}
}