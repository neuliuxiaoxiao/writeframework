package proxy;

import java.io.*;

public class GPClassLoader extends ClassLoader {

    private File baseDir;

    public GPClassLoader() {
        String basePath = GPClassLoader.class.getResource("").getPath();
        this.baseDir=new File(basePath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName()+"."+name;
        if (baseDir!=null){
            File classFile = new File(baseDir,name.replaceAll("\\.","/")+".class");
            FileInputStream in = null;
            try {
                in = new FileInputStream(classFile);
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                byte[] buff = new byte[1024];
                int len =0;
                while ((len=in.read(buff))!=-1){
                    out.write(buff,0,len);
                }

                return defineClass(className,out.toByteArray(),0,out.size());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                classFile.delete();
                if (null!=in){
                    try {
                        in.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
