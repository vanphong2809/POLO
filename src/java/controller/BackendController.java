/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Catalog;
import entity.Color;
import entity.Group;
import entity.Order;
import entity.Post;
import entity.Product;
import entity.ProductColor;
import entity.Provider;
import entity.Size;
import entity.User;
import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import model.AccountModel;
import model.CatalogModel;
import model.ColorModel;
import model.GroupModel;
import model.OrderModel;
import model.PostModel;
import model.ProductModel;
import model.ProviderModel;
import model.SizeModel;
import model.UserModel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.CheckEmail;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
@Controller
public class BackendController {

    private ProductModel productModel;
    private ProviderModel providerModel;
    private CatalogModel catalogModel;
    private ColorModel colorModel;
    private SizeModel sizeModel;
    private UserModel userModel;
    private GroupModel groupModel;
    private CheckEmail checkEmail;
    private OrderModel orderModel;
    private PostModel postModel;

    public BackendController() {
        productModel = new ProductModel();
        providerModel = new ProviderModel();
        catalogModel = new CatalogModel();
        colorModel = new ColorModel();
        sizeModel = new SizeModel();
        userModel = new UserModel();
        groupModel = new GroupModel();
        checkEmail = new CheckEmail();
        orderModel = new OrderModel();
        postModel = new PostModel();
    }

    @RequestMapping(value = "InsertProduct", method = RequestMethod.GET)
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

    @RequestMapping(value = "InsertProduct", method = RequestMethod.POST)
    public String insertProduct(@ModelAttribute("newProduct") Product product, ModelMap mm, HttpServletRequest request) throws FileUploadException {
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

                        img.add(fileItem.getName());
                    }

                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("productName")) {
                        product.setProductName(value);
                    } else if (name.equals("productContent")) {
                        product.setProductContent(value);
                    } else if (name.equals("productContentDetail")) {
                        product.setProductContentDetail(value);
                    } else if (name.equals("priceInput")) {
                        product.setPriceInput(Integer.parseInt(value));
                    } else if (name.equals("priceOutput")) {
                        product.setPriceOutput(Integer.parseInt(value));
                    } else if (name.equals("providerId")) {
                        product.setProviderId(Integer.parseInt(value));
                    } else if (name.equals("catalogId")) {
                        product.setCatalogId(Integer.parseInt(value));
                    } else if (name.equals("discount")) {
                        product.setDiscount(Integer.parseInt(value));
                    } else if (name.equals("quantity")) {
                        product.setQuantity(Integer.parseInt(value));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean check = productModel.insertProduct(product);

        if (check) {
            return "redirect:HomeBackend.htm";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertProduct";
        }
    }

