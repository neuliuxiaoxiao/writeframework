package proxy;

public class Test {
    public static void main(String[] args) throws Exception {

        Person obj = (Person) new GPMeipo().getInstance(new XiaoXingXing());
        System.out.println(obj.getClass());
        obj.findLove();
    }
}
