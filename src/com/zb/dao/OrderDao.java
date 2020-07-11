package com.zb.dao;

import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {


    public List<Order> findAll() throws SQLException {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        Order order = null;
        List<Order> list = new ArrayList<>();
        while (rs.next()){
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setDoor_id(rs.getInt("door_id"));
            order.setOrder_no(rs.getString("order_no"));
            order.setOrder_type(rs.getString("order_type"));
            order.setPnum(rs.getInt("pnum"));
            order.setCashier(rs.getString("cashier"));
            order.setOrder_time(rs.getTimestamp("order_time"));
            order.setPay_time(rs.getTimestamp("pay_time"));
            order.setPay_type(rs.getString("pay_type"));
            order.setPrice(rs.getDouble("price"));
            list.add(order);
        }
//        System.out.println(list);
        DBUtils.close(conn);
        return list;
    }

    public void addOrder(Order order) throws SQLException {
        Timestamp order_time = new Timestamp(System.currentTimeMillis());
        Timestamp pay_time = new Timestamp(System.currentTimeMillis());
        Connection connection = DBUtils.getConnectionByDatasource();
//        String sql1 = "select id from tb_door where addr = ? ";
        String sql = "insert into tb_order values(null,(select id from tb_door where name=?),?,?,?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setInt(1,order.getDoor_id());
//        System.out.println(sql);
//        System.out.println("OrderDao"+order.getDoorname());
        ps.setString(1,order.getDoorname());
        ps.setString(2,order.getOrder_no());
        ps.setString(3,order.getOrder_type());
        ps.setInt(4,order.getPnum());
        ps.setString(5,order.getCashier());
        ps.setTimestamp(6,order_time);
        ps.setTimestamp(7,pay_time);
        ps.setString(8,order.getPay_type());
        ps.setDouble(9,order.getPrice());
        ps.executeUpdate();
        DBUtils.close(connection);
    }
    public void updateById(Order order) throws SQLException {
        Connection connection = null;
        connection  = DBUtils.getConnectionByDatasource();
        String sql = "update tb_order set door_id=?,order_no=?,order_type=?,pnum=?,cashier=?,order_time=?,pay_time=?,pay_type=?,price=? where id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,order.getDoor_id());
        ps.setString(2,order.getOrder_no());
        ps.setString(3,order.getOrder_type());
        ps.setInt(4,order.getPnum());
        ps.setString(5,order.getCashier());
        ps.setTimestamp(6,order.getOrder_time());
        ps.setTimestamp(7,order.getPay_time());
        ps.setString(8,order.getPay_type());
        ps.setDouble(9,order.getPrice());
        ps.setInt(10,order.getId());
        ps.executeUpdate();
        DBUtils.close(connection);
    }

    public Order findById(Integer id) {
        Order order = null;
        Connection connection =null;
        connection = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_order where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getTimestamp("order_time"));
                order.setPay_time(rs.getTimestamp("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
            }
            DBUtils.close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    public void deleteById(Integer id){
        Connection connection = null;
        connection = DBUtils.getConnectionByDatasource();
        String sql = "delete from tb_order where id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtils.close(connection);
    }

}
