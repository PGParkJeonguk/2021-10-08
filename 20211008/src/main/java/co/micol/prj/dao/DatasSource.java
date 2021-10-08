package co.micol.prj.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatasSource {
	private static DatasSource dataSource = new DatasSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	
	private DatasSource() {
		dbconfig();
	}		//외부에서 생성할수 없도록 생성자를 private로 만든다.
	
	public static DatasSource getInstance() {
		return dataSource;
	}
	//싱글톤 클래스 만드는 법 
	
	private void dbconfig() {	//외부 properties파일을 읽어서 값을 저장한다.
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getFile();
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);		//ojdbc 연결(load가 원본)
			conn = DriverManager.getConnection(url, user, password);
		//	System.out.println("DB 연결 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;		//생성된 컨넥션 객체를 돌려준다.
	}
}
