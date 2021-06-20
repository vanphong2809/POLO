/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DTO.RevenueStatistic;
import java.util.List;
import model.OrderModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@Controller
public class StatisticController {
    @RequestMapping(value="/revenueStatistic")
    public ModelAndView revenueStatistic(){
        ModelAndView model=new ModelAndView("Admin/revenueStatistics");
        return model;
    }
}
