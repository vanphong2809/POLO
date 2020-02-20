/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Catalog;
import entity.Product;
import entity.Provider;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.CatalogModel;
import model.ProductModel;
import model.ProviderModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Win 10
 */
@Controller
public class SearchController {
    private ProductModel productModel;
    private CatalogModel catalogModel;
    private ProviderModel providerModel;

    public SearchController() {
        productModel=new ProductModel();
        catalogModel=new CatalogModel();
        providerModel=new ProviderModel();
    }
    @RequestMapping(value="/Search")
    public ModelAndView Search(HttpServletRequest request){
        ModelAndView model=new ModelAndView("Fontend/Product");
        List<Catalog> listCatalog=catalogModel.getAllCatalog();
        List<Provider> listProvider=providerModel.getAllProvider();
        String name=request.getParameter("query");
        List<Product> listProduct=productModel.searchProduct(name);
         model.getModelMap().put("listCatalog", listCatalog);
        model.getModelMap().put("listProvider", listProvider);
        model.getModelMap().put("listProduct", listProduct);
        return model;
    }
}
