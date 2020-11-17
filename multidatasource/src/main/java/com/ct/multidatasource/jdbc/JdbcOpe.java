package com.ct.multidatasource.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOpe {
    public static void main(String[] args) throws SQLException {
        System.out.println("操作开始");
        /**
         * 从旧数据库中拿数据
         */
        String url = "jdbc:mysql://112.126.98.236:3306/xfdsx2018_test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Shanghai&useSSL=false&nullNamePatternMatchesAll=true";
        Connection con = null;
        String sql;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<SupplierInfoModel> list = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, "root", "xinfadi_236_com");

            sql = "select * from xfd_supplier_info";
            preparedStatement = con.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                SupplierInfoModel infoModel = new SupplierInfoModel();
                infoModel.setId(rs.getInt("id"));
                infoModel.setSupplierNo(rs.getString("supplier_no"));
                infoModel.setSupplierName(rs.getString("supplier_name"));
                infoModel.setContactsName(rs.getString("contacts_name"));
                infoModel.setMobile(rs.getString("mobile"));
                infoModel.setTelephone(rs.getString("telephone"));
                infoModel.setAddress(rs.getString("address"));
                infoModel.setWechat(rs.getString("wechat"));
                infoModel.setIntroduction(rs.getString("introduction"));
                infoModel.setPayMode(rs.getLong("pay_mode"));
                infoModel.setPayAccount(rs.getString("pay_account"));
                infoModel.setAccountPeriod(rs.getString("account_period"));
                infoModel.setCategoryId(rs.getInt("category_id"));
                infoModel.setOpId(rs.getInt("op_id"));
                infoModel.setSupplierType(rs.getLong("supplier_type"));
                infoModel.setIsDel(rs.getLong("is_del"));
                infoModel.setDownloadstatus(rs.getLong("downloadstatus"));
                infoModel.setDownloadtime(rs.getString("downloadtime"));
                infoModel.setLastmsg(rs.getString("lastmsg"));
                infoModel.setCreatedAt(rs.getDate("created_at"));
                infoModel.setUpdatedAt(rs.getDate("updated_at"));
                infoModel.setBuyerId(rs.getInt("buyer_id"));
                list.add(infoModel);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (con != null) {
                con.close();
            }
        }


        /**
         * 放到新数据库中
         */
        String url_new = "jdbc:mysql://192.168.1.240:3306/xfdsx_supplier?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=Asia/Shanghai&useSSL=false&nullNamePatternMatchesAll=true";
        Connection con_new = null;
        String sql_new;
        PreparedStatement preparedStatement_new = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con_new = DriverManager.getConnection(url_new, "root", "xfdsx@2019/PW");

            sql_new = "insert into xfd_supplier_info values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement_new = con_new.prepareStatement(sql_new);
            for (SupplierInfoModel model : list) {
                preparedStatement_new.setInt(1, model.getId());
                preparedStatement_new.setString(2, model.getSupplierNo());
                preparedStatement_new.setString(3, model.getSupplierName());
                preparedStatement_new.setString(4, model.getContactsName());
                preparedStatement_new.setString(5, model.getMobile());
                preparedStatement_new.setString(6, model.getTelephone());
                preparedStatement_new.setString(7, model.getAddress());
                preparedStatement_new.setString(8, model.getWechat());
                preparedStatement_new.setString(9, model.getIntroduction());
                preparedStatement_new.setLong(10, model.getPayMode());
                preparedStatement_new.setString(11, model.getPayAccount());
                preparedStatement_new.setString(12, model.getAccountPeriod());
                preparedStatement_new.setInt(13, model.getCategoryId());
                preparedStatement_new.setInt(14, model.getOpId());
                preparedStatement_new.setLong(15, model.getSupplierType());
                preparedStatement_new.setLong(16, model.getIsDel());
                preparedStatement_new.setLong(17, model.getDownloadstatus());
                preparedStatement_new.setString(18, model.getDownloadtime());
                preparedStatement_new.setString(19, model.getLastmsg());
                preparedStatement_new.setDate(20, model.getCreatedAt());
                preparedStatement_new.setDate(21, model.getUpdatedAt());
                preparedStatement_new.setInt(22, model.getBuyerId());
                preparedStatement_new.setString(23, null);
                preparedStatement_new.setString(24, null);
                preparedStatement_new.setString(25, null);
                preparedStatement_new.setString(26, model.getMobile());
                preparedStatement_new.setString(27, "123456");
                preparedStatement_new.setString(28, "A");
                preparedStatement_new.executeUpdate();
                preparedStatement_new.clearParameters();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (preparedStatement_new != null) {
                preparedStatement_new.close();
            }
            if (con_new != null) {
                con_new.close();
            }
            System.out.println("操作完成");
        }
    }
}
