package ma.dxc.utils;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.openjpa.jdbc.conf.JDBCConfiguration;
import org.apache.openjpa.jdbc.conf.JDBCConfigurationImpl;
import org.apache.openjpa.jdbc.meta.ReverseMappingTool;
import org.apache.openjpa.lib.util.Options;

public class JDBCToModelConverter {
	
	public static final String CONNECTION_URL_PREFIX_POSTRESQL = "jdbc:postgresql:";
	public static final String CONNECTION_URL_PREFIX_MYSQL = "jdbc:mysql:";
	public static final String CONNECTION_URL_PREFIX_ORACLE = "jdbc:oracle:thin:";
	
	private String connectionURL;
	private String host;
	private String driverName;
	private String databaseName;
	private String userName;
	private String password;
	
	JDBCConfiguration result = new JDBCConfigurationImpl();
	
	public JDBCToModelConverter(String host, String driverName, String databaseName, String userName,
			String password, String prefix) {
		super();
		this.host = host;
		this.driverName = driverName;
		this.databaseName = databaseName;
		this.userName = userName;
		this.password = password;
		buildURL(prefix);
	}
	
	/**
	 * 
	 * 
	 * @param prefix
	 */
	private void buildURL(String prefix){
		
		if (prefix.equals(CONNECTION_URL_PREFIX_POSTRESQL)) {
			this.connectionURL = CONNECTION_URL_PREFIX_POSTRESQL + "//" + host + "/" + this.databaseName;
		}
		else if(prefix.equals(CONNECTION_URL_PREFIX_ORACLE)) {
			this.connectionURL = CONNECTION_URL_PREFIX_ORACLE + "@" + host + ":" + this.databaseName;
		}
		else if(prefix.equals(CONNECTION_URL_PREFIX_MYSQL)) {
			this.connectionURL = CONNECTION_URL_PREFIX_MYSQL + "//" + host + "/" + this.databaseName;
		}
		
		result.setConnectionURL(this.connectionURL); 
		result.setConnectionDriverName(this.driverName); 
		result.setConnectionUserName(this.userName); 
		result.setConnectionPassword(this.password);
		
	}
	
	
	
	public void generateModel() {
		Options rmOpts = new Options(); 
		String argString = "-Log DefaultLevel=ERROR -metaDataFactory jpa() -metadata none"; 
		
		rmOpts.setProperty("directory", "src/model");
		rmOpts.setProperty("package", "ma.dxc.model");
		rmOpts.setProperty("annotations", true);
		rmOpts.setProperty("useGenericCollections", true);
		rmOpts.setProperty("primaryKeyOnJoin", true);
		rmOpts.setProperty("nullableAsObject", true);
		rmOpts.setFromCmdLine(argString.split(" "));
		
		try {
			ReverseMappingTool.run(result, new String[0], rmOpts);
			System.out.println("okeey");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void generateDTOs() {
		Options rmOpts = new Options(); 
		String argString = "-Log DefaultLevel=ERROR -metaDataFactory jpa() -metadata none"; 
		
		rmOpts.setProperty("directory", "src/model");
		rmOpts.setProperty("package", "ma.dxc.dto");
		rmOpts.setProperty("annotations", false);
		rmOpts.setProperty("useGenericCollections", false);
		rmOpts.setProperty("primaryKeyOnJoin", false);
		rmOpts.setProperty("nullableAsObject", true);
		rmOpts.setFromCmdLine(argString.split(" "));
		
		try {
			ReverseMappingTool.run(result, new String[0], rmOpts);
			System.out.println("okeey");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
