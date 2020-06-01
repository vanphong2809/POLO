/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Catalog;
import entity.Color;
import entity.ImageLink;
import entity.New;
import entity.Post;
import entity.Product;
import entity.ProductColor;
import entity.ProductSize;
import entity.Provider;
import entity.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import model.CatalogModel;
import model.ColorModel;
import model.NewModel;
import model.PaginationModel;
import model.PostModel;
import model.ProductModel;
import model.ProviderModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
@Controller
public class FontendController {
    private ProductModel productModel;
    private CatalogModel catalogModel;
    private ProviderModel providerModel;
    private PaginationModel paginationModel;
    private PostModel postModel;
    private ColorModel colorModel;
    public FontendController() {
        productModel=new ProductModel();
        catalogModel = new CatalogModel();
        providerModel = new ProviderModel();
        paginationModel = new PaginationModel();
        postModel = new PostModel();
        colorModel=new ColorModel();
    }
    @RequestMapping(value="getAllProduct")
    public ModelAndView getAllProduct(@RequestParam(value="page", defaultValue = "1") String page){
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        ModelAndView model=new ModelAndView("Fontend/Product");
        int pageInt = Integer.parseInt(page);
        int sizeRowofPage=2;
        HashMap map=paginationModel.getDataPagination(pageInt, sizeRowofPage);        
        List<Catalog> listCatalog=catalogModel.getAllCatalog();
        List<Provider> listProvider=providerModel.getAllProvider();
        List<Product> listProduct = new ArrayList<>();
        String url = (String) map.get("url");//chuỗi phân trang
        try {
            ResultSet rs = (ResultSet) map.get("rs");
            while (rs.next()) {
               Product p = new Product();
                p.setProductId(rs.getInt("ProductId"));
                p.setProductName(rs.getString("ProductName"));
                p.setProductContent(rs.getString("ProductContent"));
                p.setProductContentDetail(rs.getString("ProductContentDetail"));
                p.setImages(rs.getString("Images"));
                p.setView(rs.getInt("View"));
                p.setBuyItem(rs.getInt("BuyItem"));
                p.setPriceInput(rs.getInt("PriceInput"));
                p.setPriceOutput(rs.getInt("PriceOutput"));
                p.setQuantity(rs.getInt("Quantity"));
                p.setCatalogId(rs.getInt("CatalogId"));
                p.setProviderId(rs.getInt("ProviderId"));
                if (rs.getDate("Created") != null) {
                    p.setCreated(fomat.format(rs.getDate("Created")));
                }
                p.setStatus(rs.getBoolean("Status"));
                p.setImageHover(rs.getString("ImageHover"));
                p.setDiscount(rs.getInt("Discount"));
                p.setPriceDiscount((rs.getInt("PriceOutput") * (100 - rs.getInt("Discount"))) / 100);
                listProduct.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Connection conn = (Connection) map.get("conn");
            CallableStatement callSt = (CallableStatement) map.get("callSt");
            ConnectionDB.closeConnect(conn, callSt);
        }
        model.getModelMap().put("listCatalog", listCatalog);
        model.getModelMap().put("listProvider", listProvider);
        model.getModelMap().put("listProduct", listProduct);
        model.getModelMap().put("url", url);
        return model;
    }
//    @RequestMapping(value = "getDataPagging")
//    public ModelAndView getDataProductPagging(@RequestParam("page") String page) {
//        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
//        ModelAndView model = new ModelAndView("Fontend/Product");
//        int pageInt = Integer.parseInt(page);
//        int sizeRowofPage = 2;// số sản phẩm trên 1 trang
//        HashMap map1 = paginationModel.getDataPagination(pageInt, sizeRowofPage);
//        List<Catalog> listCatalog=catalogModel.getAllCatalog();
//        List<Provider> listProvider=providerModel.getAllProvider();
//        String url = (String) map1.get("url");
//        List<Product> listProduct = new ArrayList<>();
//        try {
//            ResultSet rs = (ResultSet) map1.get("rs");
//            while (rs.next()) {
//                Product p = new Product();
//                p.setProductId(rs.getInt("ProductId"));
//                p.setProductName(rs.getString("ProductName"));
//                p.setProductContent(rs.getString("ProductContent"));
//                p.setProductContentDetail(rs.getString("ProductContentDetail"));
//                p.setImages(rs.getString("Images"));
//                p.setView(rs.getInt("View"));
//                p.setBuyItem(rs.getInt("BuyItem"));
//                p.setPriceInput(rs.getInt("PriceInput"));
//                p.setPriceOutput(rs.getInt("PriceOutput"));
//                p.setQuantity(rs.getInt("Quantity"));
//                p.setCatalogId(rs.getInt("CatalogId"));
//                p.setProviderId(rs.getInt("ProviderId"));
//                if (rs.getDate("Created") != null) {
//                    p.setCreated(fomat.format(rs.getDate("Created")));
//                }
//                p.setStatus(rs.getBoolean("Status"));
//                p.setImageHover(rs.getString("ImageHover"));
//                p.setDiscount(rs.getInt("Discount"));
//                p.setPriceDiscount((rs.getInt("PriceOutput") * (100 - rs.getInt("Discount"))) / 100);
//                listProduct.add(p);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            Connection conn = (Connection) map1.get("conn");
//            CallableStatement callSt = (CallableStatement) map1.get("callSt");
//            ConnectionDB.closeConnect(conn, callSt);
//        }
//        model.getModelMap().put("listCatalog", listCatalog);
//        model.getModelMap().put("listProduct", listProduct);
//        model.getModelMap().put("listProvider", listProvider);
//        model.getModelMap().put("url", url);
//        return model;
//    }
    @RequestMapping(value = "getProductByCatalog")
    public ModelAndView getProductByCatalog(@RequestParam("Id") int id){
        ModelAndView model=new ModelAndView("Fontend/Product");
        List<Product> listProduct=productModel.getProductByCatalogId(id);
        List<Catalog> listCatalog=catalogModel.getAllCatalog();
        List<Product> list=productModel.getAllProduct();
        model.getModelMap().put("listProductByCatalogId", listProduct);
        model.getModelMap().put("listCatalog", listCatalog);
        model.getModelMap().put("listProduct", list);
        return model;
    }
    @RequestMapping(value = "getProduct")
    public ModelAndView getProduct(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Fontend/AllProduct");
        List<Product> listProduct = productModel.getProductByCatalogId(id);
        model.getModelMap().put("listProduct", listProduct);
        return model;
    }
    @RequestMapping(value="getProductByProvider")
    public ModelAndView getProductByProvider(@RequestParam("Id") int id){
        ModelAndView model=new ModelAndView("Fontend/AllProduct");
        List<Product> listProduct=productModel.getProductByProviderId(id);
        model.getModelMap().put("listProduct", listProduct);
        return model;
    }
    
    @RequestMapping(value="productDetail")
    public ModelAndView getProductDetail(@RequestParam("Id") int id){
        ModelAndView model=new ModelAndView("Fontend/ProductDetail");
        Product product=productModel.getProductById(id);
        List<Product> listPrRe=productModel.getProductRelated(product);
        List<ImageLink> listImageLink=productModel.getImageLink(id);
        List<ImageLink> listImagelinkDetail=productModel.getImageLinkDetail(id);
        List<ProductColor> listProductColor=productModel.getProductColor(id);
        List<ProductSize> listProductSize=productModel.getProductSize(id);
        List<Catalog> listCatalog=catalogModel.getAllCatalog();
        model.getModelMap().put("product", product);
        model.getModelMap().put("listPrRe", listPrRe);
        model.getModelMap().put("imageLink", listImageLink);
        model.getModelMap().put("listImagelinkDetail", listImagelinkDetail);
        model.getModelMap().put("listProductColor", listProductColor);
        model.getModelMap().put("listProductSize", listProductSize);
        model.getModelMap().put("listCatalog", listCatalog);
        return model;
    }
    @RequestMapping(value = "about")
    public ModelAndView about(){
        ModelAndView model=new ModelAndView("Fontend/About");
        return model;
    }
    @RequestMapping(value="post")
    public ModelAndView newPost(){
        ModelAndView model=new ModelAndView("Fontend/New");
        List<Post> newPost=postModel.getAllPost();
        model.getModelMap().put("newPost", newPost);
        return model;
    }
   @RequestMapping(value="PostDetail")
   public ModelAndView postDetail(@RequestParam("Id") int id){
       ModelAndView model= new ModelAndView("Fontend/NewDetail");
       Post p=postModel.getPostById(id);
       model.getModelMap().put("postDetail", p);
       return model;
   }
}
