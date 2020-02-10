package ma.dxc.app;

import ma.dxc.utils.JDBCToModelConverter;

public class FirstLayerApplication {

	public static void main(String[] args) {
		
		//(String host, String driverName, String databaseName, String userName, String password, String prefix)
		JDBCToModelConverter generator = new JDBCToModelConverter(args[0], args[1], args[2], args[3], args[4], args[5]);
		generator.generateModel();
		generator.generateDTOs();
		
	}

}
