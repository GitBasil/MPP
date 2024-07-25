package grading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Auxil {
	public static boolean sameElements(List<?> list1, List<?> list2) {
		if(list1 == null && list2 == null) return true;
		if(list1 == null || list2 == null) return false;
		if(list1.size() != list2.size()) return false;
		for(Object ob : list1) {
			if(!list2.contains(ob)) return false;
		}
		return true;
	}
	
	//Returns true if cl1 inherits from cl2
	public static boolean inheritsFrom(Class<?> cl1, Class<?> cl2) {
		return cl2.isAssignableFrom(cl1);
	}
	
	public static boolean containsInstVariable(Class<?> cl, String vbleName) {
		List<Field> declaredFields = Arrays.asList(cl.getDeclaredFields());
		for(Field f: declaredFields) {
			if(f.getName().equals(vbleName)) return true;
		}
		return false;
	}
	
	public static boolean containsInstVariableType(Class<?> cl, Class<?> type) {
		List<Field> declaredFields = Arrays.asList(cl.getDeclaredFields());
		for(Field f: declaredFields) {
			if(f.getType() == type) return true;
		}
		return false;
	}
	
	public static boolean containsMethod(Class<?> cl, String methodName) {
		List<Method> declaredMethods = Arrays.asList(cl.getDeclaredMethods());
		for(Method f: declaredMethods) {
			if(f.getName().equals(methodName)) return true;
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param pathFromSrcDir - example:  "\\src\\prob1\\RemoveDups.java"
	 * @return
	 */
	public static boolean usesForLoop(String pathFromSrcDir) {
			final String FOR = "for";
			String path = System.getProperty("user.dir") + pathFromSrcDir;
			File f = new File(path);
			String line = null;
			boolean forLoopFound = false;
			try(FileReader fileread = new FileReader(f)) {
				try(BufferedReader bufread = new BufferedReader(fileread)) {
					while( (line = bufread.readLine()) != null ) {
						if(line.contains(FOR)) forLoopFound = true;
					}
				}
			} catch(Exception e) {
				System.out.println("Warning: Unable to read student file");
			}
			
			return forLoopFound;
	}
	
	/**
	 * 
	 * @param pathFromSrcDir - example:  "\\src\\prob1\\RemoveDups.java"
	 * @return
	 */
	public static boolean usesWhileLoop(String pathFromSrcDir) {
			final String WHILE = "while";
			String path = System.getProperty("user.dir") + pathFromSrcDir;
			File f = new File(path);
			String line = null;
			boolean whileLoopFound = false;
			try(FileReader fileread = new FileReader(f)) {
				try(BufferedReader bufread = new BufferedReader(fileread)) {
					while( (line = bufread.readLine()) != null ) {
						if(line.contains(WHILE)) whileLoopFound = true;
					}
				}
			} catch(Exception e) {
				System.out.println("Warning: Unable to read student file");
			}
			
			return whileLoopFound;
	}
	
	public static boolean containsConstructor(Class<?> cl, String constructorName) {
		List<Constructor<?>> constructors = Arrays.asList(cl.getDeclaredConstructors());
		for(Constructor<?> c: constructors) {
			if(c.getName().contains(constructorName)) return true;
		}
		return false;
	}
	
	public static boolean constructorHasCorrectNumParams(Class<?> cl, String constructorName, int numParams) {
		List<Constructor<?>> constructors = Arrays.asList(cl.getDeclaredConstructors());
		for(Constructor<?> c: constructors) {
			if(c.getName().contains(constructorName)) {
				return (numParams == c.getParameterTypes().length);
			}
		}
		return false;
	}
}
