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
public class Group {
    private int groupId;
    private String groupName;
    private boolean status;

    public Group() {
    }

    public Group(int groupId, String groupName, boolean status) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.status = status;
    }
    
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
