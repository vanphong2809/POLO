/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.User;
import javax.servlet.http.HttpSession;
import model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Win 10
 */
@Controller
public class AccountController {
    private UserModel userModel;

    public AccountController() {
        userModel=new UserModel();
    }
    
    @RequestMapping(value="/account")
    public ModelAndView account(HttpSession session){
        ModelAndView model=new ModelAndView("Fontend/Account");
        String email=(String) session.getAttribute("account");
        System.out.println(email+" leu leu");
        User userAct=userModel.getUserByEmail(email);
        model.getModelMap().put("accountAct", userAct);
        return model;
    }
}
