package com.softfz.dao;

import javax.sql.DataSource;

import org.omg.CosNaming.NameComponent;

import com.softfz.config.DataSourceConfig;
import com.softfz.jdbc.JdbcOperator;
import com.softfz.jdbc.JdbcOperatorImpl;

public class NetDealerDAO {
	private JdbcOperator jdbcOperator;

	public NetDealerDAO() {
		DataSource dataSource = DataSourceConfig.getDataSource();
		jdbcOperator = new JdbcOperatorImpl(dataSource);
	}
	
	/**
	 * ����������û�
	 * @param netid
	 * @param passwordOld
	 * @param passwordNew
	 */
	public int addNetDealer(int userid, String netcode, String netname,
			String password, String director, String telephone, String state,
			String address){
		//ȡ����
		//����������
		//��װ������List��
		//����JDBC����֮
		//jdbcOperator.update(sql,parameterList);
		//û���������
		String sql="INSERT INTO airticket.netdealer(userid,netcode,netname,password,director,telphone,state,address) VALUES (?,?,?,?,?,?,?,?);";
		int result=jdbcOperator.queryForInt(sql, userid,netcode,netname,password,director,telephone,state,address);
		return result;
	}
	
}
