package proxy;

public class XiaoXingXing implements Person {
    private String sex = "女";
    private String name = "小星星";

    @Override
    public void findLove() {
        System.out.println(this.sex + "-" + this.name);
        System.out.println("高富帅");
    }

}
