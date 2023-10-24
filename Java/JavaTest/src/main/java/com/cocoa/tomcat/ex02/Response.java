package com.cocoa.tomcat.ex02;

import okio.Buffer;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

public class Response implements ServletResponse {

    public static final int BUFFER_SIZE = 1024;
    private OutputStream output;
    private Request request;

    PrintWriter writer;

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response(OutputStream outputStream) {
        this.output = outputStream;
    }

    /**
     * 用于输出静态资源
     *
     * @throws IOException
     */
    public void sendStaticResource() throws IOException {
        FileInputStream fis = null;
        try {
            File file = new File(Constants.WEB_ROOT, request.getUri());
            fis = new FileInputStream(file);
            byte[] bytes = new byte[BUFFER_SIZE];
            int bufferIndex = fis.read(bytes, 0, BUFFER_SIZE);
            // 输出HTTP头部信息 修复 err_invalid_http_response 错误
            this.output.write("HTTP/1.1 200 OK\r\n".getBytes());
            this.output.write("Content-Type: text/html\r\n".getBytes());
            StringBuilder sb  = new StringBuilder();
            while (bufferIndex != -1) {
                sb.append(new String(bytes, 0, bufferIndex));
                bufferIndex = fis.read(bytes, 0, BUFFER_SIZE);
            }
            this.output.write(("Content-Length: "+sb.length()+"\r\n").getBytes());
            this.output.write("\r\n".getBytes());
            this.output.write(sb.toString().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            this.output.write(errorMessage.getBytes());
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        this.writer = new PrintWriter(output, true);
        return this.writer;
    }

    @Override
    public void setCharacterEncoding(String charset) {

    }

    @Override
    public void setContentLength(int len) {

    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void setContentType(String type) {

    }

    @Override
    public void setBufferSize(int size) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale loc) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
