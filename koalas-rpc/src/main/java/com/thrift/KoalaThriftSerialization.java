package com.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TIOStreamTransport;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class KoalaThriftSerialization {

    public static void main(String[] args) throws TException {

        koalasRequest request = new koalasRequest (  );
        request.setName ( "小明" );
        request.setAge ( 20 );
        request.setAddress ( "北京" );

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        TIOStreamTransport tioStreamTransport = new TIOStreamTransport (out);
        TProtocol protocol = new TBinaryProtocol (tioStreamTransport);
        request.write ( protocol );
        System.out.println (Arrays.toString ( out.toByteArray () ) );

    }

}