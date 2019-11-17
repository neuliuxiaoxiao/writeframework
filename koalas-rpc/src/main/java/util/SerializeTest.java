package util;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TIOStreamTransport;
import org.apache.thrift.transport.TTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.dto.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SerializeTest {

    private final static Logger logger = LoggerFactory.getLogger ( SerializeTest.class );

    public static void main(String[] args) throws IOException, ClassNotFoundException, TException {

        long a = System.currentTimeMillis ();
        for (int i = 0; i < 100000; i++) {
            User user = new User("姓名"+i,i,"北京市海淀区中关村大厦"+i);
            byte[] b = SerializeUtil.serializeObject ( user );
            //System.out.println (Arrays.toString ( b ));
            User user1 = (User) SerializeUtil.deserializeObject ( b );
        }
        System.out.println (System.currentTimeMillis ()-a);

        long b = System.currentTimeMillis ();

        for (int i = 0; i < 100000; i++) {
            util.dtothrift.User user = new util.dtothrift.User("姓名"+i,i,"北京市海淀区中关村大厦"+i);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            TTransport transport = new TIOStreamTransport (out);
            TBinaryProtocol tp = new TBinaryProtocol(transport);
            try {
                user.write(tp);
            } catch (TException e) {
                e.printStackTrace();
            }
            byte[] bytes = out.toByteArray();
            //System.out.println ( Arrays.toString ( bytes ));
            util.dtothrift.User user1 = new util.dtothrift.User();

            ByteArrayInputStream bis = new ByteArrayInputStream (  bytes);
            TTransport transport1 = new TIOStreamTransport(bis);
            TBinaryProtocol tp1 = new TBinaryProtocol(transport1);
            user1.read (tp1);
        }
        System.out.println (System.currentTimeMillis ()-b);
    }

}