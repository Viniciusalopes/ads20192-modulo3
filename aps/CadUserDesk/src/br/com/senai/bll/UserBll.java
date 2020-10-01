/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.senai.bll;

import br.com.senai.dal.UserDal;
import br.com.senai.model.User;
import java.util.List;

/**
 *
 * @author Elisabete
 */
public class UserBll {

    private static final long serialVersionUID = 1L;
    private UserDal dal;

    public UserBll() {
        super();
        dal = new UserDal();
    }
    
    public void Adicionar(User user) throws Exception{
        dal.addUser(user);
    }
    
    public void Alterar(User user) throws Exception{
        dal.updateUser(user);
    }
    
    public void Remover(User user) throws Exception{
        dal.deleteUser(user.getUserid());
    }
    
    public List<User> getConsulta(){
        return dal.getAllUsers();
    }
    
    public User getConsultaPorId(int UserId){
        return dal.getUserById(UserId);
    }
}
