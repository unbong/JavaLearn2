package com.example.rpcfx.provicer;

import com.unbong.core.api.RpcfxResolver;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;


/**
 * 1  利用反射生成服务端的实例
 *  搜索指定路径下的所有类，判断是否为服务接口的实现来。
 *
 */
@Slf4j
public class ReflectionResolver implements RpcfxResolver {
    @Override
    public Object resolve(String serviceClass) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        Class interfaceClass= Class.forName(serviceClass);

        List<Class<?>> inheritClasses = getAllClassByInterface(interfaceClass);

        if(inheritClasses != null)
        {
          return   inheritClasses.get(0).newInstance();
        }

        return null;
    }

    public  List<Object> getAllObjectByInterface(Class<?> c)
            throws InstantiationException, IllegalAccessException {
        List<Object> list = new ArrayList<Object>();
        List<Class<?>> classes = getAllClassByInterface(c);
        for (int i = 0; i < classes.size(); i++) {
            list.add(classes.get(i).newInstance());
        }
        return list;
    }

    /*
     * 获取指定接口的实例的Class对象
     */
    public  List<Class<?>> getAllClassByInterface(Class<?> c) {
        // 如果传入的参数不是接口直接结束
        if (!c.isInterface()) {
            return null;
        }

        // 获取当前包名
        //String packageName = c.getPackage().getName();
        String packageName = ReflectionResolver.class.getPackage().getName();
        List<Class<?>> allClass = null;
        try {
            allClass = getAllClassFromPackage(packageName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        ArrayList<Class<?>> list = new ArrayList<Class<?>>();
        for (int i = 0; i < allClass.size(); i++) {
            if (c.isAssignableFrom(allClass.get(i))) {
                if (!c.equals(allClass.get(i))) {
                    list.add(allClass.get(i));
                }
            }
        }

        return list;
    }

    private  List<Class<?>> getAllClassFromPackage(String packageName) throws IOException, ClassNotFoundException{
        ClassLoader classLoader = ReflectionResolver.class.getClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> enumeration = classLoader.getResources(path);
        List<String> classNames = getClassNames(enumeration, packageName);

        ArrayList<Class<?>> classes = new ArrayList<Class<?>>();
        for (int i = 0; i < classNames.size(); i++) {
            classes.add(Class.forName(classNames.get(i)));
        }

        return classes;
    }

    public  List<String> getClassNames(Enumeration<URL> enumeration, String packageName) {
        List<String> classNames = null;
        while (enumeration.hasMoreElements()) {
            URL url = enumeration.nextElement();
            if (url != null) {
                String type = url.getProtocol();
                if (type.equals("file")) {
                    System.out.println("type : file");
                    String fileSearchPath = url.getPath();
                    if(fileSearchPath.contains("META-INF")) {
                        System.out.println("continue + " + fileSearchPath);
                        continue;
                    }
                    classNames = getClassNameByFile(fileSearchPath);
                } else if (type.equals("jar")) {
                    try {
                        System.out.println("type : jar");
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        JarFile jarFile = jarURLConnection.getJarFile();
                        classNames = getClassNameByJar(jarFile, packageName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("type : none");
                }
            }
        }

        return classNames;
    }

    /*
     * 获取项目某路径下的所有类
     */
    public  List<String> getClassNameByFile(String fileSearchPath) {
        List<String> classNames = new ArrayList<String>();

        File file = new File(fileSearchPath);
        File[] childFiles = file.listFiles();
        for(File childFile : childFiles) {
            if(childFile.isDirectory()) {
                classNames.addAll(getClassNameByFile(childFile.getPath()));
            } else {
                String childFilePath = childFile.getPath();
                if (childFilePath.endsWith(".class")) {
                    String className = childFilePath.substring(childFilePath.lastIndexOf("\\com\\") + 1
                    ).replaceAll("\\\\", ".");
                    className = className.substring(0, className.indexOf(".class"));
                    log.info("full path name:{}", className);
                    classNames.add(className);
                }
            }
        }

        return classNames;
    }

    /*
     * 从jar包中获取某路径下的所有类
     */
    public  List<String> getClassNameByJar(JarFile jarFile, String packageName) {
        List<String> classNames = new ArrayList<String>();
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements()) {
            JarEntry jarEntry = entrys.nextElement();
            String entryName = jarEntry.getName();
            if(entryName.endsWith(".class")) {
                String className = entryName.replace("/", ".");
                className = className.substring(0, className.indexOf(".class"));
                classNames.add(className);
            }

        }
        return classNames;
    }

//    public class ReflectionResolverInvocaionHandler implements InvocationHandler{
//
//
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//
//            log.info("动态生成查早类的实现");
//            Object result = null;
//            //Object result = method.invoke(proxy,args);
//            return result;
//
//        }
//    }
}
