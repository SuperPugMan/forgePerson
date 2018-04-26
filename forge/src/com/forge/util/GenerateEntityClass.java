package com.forge.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

public class GenerateEntityClass extends DBoperator {
	
	private String packageOutPath = "com.ltc.bean";  //指定实体所在生成包的路径
	private List<Object> tables = new ArrayList();  //存储所有表的名称
	private String tableName = "";   //表的名称
	List colNames = null;   //存储属性的名称
	List colTypes = null;   //存储属性的类型
	private String authorName = "杨鹏飞";  //作者姓名
	private String changeTableNameStr = "";//驼峰转换后的类名  
	private boolean f_util = false;  //是否导入java.util包
	private boolean f_sql = false;   //是否导入java.sql包
	private boolean f_decimal = false;//是否需要导入java.math.BigDecimal 
	
	//从数据库中获取所有表
	public void showTables(){
		String sql = "show tables";
		try {
			rs = excuteQuery(sql);
			while (rs.next()){
				int i =1;
				tables.add(rs.getObject(i));  //将表的名称添加到集合中
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
		
		/*for(Object a :tables){
			System.out.println(a.toString());
		}*/
	}
	
	//生成多个实体类
	public void generaTableEntities(){
		showTables();
		for(int i=0;i<tables.size();i++){
			tableName = tables.get(i).toString();
			genTableEntity(tableName); //生成实体类
		}
	}
	
	//获取表中的所有属性
	public void descTable(String tableName){
		 colNames = new ArrayList();   //存储属性的名称
		 colTypes = new ArrayList();   //存储属性的类型
		String sql = "desc "+ tableName;
		try {
			rs = excuteQuery(sql);
			while(rs.next()){
				
				String filed = rs.getString("Field");
				String type = rs.getString("Type");

				/*if(type.contains("(")){
					String[] split = type.split("(");
					for(String a :split){
						System.out.println(a+" ");
					}
					//type=split[0];
				}*/
				//System.out.println(filed);
				//System.out.println(type);
				colNames.add(filed);
				colTypes.add(type);
				if(type.contains("timestamp")||type.contains("datetime")){
					f_util = true;
				}
				if(type.contains("image")||type.contains("text")){
					f_sql = true;
				}
				if(type.contains("decimal")){
					f_decimal = true;
				}
			}
		//	parse(colNames,colTypes);   //生成实体类的属性和方法
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnection();
		}
	}

	/**
	 * 生成实体类的主要代码
	 * @param colName  属性名称
	 * @param colType  属性类型
	 * 
	 * \r return，输入光标回到行的开头
	 * \n newline，换行
	 * 
	 */
	private String parse(List colName, List colType) {
		StringBuffer sb = new StringBuffer();
		//将表名转换为驼峰样式
		String []tableNameStr = tableName.toLowerCase().split("_");
		changeTableNameStr = "";
		/*for(String table: tableNameStr){
			changeTableNameStr +="_"+ initCap(table);
		}*/
		for(int i=0;i<tableNameStr.length;i++){
			if(i==0){
				changeTableNameStr+=initCap(tableNameStr[i]);
				}else{
				changeTableNameStr+="_"+initCap(tableNameStr[i]);
			}
		}
			
		sb.append("package " +this.packageOutPath+";\r\n");
		sb.append("\r\n");
		
		//判断是否导入工具包
		sb.append("import java.io.Serializable;");
		sb.append("\r\n");
		if(f_util){
			sb.append("import java.sql.Date;\r\n");
		}
		if(f_sql){
			sb.append("import java.sql.*;\r\n");
		}
		if(f_decimal){
			sb.append("import java.math.BigDecimal;\r\n");
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("\r\n");
		//注释部分
		sb.append("/**\r\n");
		sb.append("*Created by"+this.authorName+"on"+df.format(new java.util.Date())+"\r\n");
		sb.append("*@Descrption"+tableName+"实体类\r\n");
		sb.append("*/ \r\n");
		
		//实体部分
		sb.append("\r\n\r\npublic class "+changeTableNameStr+"  implements Serializable"+"{\r\n");
		processAllAttrs(sb);  //生成所有的属性
		processConstructor(sb);   //功能：创建构造方法
		processAllMethod(sb);  //生成get set方法
		sb.append("}\r\n");
		return sb.toString();
		
	}
	
	/**
	 * 功能：创建构造方法
	 * @param sb
	 */
	private void processConstructor(StringBuffer sb) {
		sb.append("\tpublic "+changeTableNameStr+"(){}");
		sb.append("\r\n");
		sb.append("\tpublic "+changeTableNameStr+"(");
		for(int i=0;i<colNames.size();i++){
			if(i==colNames.size()-1){
				sb.append(sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i));
			}else{
				sb.append(sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i)+",");
			}
		}
		sb.append("){\r\n");
		sb.append("\tsuper();");
		sb.append("\r\n");
		for(int i=0;i<colNames.size();i++){
			sb.append("\tthis. "+colNames.get(i)+"="+colNames.get(i)+";\r\n");
		}
		sb.append("}\r\n");
	}

	/**
	 * 功能：生成所有方法
	 * @param sb
	 */
	private void processAllMethod(StringBuffer sb) {
		for (int i = 0; i < colNames.size(); i++) {  
            sb.append("\tpublic void set" + initCap(colNames.get(i).toString()) + "(" + sqlType2JavaType(colTypes.get(i).toString()) + " " +  
            		colNames.get(i) + "){\r\n");  
            sb.append("\tthis." + colNames.get(i) + "=" + colNames.get(i) + ";\r\n");  
            sb.append("\t}\r\n");  
            sb.append("\tpublic " + sqlType2JavaType(colTypes.get(i).toString()) + " get" + initCap(colNames.get(i).toString()) + "(){\r\n");  
            sb.append("\t\treturn " + colNames.get(i) + ";\r\n");  
            sb.append("\t}\r\n");  
        }  
	}
	
	/**
	 * 功能：生成所有属性
	 * @param sb
	 */
	private void processAllAttrs(StringBuffer sb) {
		for(int i=0;i<colNames.size();i++){
			sb.append("\tprivate "+sqlType2JavaType(colTypes.get(i).toString())+" "+colNames.get(i)+";\r\n");
		}
	}
	
	/**
	 * 功能：获得列的数据类型
	 * @param sqlType
	 * @return
	 */
	private String sqlType2JavaType(String sqlType) {
		 if(sqlType.contains("bit")){  
	            return "boolean";  
	        }else if(sqlType.contains("tinyint")){  
	            return "byte";  
	        }else if(sqlType.contains("smallint")){  
	            return "short";  
	        }else if(sqlType.contains("int")){  
	            return "int";  
	        }else if(sqlType.contains("bigint")){  
	            return "long";  
	        }else if(sqlType.contains("float")){  
	            return "float";  
	        }else if(sqlType.contains("numeric")  
	                || sqlType.contains("real") || sqlType.contains("money")  
	                || sqlType.contains("smallmoney")){  
	            return "double";  
	        }else if(sqlType.contains("varchar") || sqlType.contains("char")  
	                || sqlType.contains("nvarchar") || sqlType.contains("nchar")  
	                || sqlType.contains("text") || sqlType.contains("json")){  
	            return "String";  
	        }else if(sqlType.contains("datetime")||sqlType.contains("timestamp")){  
	            return "Date";  
	        }else if(sqlType.contains("image")){  
	            return "Blod";  
	        }else if(sqlType.contains("decimal")){  
	            return "BigDecimal";  
	        }  
	  
		return null;
	}
	
	/**
	 * 功能：将输入字符串的首字母改成大写
	 * @param table
	 * @return
	 */
	private String initCap(String str) {
		char []ch = str.toCharArray();
		if(ch[0]>='a' && ch[0]<='z'){
			ch[0]=(char)(ch[0]-32);
		}
		return new String(ch);
	}
	
	//将实体类写入磁盘
	public void genTableEntity (String tableName){
		descTable(tableName);
		String content = parse(colNames,colTypes);
		File directory = new File("");
		//System.out.println("绝对路径："+directory.getAbsolutePath());  
        //System.out.println("相对路径："+directory.getCanonicalPath());  
		String path = this.getClass().getResource("").getPath();
		
//        System.out.println(path);  
//        System.out.println("src/?/"+path.substring(path.lastIndexOf("/com/", path.length())) );  
//        String outputPath = directory.getAbsolutePath()+ "/src/"+path.substring(path.lastIndexOf("/com/", path.length()), path.length()) + initCap(tablename) + ".java";  
//        System.out.println( "\\src\\\\main\\java\\"+this.packageOutPath.replace(".", "\\")+"\\"+initCap(tableName) + ".java");  
		  
		String outputPath = directory.getAbsolutePath()+"\\src\\\\"+this.packageOutPath.replace(".", "\\")+"\\"+changeTableNameStr  + ".java";
		//System.out.println(directory.getAbsolutePath());
		File file = new File(outputPath);
		try {
			if(!file.exists()){
				file = new File(directory.getAbsolutePath()+ "\\src\\\\"+this.packageOutPath.replace(".", "\\"),initCap(changeTableNameStr)+ ".java");
			    file.createNewFile();				
			}
			FileWriter fw = new FileWriter(outputPath);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(content);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
