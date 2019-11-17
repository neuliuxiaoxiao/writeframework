package proxy;
import java.lang.reflect.Method;
public class $Proxy0 implements proxy.Person{
GPInvocationHandler h;
public $Proxy0(GPInvocationHandler h){
this.h=h;}
public void findLove() {
try{
Method m = proxy.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){e.printStackTrace();}
}
}