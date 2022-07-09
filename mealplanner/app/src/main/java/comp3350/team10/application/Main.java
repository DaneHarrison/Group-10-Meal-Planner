package comp3350.team10.application;


//import comp3350.team10.application.Services;

import comp3350.team10.persistence.SharedDB;

public class Main
{
	public static final String dbName = "db";
	private static String dbPathName = "database/db";
	private static String imagesPathName = "images";


	public static void startUp()
	{
		System.out.println("starting database");
		SharedDB.start();
	}

	public static void shutDown()
	{
		System.out.println("closing database");
		SharedDB.close();
	}

	public static void saveDB() {
		System.out.println("saving database...");
		SharedDB.saveDB();
	}


	public static String getDBPathName() {
		if (dbPathName == null)
			return dbName;
		else
			return dbPathName;
	}

	public static void setDBPathName(String pathName) {
		dbPathName = pathName;
	}

	public static void setImagesPathName(String pathName){
		imagesPathName = pathName;
	}

	public static String getImagesPathName() {
		return imagesPathName;
	}
}
