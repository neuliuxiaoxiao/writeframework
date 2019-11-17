package proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//生成代理对象的方法
public class GPProxy {

    private static String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            //生成源代码
            String proxySrc = generateSrc(interfaces[0]);
            //将生成的源代码输出到磁盘，保存为.Java文件
            String filePath = GPProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = null;
            fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //编译源代码，生成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //将class文件的内容加载到JVM
            //返回被代理后的代理对象
            Class proxyClass =loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();

            return  c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?> interfaces) {
        StringBuffer src = new StringBuffer();
        src.append("package proxy;" + ln);
        src.append("import java.lang.reflect.Method;" + ln);
        src.append("public class $Proxy0 implements " + interfaces.getName() + "{" + ln);
        src.append("GPInvocationHandler h;" + ln);
        src.append("public $Proxy0(GPInvocationHandler h){" + ln);
        src.append("this.h=h;}" + ln);
        for (Method method : interfaces.getMethods()) {
            src.append("public " + method.getReturnType().getName() + " " + method.getName() + "() {" + ln);
            src.append("try{" + ln);
            src.append("Method m = " + interfaces.getName() + ".class.getMethod(\"" + method.getName() + "\",new Class[]{});" + ln);
            src.append("this.h.invoke(this,m,null);" + ln);
            src.append("}catch(Throwable e){e.printStackTrace();}" + ln);
            src.append("}" + ln);
        }
        src.append("}");
        return src.toString();
    }
}