//    lay toan bo danh muc
    @RequestMapping(value = "/AllCatalog")
    public ModelAndView GetAllCatalog(HttpSession session) {
        ModelAndView model;
        if (AccountModel.CheckUrl(session)) {
            model = new ModelAndView("Admin/Catalog");
            List<Catalog> list = catalogModel.getAllCatalog();
            model.getModelMap().put("listCatalog", list);
        } else {
            model = new ModelAndView("Admin/Login");
            User user = new User();
            model.getModelMap().put("user", user);
        }
        return model;
    }

    @RequestMapping(value = "InsertCatalog", method = RequestMethod.GET)
    public ModelAndView initInsertCatalog(HttpSession session) {
        ModelAndView model;
        if (AccountModel.CheckUrl(session)) {
            model = new ModelAndView("Admin/InsertCatalog");
            Catalog catalog = new Catalog();
            List<Catalog> list = catalogModel.getAllCatalog();
            model.getModelMap().put("listCatalog", list);
            model.getModelMap().put("newCatalog", catalog);
        } else {
            model = new ModelAndView("Admin/Login");
            User user = new User();
            model.getModelMap().put("user", user);
        }
        return model;
    }

    @RequestMapping(value = "InsertCatalog", method = RequestMethod.POST)
    public String InsertCatalog(@ModelAttribute("newCatalog") Catalog catalog, ModelMap mm, HttpServletRequest request) {
        String path = request.getRealPath("/jsp/Fontend/images/");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\jsp\\Fontend\\images";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload uploader = new ServletFileUpload(factory);
        try {
            List<FileItem> lst = uploader.parseRequest(request);
            for (FileItem fileItem : lst) {
                if (fileItem.isFormField() == false) {
                    //path
                    catalog.setImages(fileItem.getName());
                    //upload to folder
                    fileItem.write(new File(path + "/" + fileItem.getName()));
                } else {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString();
                    if (name.equals("catalogName")) {
                        catalog.setCatalogName(value);
                    } else if (name.equals("descriptions")) {
                        catalog.setDescriptions(value);
                    } else if (name.equals("parentID")) {
                        catalog.setParentId(Integer.parseInt(value));
                    } else if (name.equals("displayNumber")) {
                        catalog.setDisplayNumber(Integer.parseInt(value));
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        boolean check = catalogModel.insertCatalog(catalog);
        if (check) {
            return "redirect:AllCatalog.htm";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertCatalog";
        }
    }

    @RequestMapping(value = "AllProduct")
    public ModelAndView GetAllProduct(HttpSession session) {
        ModelAndView model;
        int productId;
        if (AccountModel.CheckUrl(session)) {
            model = new ModelAndView("Admin/Product");
            List<Product> list = productModel.getAllProduct();
//            List<Color> listColor = new ArrayList<>();
//            String arr[]=new String[list.size()];
//            for (int i = 0; i < list.size(); i++) {
//                arr[i]=list.get(i).getProductId();
//                listColor=colorModel.GetColorByProductId(productId);
//            }
//
//            int j=0;
//            for (Product p : list) {
//                arr[j]=colorModel.GetColorByProductId(list.get(j).getProductId()).toString();
//                j++;
//            }
//            model.getModelMap().put("listColor", arr);
            model.getModelMap().put("listProduct", list);

            return model;
        } else {
            model = new ModelAndView("Admin/Login");
            User user = new User();
            model.getModelMap().put("user", user);
        }
        return model;
    }

    @RequestMapping(value = "deleteCatalog")
    public String deleteCatalog(HttpSession session, @RequestParam("Id") int id) {
//        ModelAndView model;
        boolean check = false;

//            model = new ModelAndView("Admin/AllCatalog");
        check = catalogModel.deleteCatalog(id);
        if (check) {
            return "redirect:AllCatalog.htm";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "AllColor")
    public ModelAndView GetAllColor(HttpSession session) {
        ModelAndView model;
        if (AccountModel.CheckUrl(session)) {
            model = new ModelAndView("Admin/Color");
            List<Color> list = colorModel.GetAllColor();
            model.getModelMap().put("listColor", list);
        } else {
            model = new ModelAndView("Admin/Login");
            User user = new User();
            model.getModelMap().put("user", user);
        }
        return model;
    }

    @RequestMapping(value = "InsertColor", method = RequestMethod.GET)
    public ModelAndView InitInsertColor(HttpSession session) {
        ModelAndView model;
        if (AccountModel.CheckUrl(session)) {
            model = new ModelAndView("Admin/InsertColor");
            Color color = new Color();
            model.getModelMap().put("newColor", color);
        } else {
            model = new ModelAndView("Admin/Login");
            User user = new User();
            model.getModelMap().put("user", user);
        }
        return model;
    }

    @RequestMapping(value = "InsertColor", method = RequestMethod.POST)
    public String InserColor(@ModelAttribute("newColor") Color color, ModelMap mm) {
        boolean check = colorModel.InsertColor(color);
        if (check) {
            return "redirect:AllColor.htm";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertColor";
        }
    }

    @RequestMapping(value = "AllSize")
    public ModelAndView GetAllSize() {
        ModelAndView model = new ModelAndView("Admin/Size");
        List<Size> list = sizeModel.GetAllSize();
        model.getModelMap().put("listSize", list);
        return model;
    }

    @RequestMapping(value = "InsertSize", method = RequestMethod.GET)
    public ModelAndView InitInsertSize() {
        ModelAndView model = new ModelAndView("Admin/InsertSize");
        Size size = new Size();
        model.getModelMap().put("newSize", size);
        return model;
    }

    @RequestMapping(value = "InsertSize", method = RequestMethod.POST)
    public String InsertSize(@ModelAttribute("newSize") Size size, ModelMap mm) {
        boolean check = sizeModel.InsertSize(size);
        if (check) {
            return "redirect:AllSize.htm";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertSize";
        }
    }

    @RequestMapping(value = "AllUser")
    public ModelAndView GetAllUser() {
        ModelAndView model = new ModelAndView("Admin/User");
        List<User> list = userModel.GetAllUser();
        model.getModelMap().put("listUser", list);
        return model;
    }

    @RequestMapping(value = "InsertUser", method = RequestMethod.GET)
    public ModelAndView InitInsertUser() {
        ModelAndView model = new ModelAndView("Admin/InsertUser");
        User user = new User();
        List<Group> list = groupModel.GetAllGroup();
        model.getModelMap().put("newUser", user);
        model.getModelMap().put("listGroup", list);
        return model;
    }

    @RequestMapping(value = "InsertUser", method = RequestMethod.POST)
    public String InsertUser(@ModelAttribute("newUser") User user, ModelMap mm, HttpServletRequest request) {
        boolean check = userModel.InsertUser(user);
        String email = request.getParameter("email");
        if (check) {
            return "redirect:AllUser.htm";
        } else if (checkEmail.checkEmailExist(email) == 0) {
            mm.put("message", "Email đã được dùng. Vui lòng điền email khác để đăng ký");
            return "Admin/InsertUser";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertUser";
        }
    }

    @RequestMapping(value = "AllGroup")
    public ModelAndView GetAllGroup() {
        ModelAndView model = new ModelAndView("Admin/Group");
        List<Group> list = groupModel.GetAllGroup();
        model.getModelMap().put("listGroup", list);
        return model;
    }

    @RequestMapping(value = "InsertGroup", method = RequestMethod.GET)
    public ModelAndView InitInsertGroup() {
        ModelAndView model = new ModelAndView("Admin/InsertGroup");
        Group group = new Group();
        model.getModelMap().put("newGroup", group);
        return model;
    }

    @RequestMapping(value = "InsertGroup", method = RequestMethod.POST)
    public String InsertGroup(@ModelAttribute("newGroup") Group group, ModelMap mm) {
        boolean check = groupModel.InsertGroup(group);
        if (check) {
            return "redirect:AllGroup";
        } else {
            mm.put("message", "Thêm mới không thành công");
            return "Admin/InsertGroup";
        }
    }

    @RequestMapping(value = "AllOrder")
    public ModelAndView GetAllOrder() {
        ModelAndView model = new ModelAndView("Admin/Order");
        List<Order> list = orderModel.GetAllOrder();
        model.getModelMap().put("listOrder", list);
        return model;
    }

    @RequestMapping(value = "UpdateCatalog", method = RequestMethod.GET)
    public ModelAndView InitUpdateCatalog(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Admin/UpdateCatalog");
        Catalog catalog = catalogModel.GetCatalogById(id);
        List<Catalog> catalogs = catalogModel.getAllCatalog();
        model.getModelMap().put("updateCatalog", catalog);
        model.getModelMap().put("listCatalog", catalogs);
        return model;
    }

    @RequestMapping(value = "UpdateCatalog", method = RequestMethod.POST)
    public String UpdateCatalog(@ModelAttribute("updateCatalog") Catalog catalog, ModelMap mm) {

        boolean result = false;
        result = catalogModel.updateCatalog(catalog);
        if (result) {
            return "redirect:AllCatalog.htm";
        } else {
            mm.put("message", "Sửa thẻ không thành công.");
            return "Admin/UpdateCatalog";
        }
    }

    @RequestMapping(value = "UpdateProduct", method = RequestMethod.GET)
    public ModelAndView InitUpdateProduct(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Admin/UpdateProduct");
        Product product = productModel.getProductById(id);
        List<Provider> list = providerModel.getAllProvider();
        List<Catalog> listCata = catalogModel.getAllCatalog();
        model.getModelMap().put("updateProduct", product);
        model.getModelMap().put("listProvider", list);
        model.getModelMap().put("listCatalog", listCata);
        return model;
    }

    @RequestMapping(value = "UpdateProduct", method = RequestMethod.POST)
    public String UpdateProduct(@ModelAttribute("updateProduct") Product product, ModelMap mm) throws ParseException {
        boolean result = false;
        result = productModel.updateProduct(product);
        if (result) {
            return "redirect:AllProduct.htm";
        } else {
            mm.put("message", "Sửa thẻ không thành công.");
            return "Admin/UpdateProduct";
        }
    }

    @RequestMapping(value = "UpdateColor", method = RequestMethod.GET)
    public ModelAndView InitUpdateColor(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Admin/UpdateColor");
        Color color = colorModel.GetColorById(id);
        model.getModelMap().put("updateColor", color);
        return model;
    }

    @RequestMapping(value = "UpdateColor", method = RequestMethod.POST)
    public String UpdateColor(@ModelAttribute("updateColor") Color color, ModelMap mm) throws ParseException {
        boolean result = false;
        result = colorModel.updateColor(color);
        if (result) {
            return "redirect:AllColor.htm";
        } else {
            mm.put("message", "Sửa thẻ không thành công.");
            return "Admin/UpdateColor";
        }
    }

    @RequestMapping(value = "UpdateSize", method = RequestMethod.GET)
    public ModelAndView InitUpdateSize(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Admin/UpdateSize");
        Size size = sizeModel.GetSizeById(id);
        model.getModelMap().put("updateSize", size);
        return model;
    }

    @RequestMapping(value = "UpdateSize", method = RequestMethod.POST)
    public String UpdateColor(@ModelAttribute("updateSize") Size size, ModelMap mm) throws ParseException {
        boolean result = false;
        result = sizeModel.updateSize(size);
        if (result) {
            return "redirect:AllSize.htm";
        } else {
            mm.put("message", "Sửa thẻ không thành công.");
            return "Admin/UpdateSize";
        }
    }

    @RequestMapping(value = "UpdateUser", method = RequestMethod.GET)
    public ModelAndView InitUpdateUser(@RequestParam("Id") int id) {
        ModelAndView model = new ModelAndView("Admin/UpdateUser");
        User user = userModel.GetUserById(id);
        List<Group> list = groupModel.GetAllGroup();
        model.getModelMap().put("newUser", user);
        model.getModelMap().put("listGroup", list);
        model.getModelMap().put("updateUser", user);
        return model;
    }

    @RequestMapping(value = "UpdateUser", method = RequestMethod.POST)
    public String UpdateColor(@ModelAttribute("updateUser") User user, ModelMap mm) throws ParseException {
        boolean result = false;
        result = userModel.updateUser(user);

        if (result) {
            return "redirect:AllUser.htm";
        } else {
            mm.put("message", "Sửa thẻ không thành công.");
            return "Admin/UpdateUser";
        }
    }

    @RequestMapping(value = "deleteProduct")
    public String deleteProduct(HttpSession session, @RequestParam("Id") int id) {
        boolean check = false;
        check = productModel.deleteProduct(id);
        if (check) {
            return "redirect:AllProduct.htm";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "deleteColor")
    public String deleteColor(HttpSession session, @RequestParam("Id") int id) {
        boolean check = false;
        check = colorModel.deleteColor(id);
        if (check) {
            return "redirect:AllColor.htm";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "deleteSize")
    public String deleteSize(HttpSession session, @RequestParam("Id") int id) {
        boolean check = false;
        check = sizeModel.deleteSize(id);
        if (check) {
            return "redirect:AllSize.htm";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "deleteUser")
    public String deleteUser(HttpSession session, @RequestParam("Id") int id) {
        boolean check = false;
        check = userModel.deleteUser(id);
        if (check) {
            return "redirect:AllUser.htm";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "deleteGroup")
    public String deleteGroup(HttpSession session, @RequestParam("Id") int id) {
        boolean check = false;
        check = groupModel.deleteGroup(id);
        if (check) {
            return "redirect:AllGroup.htm";
        } else {
            return "error";
        }

    }

    @RequestMapping(value = "getAllPost")
    public ModelAndView getAllPost() {
        ModelAndView model = new ModelAndView("Admin/Post");
        List<Post> list = postModel.getAllPost();
        model.getModelMap().put("listPost", list);
        return model;
    }
}
