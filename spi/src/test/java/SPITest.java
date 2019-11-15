import com.neu.spi.loader.ExtensionLoader;
import com.neu.spi.log.Log;
import org.junit.Test;

/**
 * @Title SPITest
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/13 18:46
 **/
public class SPITest {
    @Test
    public void test() throws Exception {
        //获取默认实现类
//        Log defaultExtension = ExtensionLoader.
//                getExtensionLoader(Log.class).
//                getDefaultExtension();
//        defaultExtension.say();

        //指定特定的实现类,例如配置的tobyLog
        Log tobyLog = ExtensionLoader.
                getExtensionLoader(Log.class).
                getExtension("tobyLog");
        tobyLog.say();

    }

}
