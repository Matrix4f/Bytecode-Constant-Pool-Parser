package me.matrix4f.cr;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        try {
            byte[] classbytes = IO.dump(new FileInputStream("S:\\java\\testjar\\out\\production\\testjar\\me\\matrix4f\\test\\CRTest.class"));
            ClassReader cr = new ClassReader(classbytes);
            cr.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
