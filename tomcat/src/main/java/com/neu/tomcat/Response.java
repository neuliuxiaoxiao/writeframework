package com.neu.tomcat;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @Title Response
 * @Description TODO
 * @Author liuxi58
 * @Date 2019/11/12 11:32
 **/
public class Response {

    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void write(String content) throws IOException {
        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK\n")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("</body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }

}
