package com.jch.java.system;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2018/1/24.
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

    private ByteArrayOutputStream buffer;

    private ServletOutputStream out;

    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        buffer = new ByteArrayOutputStream();
        out = new WrapperOutputStream(buffer);
    }

    public ServletOutputStream getOutputStream() {
        return out;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (out != null){
            out.flush();
        }
    }

    public byte[] getContent() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }
}
class WrapperOutputStream extends ServletOutputStream{

    private ByteArrayOutputStream bos;

    public WrapperOutputStream(ByteArrayOutputStream bos) {
        this.bos = bos;
    }

    @Override
    public void write(int b) throws IOException {
        bos.write(b);
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public boolean isReady() {
        return false;
    }
}
