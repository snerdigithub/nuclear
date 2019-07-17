package com.snerdi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.snerdi.po.DCSDataBean;
import com.snerdi.po.RCSPressBBean;

public class QueueDao {
	
	public List listZGSLL() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List list = new ArrayList();
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nucleardemo","root", "111");

			// 利用SQL创建PreparedStatement
			preparedStatement = connection.prepareStatement("SELECT round((FWS_FT050B_MED+FWS_FT051B_MED)/2,2) as ZGSLL from dcs_ai");		

			// 执行PreparedStatement获取结果集ResultSet
			resultSet = preparedStatement.executeQuery();
			
			// 遍历结果集封装成List
			while (resultSet.next()) {
				String val = resultSet.getString(1);
				list.add(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
	public List<DCSDataBean> listDCSData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<DCSDataBean> list = new ArrayList<DCSDataBean>();
		try {
			// 加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库连接
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/nucleardemo","root", "111");

			// 利用SQL创建PreparedStatement
			
			String strSQL = "SELECT TIME_STAMP, round(FWS_TE1011,2) as GSWD, round((FWS_FT050B_MED+FWS_FT051B_MED)/2,2) as ZGSLL, round(RCS_ST281,2) AS ZBZS1, round(RCS_ST282,2) AS ZBZS2, round(RCS_ST283,2) AS ZBZS3, round(RCS_ST284,2) AS ZBZS4, round(PMSA_PRPP_1_MED,2) AS FYDHGL, round(ZAS_JY_T101_MWG,2) AS FDJYGGL, round(ZAS_JY_T101_MVARG,2) AS FDJWGGL, round(RCS_FT101A,2) AS HL1RCSRDLL, round(RCS_FT102A,2) AS HL2RCSRDLL,round(RCS_TE133A,2) AS HL1RCSRDWD, round(RCS_TE133B,2) AS HL2RCSRDWD, round(RCS_PT140A,2) AS RCSYLA, round(RCS_PT140B,2) AS RCSYLB from dcs_ai";
			preparedStatement = connection.prepareStatement(strSQL);		
			
			// 执行PreparedStatement获取结果集ResultSet
			resultSet = preparedStatement.executeQuery();
			
			// 遍历结果集封装成List
			while (resultSet.next()) {
				DCSDataBean dcs = new DCSDataBean();
				dcs.setTimeStamp(resultSet.getString(1));
				dcs.setGSWD(resultSet.getString(2));
				dcs.setZGSLL(resultSet.getString(3));
				dcs.setZBZS1(resultSet.getString(4));
				dcs.setZBZS2(resultSet.getString(5));
				dcs.setZBZS3(resultSet.getString(6));
				dcs.setZBZS4(resultSet.getString(7));
				dcs.setFYDHGL(resultSet.getString(8));
				dcs.setFDJYGGL(resultSet.getString(9));
				dcs.setFDJWGGL(resultSet.getString(10));
				dcs.setHL1RCSRDLL(resultSet.getString(11));
				dcs.setHL2RCSRDLL(resultSet.getString(12));
				dcs.setHL1RCSRDWD(resultSet.getString(13));
				dcs.setHL2RCSRDWD(resultSet.getString(14));
				dcs.setRCSYLA(resultSet.getString(15));
				dcs.setRCSYLB(resultSet.getString(16));
				list.add(dcs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	
}

