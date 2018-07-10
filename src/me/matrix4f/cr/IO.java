package me.matrix4f.cr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class IO {

    public static final int EOF = -1;

    public static byte[] dump(InputStream is) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int buf;
        while((buf = is.read()) != EOF)
            out.write(buf);

        return out.toByteArray();
    }
}
