/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senai.app;

import br.com.senai.bll.UserBll;
import br.com.senai.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Elisabete
 */
public class CadUserDesk {

    /**
     * @param args the command line arguments
     */
    private static Date createNewDate(int day, int month, int year) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse("" + day + "/" + month + "/" + year);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) throws ParseException, Exception {
        // TODO code application logic here
        User usuario = new User();
        UserBll user = new UserBll();
        /*
        usuario.setFirstName("Elisabete");
        usuario.setLastName("Hato");
        usuario.setDob(createNewDate(27,02,2014));
        usuario.setEmail("bete.cmp@gmail.com");        
        user.Adicionar(usuario);
        
        usuario.setUserid(10);
        usuario.setFirstName("Elisabete Tie");
        usuario.setLastName("Hato");
        usuario.setDob(createNewDate(27,02,2014));
        usuario.setEmail("bete.cmp@gmail.com");
        user.Alterar(usuario);
                
        user.Remover(user.getConsultaPorId(10));
        */
        System.out.println(user.getConsulta());
        
    }
    
}
