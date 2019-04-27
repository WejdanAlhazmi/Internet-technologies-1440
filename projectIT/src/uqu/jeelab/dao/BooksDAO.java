package uqu.jeelab.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import uqu.jeelab.model.Book;


public class BooksDAO {
	
	private static String URL = "db4free.net:3306/ghaidaa_wejdan";
	private static String user = "ghaidaawejdan";
	private static String password = "123123wg";
	
	private Connection connect = null;
	private ResultSet resultSet = null;
	
	private ArrayList resList = new ArrayList();
	
	public ArrayList getBooks()throws Exception {
		try {
			connect = DriverManager.getConnection("jdbc:mysql://" +URL, user, password);
			
			Statement statement = connect.createStatement();
			
			String sql = "select * from books";
			resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				String Name = resultSet.getString("Name");
				String Pages = resultSet.getString("Pages");
				resList.add(new Book(Name, Pages));
			}
			return resList;
			
		} catch(Exception e) {
			throw e;
		} finally {
			close();
		}
	}

	private void close() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(connect != null) {
				connect.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
