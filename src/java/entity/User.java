/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Win 10
 */
public class User {
    private int userId;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String phone;
    private int groupId;
    private boolean status;
    private String created;
    Group group;
    public User() {
    }

    public User(int userId, String userName, String password, String email, String address, String phone, int groupId, boolean status, String created, Group group) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.groupId = groupId;
        this.status = status;
        this.created = created;
        this.group = group;
    }
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
    
}
