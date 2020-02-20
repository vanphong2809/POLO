/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Catalog;
import entity.Product;
import entity.Provider;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.CatalogModel;
import model.ProductModel;
import model.ProviderModel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Win 10
 */
@Controller
public class BackendController {

    private ProductModel productModel;
    private ProviderModel providerModel;
    private CatalogModel catalogModel;

    public BackendController() {
        productModel = new ProductModel();
        providerModel = new ProviderModel();
        catalogModel = new CatalogModel();
    }

    @RequestMapping(value = "initInsertProduct")
    public ModelAndView initInsertProduct() {
        ModelAndView model = new ModelAndView("Admin/InsertProduct");
        Product product = new Product();
        List<Provider> listProvider = providerModel.getAllProvider();
        List<Catalog> listCatalog = catalogModel.getAllCatalog();
        model.getModelMap().put("newProduct", product);
        model.getModel().put("listProvider", listProvider);
        model.getModelMap().put("listCatalog", listCatalog);
        return model;
    }

    @RequestMapping(value = "insertProduct")
    public String insertProduct(@ModelAttribute("/*newProduct") Product product, ModelMap mm, HttpServletRequest request) throws FileUploadException {
        List<String> img = new ArrayList<String>();
        String path = request.getRealPath("/jsp/Fontend/images/");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Fontend\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    if ("images".equals(fileItem.getFieldName())) {
                        product.setImages(fileItem.getName());
                    } else if ("imageHover".equals(fileItem.getFieldName())) {
                        product.setImageHover(fileItem.getName());
                    } else if ("imageLink".equals(fileItem.getFieldName())) {

                        img.add(fileItem.getName());
                    }

                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                }
                else{
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                     if(name.equals("productName")) {
                        product.setProductName(value);
                    } else if(name.equals("productContent")){
                        product.setProductContent(value);
                    } else if (name.equals("productContentDetail")){
                        product.setProductContentDetail(value);
                    } else if(name.equals("priceInput")){
                        product.setPriceInput(Integer.parseInt(value));
                    }else if(name.equals("priceOutput")){
                        product.setPriceOutput(Integer.parseInt(value));
                    }else if(name.equals("providerId")){
                        product.setProviderId(Integer.parseInt(value));
                    }else if(name.equals("catalogId")){
                        product.setCatalogId(Integer.parseInt(value));
                    }else if(name.equals("discount")){
                        product.setDiscount(Integer.parseInt(value));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean check = productModel.insertProduct(product);
        
        if (check) {
            return "redirect:initInsertProduct.htm";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Fontend/InsertProduct";
        }
    }
}
