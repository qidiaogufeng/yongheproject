package com.zb.utils;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class ExcelPOI {
    //利用此方法
    public void export(String [] titles , ServletOutputStream out) throws SQLException, IOException {
        //以下代码能复制，无需自己写，懂的修改和替换即可

        //1.创建一个workbook，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.在workbook中添加一个sheet,对应Excel中的sheet
        HSSFSheet hssfSheet = workbook.createSheet("sheet1");
        //3.在sheet中添加表头第0行
        HSSFRow hssfRow = hssfSheet.createRow(0);
        //4.创建单元格 并设置表头居中
        HSSFCellStyle hssfCellStyle = workbook.createCellStyle();
        //4.1居中样式，这里只设置居中，其他样式可自行查找资料
        hssfCellStyle.setAlignment(HorizontalAlignment.CENTER);
        //4.2创建单元格
        HSSFCell hssfCell = null;
        for(int i=0;i<titles.length;i++){
            hssfCell = hssfRow.createCell(i);
            hssfCell.setCellValue(titles[i]);
            hssfCell.setCellStyle(hssfCellStyle);
        }

        OrderDao orderDao = new OrderDao();
        List<Order> list = orderDao.findAll();
        //创建行，注意行的下标从0开始，0鹰设置过了
        for (int i=0;i<list.size();i++) {
            hssfRow = hssfSheet.createRow(i + 1);
            Order order = list.get(i);
            Integer id = null;
            if (order.getId() != 0) {
                id = order.getId();
            }
            hssfRow.createCell(0).setCellValue(id);

            Integer door_id = null;
            if (order.getDoor_id() != 0) {
                door_id = order.getDoor_id();
            }
            hssfRow.createCell(1).setCellValue(door_id);

            String order_no = "";
            if (order.getOrder_no() != null) {
                order_no = order.getOrder_no();
            }
            hssfRow.createCell(2).setCellValue(order_no);

            String order_type = "";
            if (order.getOrder_type() != null) {
                order_type = order.getOrder_type();
            }
            hssfRow.createCell(3).setCellValue(order_type);

            Integer pnum = 0;
            if (order.getPnum() != 0) {
                pnum = order.getPnum();
            }
            hssfRow.createCell(4).setCellValue(pnum);

            String cashier = "";
            if (order.getCashier() != null) {
                cashier = order.getCashier();
            }
            hssfRow.createCell(5).setCellValue(cashier);

            Timestamp order_time = null;
            if (order.getOrder_time() != null) {
                order_time = order.getOrder_time();
            }
            hssfRow.createCell(6).setCellValue(order_time);

            Timestamp pay_time = null;
            if (order.getPay_time() != null) {
                pay_time = order.getPay_time();
            }
            hssfRow.createCell(7).setCellValue(pay_time);

            String pay_type = "";
            if (order.getPay_type() != null) {
                pay_type = order.getPay_type();
            }
            hssfRow.createCell(8).setCellValue(pay_type);

            Double price = null;
            if (order.getPrice() != 0) {
                price = order.getPrice();
            }
            hssfRow.createCell(9).setCellValue(price);
        }
            workbook.write(out);
            out.flush();
            out.close();

    }
}
