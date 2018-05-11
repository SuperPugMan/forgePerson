package com.forge.dao.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.forge.bean.News;
import com.forge.bean.Order;
import com.forge.bean.Order_Detail;
import com.forge.bean.User;
import com.forge.dao.NewsDao;
import com.forge.dao.OrderDao;
import com.forge.util.DBoperator;
import com.forge.util.jdbcUtil;
import com.forge.util.resultSetUtil;

public class OrderDaoImpl extends jdbcUtil implements OrderDao {

	@Override
	public int add(Order order) {
		return 0;
	}

	@Override
	public int delete(Serializable id) {
		int num=0;
		String sql="delete from `forge_order` where id=?";
		try {
			num = myexcuteUpdate(sql, id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public List<Order> findAll() {
		List<Order> list=null;
		String sql="SELECT * FROM `forge_order`;";
		try {
			rs = myexcuteQuery(sql);
			list = resultSetUtil.findAll(rs, Order.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	public List<Order_Detail> findAllDetail(){
		List<Order_Detail> list=null;
		String sql="select * from forge_order_detail";
		try {
			rs = myexcuteQuery(sql);
			list = resultSetUtil.findAll(rs, Order_Detail.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public Order_Detail findDetailById(Serializable id){
		Order_Detail order=null;
		String sql="select * from forge_order_detail where id=?";
		try {
			rs = myexcuteQuery(sql, id);
			order = resultSetUtil.findById(rs, Order_Detail.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	public int updateDetail(Serializable id,Order_Detail t){
		int num=0;
		String sql="update forge_order_detail set quantity=?,cost=? where id=?";
		try {
			Object [] param={t.getQuanTity(),t.getCost(),id};
			num = myexcuteUpdate(sql, param);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public Order findById(Serializable id) {
		Order order=null;
		String sql="select id,loginName,userAddress,createTime,cost,status,serialNumber from forge_order where id=?";
		try {
			rs = myexcuteQuery(sql, id);
			order = resultSetUtil.findById(rs, Order.class);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}


	@Override
	public int update(Serializable id, Order t) {
		int num=0; 
		String sql="update `forge_order` set `loginName`=? ,`userAddress`=? ,`createTime`=?  ,`cost`=? ,`serialNumber`=? where `id`=?;";
		Object[] param={t.getLoginName(),t.getUserAddress(),t.getCreateTime(),t.getCost(),t.getSerialNumber(),id};
		try {
			num = myexcuteUpdate(sql, param);		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public String orderById(Serializable id) {
        String url = "jdbc:mysql://localhost:3306/forge";
        String user = "root";
        String pwd = "root";
		String sql="select serialNumber from forge_order where id=?;";
		String num=null;
        Connection conn = null;
       PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.prepareStatement(sql);
            st.setInt(1, (Integer) id);
            //执行查询语句，另外也可以用execute()，代表执行任何SQL语句
            rs = st.executeQuery();
            while(rs.next()) {
               num =(String) rs.getObject(1);
            }
        //分别捕获异常
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //判断资源是否存在
                if(rs != null) {
                    rs.close();
                    //显示的设置为空，提示gc回收
                    rs = null;
                }
                if(st != null) {
                    st.close();
                    st = null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }  
            return num;
        }
	}

	@Override
	public String productById(Serializable id) {
        String url = "jdbc:mysql://localhost:3306/forge";
        String user = "root";
        String pwd = "root";
		String sql="select name from forge_product where id=?;";
		String num=null;
        Connection conn = null;
       PreparedStatement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pwd);
            st = conn.prepareStatement(sql);
            st.setInt(1, (Integer) id);
            //执行查询语句，另外也可以用execute()，代表执行任何SQL语句
            rs = st.executeQuery();
            while(rs.next()) {
               num =(String) rs.getObject(1);
            }
        //分别捕获异常
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //判断资源是否存在
                if(rs != null) {
                    rs.close();
                    //显示的设置为空，提示gc回收
                    rs = null;
                }
                if(st != null) {
                    st.close();
                    st = null;
                }
                if(conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }  
            return num;
        }
	}
}
