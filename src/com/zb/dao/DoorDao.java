package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoorDao {
    public List<Door> findAll() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Door> list = new ArrayList<>();
        while(rs.next()){
            Door door = new Door();
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));
            list.add(door);
        }
        System.out.println(list);
        return list;
    }
    public void addDoor(Door door) throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_door values(null,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,door.getName());
        ps.setString(2,door.getTel());
        ps.setString(3,door.getAddr());
        ps.executeUpdate();
        DBUtils.close(conn);
    }
    public List<Door> showSale(){
        try {
            Connection connection = DBUtils.getConnectionByDatasource();
            String sql = "select name,sale from tb_door";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Door door = null;
            List<Door> list = new ArrayList<>();
            while (rs.next()){
                door = new Door();
                door.setName(rs.getString("name"));
                door.setSale(rs.getInt("sale"));
                list.add(door);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
