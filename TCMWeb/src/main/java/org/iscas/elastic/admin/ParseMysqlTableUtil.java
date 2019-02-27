package org.iscas.elastic.admin;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.LinkedHashSet;

import java.util.Set;

public class ParseMysqlTableUtil {

	public ParseMysqlTableUtil() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String [] args) {
		String packageName = "org.iscas.web.entity";
		Set<String> tables =  ParseMysqlTableUtil.findTableName(packageName);
		for(String s: tables) {
			System.out.println(s);
		}

	}
	public static Set<String> findTableName(String packageName){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		String packageDirName = packageName.replace(".", "/");
		Set< Class<?> > clazzs = new LinkedHashSet<>();
		Set<String> tables = new LinkedHashSet<>(); 
		Enumeration<URL> dirs;
		
		try {
			dirs = loader.getResources(packageDirName);
			while(dirs.hasMoreElements()) {
				URL url = dirs.nextElement();
				
				String protocal = url.getProtocol();
				if("file".equals(protocal)) {
//					System.out.println(url);
					String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
					findAndAddClassesInPackageByFile(packageName,filePath, false, clazzs);
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
//		System.out.println(clazzs.size());
		 for (Class<?> clazz : clazzs) {
	            // 获取类上的注解
	            Annotation[] annos = clazz.getAnnotations();
	            for (Annotation anno : annos) {
//	                System.out.println(clazz.getSimpleName().concat(".").concat(anno.annotationType().getSimpleName()));
	            	String simpleName = anno.annotationType().getSimpleName();
	            	if("Table".equals(simpleName)||"Entity".equals(simpleName)) {
	            		tables.add(clazz.getName());
	            	}
	            }
//	            System.out.println();

	            // 获取方法上的注解
	            /*
	            Method[] methods = clazz.getDeclaredMethods();
	            for (Method method : methods) {
	                Annotation[] annotations = method.getDeclaredAnnotations();
	                for (Annotation annotation : annotations) {
	                    System.out.println(clazz.getSimpleName().concat(".").concat(method.getName()).concat(".")
	                            .concat(annotation.annotationType().getSimpleName()));
	                }
	            }*/
	        }
		 
		 return tables;
	}

	
	 /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive,
            Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            // log.warn("用户定义包名 " + packageName + " 下没有任何文件");
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        // 循环所有文件
        for (File file : dirfiles) {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive,
                        classes);
            } else {
                // 如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    // classes.add(Class.forName(packageName + '.' + className));
                    // 经过回复同学的提醒，这里用forName有一些不好，会触发static方法，没有使用classLoader的load干净
                    classes.add(
                            Thread.currentThread().getContextClassLoader().loadClass(packageName + '.' + className));
//                    System.out.println(packageName+'.'+className);
                } catch (ClassNotFoundException e) {
                    // log.error("添加用户自定义视图类错误 找不到此类的.class文件");
                    e.printStackTrace();
                }
            }
        }
    }
}
