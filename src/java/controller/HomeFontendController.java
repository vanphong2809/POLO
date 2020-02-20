/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Catalog;
import entity.Post;
import entity.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import model.CatalogModel;
import model.PostModel;
import model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Win 10
 */
@Controller
public class HomeFontendController {
    private ProductModel productModel;
    private CatalogModel catalogModel;
    private PostModel postModel;
    public HomeFontendController() {
        productModel=new ProductModel();
        catalogModel = new CatalogModel();
        postModel = new PostModel();
    }
    
    @RequestMapping(value = "/homeFontend")
    public ModelAndView homeFontend(){
        ModelAndView model = new ModelAndView("Fontend/index");
        Map<Integer,List<Catalog> > map = new HashMap<Integer, List<Catalog>> ();
        Map<Integer,List<Product> > mapPr = new HashMap<Integer, List<Product>> ();
        List<Product> productHot=productModel.getProductHot();
        List<Product> productNew=productModel.getProductNew();
        List<Product> productDiscount=productModel.getProductDiscount();
        List<Catalog> listCatalog=catalogModel.getAllCatalog();
        List<Post> listPost=postModel.getAllPost();
        model.getModelMap().put("map",map);
        model.getModelMap().put("mapPr",mapPr);
        model.getModelMap().put("productHot", productHot);
        model.getModelMap().put("productNew", productNew);
        model.getModelMap().put("productDiscount", productDiscount);
        model.getModelMap().put("listCatalog", listCatalog);
        model.getModelMap().put("listPost", listPost);
        return model;
    }
}
