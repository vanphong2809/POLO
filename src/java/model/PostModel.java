/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Post;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionDB;

/**
 *
 * @author Win 10
 */
public class PostModel {
    public List<Post> getAllPost(){
        Connection conn=null;
        CallableStatement callSt=null;
        ArrayList<Post> list=new ArrayList<Post>();
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getAllPost()}");
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){
                Post p=new Post();
                p.setPostId(rs.getInt("PostId"));
                p.setPostTitle(rs.getString("PostTitle"));
                p.setContent(rs.getString("Content"));
                p.setStatus(rs.getBoolean("Status"));
                p.setDisplayNumber(rs.getInt("DisplayNumber"));
                if (rs.getDate("Created") != null) {
                    p.setCreated(fomat.format(rs.getDate("Created")));
                }
                p.setContentDetail(rs.getString("ContentDetail"));
                p.setImages(rs.getString("Images"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return list;
    }
    public Post getPostById(int postId){
        Connection conn=null;
        CallableStatement callSt=null;
        SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
        Post p=new Post();
        try {
            conn=ConnectionDB.openConnect();
            callSt=conn.prepareCall("{call getPostById(?)}");
            callSt.setInt(1, postId);
            ResultSet rs=callSt.executeQuery();
            while(rs.next()){               
                p.setPostId(rs.getInt("PostId"));
                p.setPostTitle(rs.getString("PostTitle"));
                p.setContent(rs.getString("Content"));
                p.setStatus(rs.getBoolean("Status"));
                p.setDisplayNumber(rs.getInt("DisplayNumber"));
                if (rs.getDate("Created") != null) {
                    p.setCreated(fomat.format(rs.getDate("Created")));
                }
                p.setContentDetail(rs.getString("ContentDetail"));
                p.setImages(rs.getString("Images"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnect(conn, callSt);
        }
        return p;
    }
}
