/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Order;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpSession;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class AccountModel {
    public static boolean CheckUrl(HttpSession session){
        if(session.getAttribute("user")!=null){
            return true;
        }else return false;
    }
}
