package com.commondb;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Common_DB {
	
public Common_DB()
{
	
}
    /*  
    * View All Data
    */
public static ResultSet ViewTable(String DBName,String tableName) throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	ResultSet rs=ps.executeQuery("select * from "+tableName);
	return rs;
}
	/*
	 * View particular Data
	 */
public static ResultSet ViewParticularData(String DBName,String tableName,String colName1,String colValue1) throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	PreparedStatement ps=con.prepareStatement("select * from "+tableName+" where "+colName1+" = ?");
	ps.setString(1,colValue1);
	//execute query
	ResultSet rs=ps.executeQuery();
	return rs;
}
	/*
	 * Login Check
	 */
public static ResultSet LoginCheck(String DBName,String tableName,String colName1,String colName2,String colValue1,String colValue2) throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	PreparedStatement ps=con.prepareStatement("select * from "+tableName+" where "+colName1+" = ? and "+colName2+" = ?");
	ps.setString(1,colValue1);
	ps.setString(2,colValue2);
	//execute query
	ResultSet rs=ps.executeQuery();
	return rs;
}
	/*
	 * Insert Data Into Table
	 */
public static int InsertTable(String DBName,String insert_query)throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}	
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	int result=ps.executeUpdate(insert_query);
	return result;
}
	/*
	 * Update Data into Table
	 */
public static int UpdateTable(String DBName,String update_query)throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	int result=ps.executeUpdate(update_query);
	return result;
}
	/*
	 * Truncate table
	 */
public static int TruncateTable(String DBName,String tableName)throws Exception
{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	int result=ps.executeUpdate("truncate table "+tableName);
	return result;
}
	/*
	 * Drop Table
	 */
public static int DropTable(String DBName,String tableName)throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	int result=ps.executeUpdate("drop table "+tableName);
	return result;
}
	/*
	 * Rename Table
	 */
public static int RenameTable(String DBName,String OldName,String NewName)throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	//execute query
	int result=ps.executeUpdate("RENAME TABLE "+OldName+" TO "+NewName);
	return result;
}
	/*
	 * Delete a row
	 */
public static int DeleteRow(String DBName,String tableName,String thiscolumn,String thisValue)throws Exception
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	Statement ps=con.createStatement();
	System.out.println("DELETE FROM " +tableName+" WHERE "+thiscolumn+" = '"+thisValue+"'");
	//execute query
	int result=ps.executeUpdate("DELETE FROM " +tableName+" WHERE "+thiscolumn+" = '"+thisValue+"'");
	return result;
}
/**
 * 
 * @param DBName
 * @param query
 * @return
 */
	
public static int FreeQuery(String DBName,String query)
{
	int result=0;
	try {
		Class.forName("com.mysql.jdbc.Driver");	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
		PreparedStatement ps=con.prepareStatement(query);	
		//execute query
		result=ps.executeUpdate();
	} 
	catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
	}
	return result;
}

	/**
	 * 
	 * @param DBName
	 * @param TableName
	 * @param columnName
	 * @param FilePath
	 * @return
	 */
public static int StoreBlob(String DBName,String TableName,String columnName,File FilePath) 
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	int i=0;
	FileInputStream fis=null;
	try
	{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	con.setAutoCommit(false);
	PreparedStatement ps=con.prepareStatement("INSERT INTO "+TableName+"("+columnName+") VALUES(?)");
	//reading file as streams
	fis=new FileInputStream(FilePath);
	ps.setBinaryStream(1,(InputStream)fis,(int)FilePath.length());
	//execute query
	i=ps.executeUpdate();
	con.commit();
	return i;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
//		try {
//			//fis.close();
//			} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	return i;
}

public static int InsertLargeText(String DBName,String TableName,String columnName,String text) 
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	int i=0;
	FileInputStream fis=null;
	try
	{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName+"","root","password");
	con.setAutoCommit(false);
	PreparedStatement ps=con.prepareStatement("INSERT INTO "+TableName+"("+columnName+") VALUES(?)");
	//reading file as streams
	InputStream ins=new ByteArrayInputStream(text.getBytes("utf-8"));
	ps.setBinaryStream(1,ins,text.length());
	//execute query
	i=ps.executeUpdate();
	con.commit();
	return i;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
//		try {
//			//fis.close();
//			} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	return i;
}
}
