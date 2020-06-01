/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.ImageLink;
import entity.Product;
import entity.ProductColor;
import entity.ProductSize;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class ProductModel {

    //them san pham
    public boolean insertProduct(Product p) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call insertProduct(?,?,?,?,?,?,?,?,?,?,?)}");
            callSt.setString(1, p.getProductName());
            callSt.setString(2, p.getProductContent());
            callSt.setString(3, p.getProductContentDetail());
            callSt.setString(4, p.getImages());
            callSt.setInt(5, p.getPriceInput());
            callSt.setInt(6, p.getPriceOutput());
            callSt.setInt(7, p.getQuantity());
            callSt.setInt(8, p.getCatalogId());
            callSt.setInt(9, p.getProviderId());
            callSt.setString(10, p.getImageHover());
            callSt.setInt(11, p.getDiscount());
            callSt.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return check;
    }

    // lay ra tat ca san pham
    public List<Product> getAllProduct() {
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<Product> list = new ArrayList<Product>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getAllProduct()}");
            ResultSet rs = callSt.executeQuery();
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
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    //lay ra 8 san pham co luong mua lon nhat
    public List<Product> getProductHot() {
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<Product> list = new ArrayList<Product>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductHot()}");
            ResultSet rs = callSt.executeQuery();
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
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    //la ra 8 san pham moi nhat
    public List<Product> getProductNew() {
        ArrayList<Product> list = new ArrayList<Product>();
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductNew()}");
            ResultSet rs = callSt.executeQuery();
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
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    //Lay ra tat ca san pham co khuyen mai
    public List<Product> getProductDiscount() {
        ArrayList<Product> list = new ArrayList<Product>();
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductDiscount()}");
            ResultSet rs = callSt.executeQuery();
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
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    //Lay san pham theo danh muc
    public List<Product> getProductByCatalogId(int catalogId) {
        ArrayList<Product> list = new ArrayList<Product>();
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductByCatalogId(?)}");
            callSt.setInt(1, catalogId);
            ResultSet rs = callSt.executeQuery();
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
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }

    //Lay san pham theo nha cung cap
    public List<Product> getProductByProviderId(int providerId) {
        ArrayList<Product> listProduct = new ArrayList<Product>();
        Connection conn = null;
        CallableStatement callSt = null;
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductByProviderId(?)}");
            callSt.setInt(1, providerId);
            ResultSet rs = callSt.executeQuery();
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
            ConnectionDB.closeConnect(conn, callSt);
        }
        return listProduct;
    }

    //Lay san pham theo id
    public Product getProductById(int productId) {
        Connection conn = null;
        CallableStatement callSt = null;
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Product p = new Product();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductById(?)}");
            callSt.setInt(1, productId);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return p;
    }

    //Lay nhung san pham co lien quan
    public List<Product> getProductRelated(Product pro) {
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement calla = null;
        List<Product> list = new ArrayList<Product>();
        ResultSet rs;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{ call getProductRelated(?,?)}");
            calla.setInt(1, pro.getCatalogId());
            calla.setInt(2, pro.getProductId());
            rs = calla.executeQuery();
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
                list.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return list;
    }

    //Lay danh sach anh de hien thi trong slide cua san pham
    public List<ImageLink> getImageLink(int id) {
        ArrayList<ImageLink> listImageLink = new ArrayList<ImageLink>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getImageLink(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ImageLink il = new ImageLink();
                il.setImageLinkId(rs.getInt("ImageLinkId"));
                il.setImageLinkName(rs.getString("ImageLinkName"));
                il.setProductId(rs.getInt("ProductId"));
                il.setStatus(rs.getBoolean("Status"));
                il.setPurpose(rs.getInt("Purpose"));
                listImageLink.add(il);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return listImageLink;
    }
    //Lay danh sach anh de hien thi trong mo ta san pham

    public List<ImageLink> getImageLinkDetail(int id) {
        ArrayList<ImageLink> listImageLink = new ArrayList<ImageLink>();
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getImageLink1(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ImageLink il = new ImageLink();
                il.setImageLinkId(rs.getInt("ImageLinkId"));
                il.setImageLinkName(rs.getString("ImageLinkName"));
                il.setProductId(rs.getInt("ProductId"));
                il.setStatus(rs.getBoolean("Status"));
                il.setPurpose(rs.getInt("Purpose"));
                listImageLink.add(il);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return listImageLink;
    }

    //lay tat ca mau sac cua san pham
    public List<ProductColor> getProductColor(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        ArrayList<ProductColor> listProductColor = new ArrayList<ProductColor>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductColor(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ProductColor pc = new ProductColor();
                pc.setProductColorId(rs.getInt("ProductColorId"));
                pc.setProductId(rs.getInt("ProductId"));
                pc.setColorId(rs.getInt("ColorId"));
                pc.setColorName(rs.getString("ColorName"));
                pc.setNatation(rs.getString("Natation"));
                pc.setStatus(rs.getBoolean("Status"));
                listProductColor.add(pc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return listProductColor;
    }

    //lay tat ca size cua san pham
    public List<ProductSize> getProductSize(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        ArrayList<ProductSize> listProductSize = new ArrayList<ProductSize>();
        try {
            conn = ConnectionDB.openConnect();
            callSt = conn.prepareCall("{call getProductSize(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            while (rs.next()) {
                ProductSize ps = new ProductSize();
                ps.setProductSizeId(rs.getInt("ProductSizeId"));
                ps.setSizeId(rs.getInt("SizeId"));
                ps.setSizeName(rs.getString("SizeName"));
                ps.setProductId(rs.getInt("ProductId"));
                ps.setStatus(rs.getBoolean("Status"));
                listProductSize.add(ps);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnect(conn, callSt);
        }
        return listProductSize;
    }

    public List<Product> searchProduct(String name) {
        Connection conn = null;
        CallableStatement calla = null;
        ArrayList<Product> listProduct = new ArrayList<Product>();
        ResultSet rs;
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{ call search(?)}");
            calla.setString(1, name);
            rs = calla.executeQuery();
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
            ConnectionDB.closeConnect(conn, calla);
        }
        return listProduct;
    }

    public boolean updateProduct(Product product) throws ParseException {
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Connection conn = null;
        CallableStatement calla = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnect();
            calla = conn.prepareCall("{call UpdateProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            calla.setInt(1, product.getProductId());
            calla.setString(2, product.getProductName());
            calla.setString(3, product.getProductContent());
            calla.setString(4, product.getProductContentDetail());
            calla.setString(5, product.getImages());
            calla.setFloat(6, product.getPriceInput());
            calla.setFloat(7, product.getPriceOutput());
            calla.setInt(8, product.getQuantity());
            calla.setInt(9, product.getCatalogId());
            calla.setInt(10, product.getProviderId());
            calla.setString(11, product.getCreated());
            calla.setString(12, product.getImageHover());
            calla.setBoolean(13, product.isStatus()); 
            calla.setInt(14, product.getDiscount());           
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductModel.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnect(conn, calla);
        }
        return result;
    }
}
