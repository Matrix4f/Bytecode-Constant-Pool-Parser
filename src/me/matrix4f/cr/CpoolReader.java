package me.matrix4f.cr;

import me.matrix4f.cr.cp.*;

import java.util.ArrayList;
import java.util.List;

public class CpoolReader implements Constants{

    private ByteReader b;

    private int magic;
    private short major, minor, cpcount, thisClassIndex, superClassIndex, accessFlags;
    private short[] interfaces;
    private List<Constant> cpool;

    public CpoolReader(byte[] classbytes) {
        b = new ByteReader(classbytes);
        cpool = new ArrayList<>();
    }

    private void readVersionInfo() {
        magic = b.u4();
        minor = b.u2();
        major = b.u2();
    }

    private void readConstantPool() {
        cpcount = b.u2();
        for(int i = 0; i < cpcount-1; i++) {
            byte tag = b.u1();
            Constant cst = null;
            switch (tag) {
                case CONSTANT_Class:
                    cst = new ConstantClass(b.u2());
                    break;

                case CONSTANT_Fieldref:
                    cst = new ConstantFieldRef(b.u2(), b.u2());
                    break;

                case CONSTANT_Methodref:
                    cst = new ConstantMethodRef(b.u2(), b.u2());
                    break;

                case CONSTANT_InterfaceMethodref:
                    cst = new ConstantInterfaceMethodRef(b.u2(), b.u2());
                    break;

                case CONSTANT_String:
                    cst = new ConstantString(b.u2());
                    break;

                case CONSTANT_Integer:
                    cst = new ConstantInt(b.u4());
                    break;

                case CONSTANT_Float:
                    cst = new ConstantFloat(b.u4());
                    break;

                case CONSTANT_Long:
                    cst = new ConstantLong(b.u4(), b.u4());
                    i++;
                    break;

                case CONSTANT_Double:
                    cst = new ConstantDouble(b.u4(), b.u4());
                    i++;
                    break;

                case CONSTANT_NameAndType:
                    cst = new ConstantNameAndType(b.u2(), b.u2());
                    break;

                case CONSTANT_Utf8:
                    short len = b.u2();
                    byte[] descriptorBytes = new byte[len];
                    for(int j = 0; j < len; j++)
                        descriptorBytes[j] = b.u1();
                    cst = new ConstantUtf8(descriptorBytes);
                    break;

                case CONSTANT_MethodHandle:
                    cst = new ConstantMethodHandle(b.u1(), b.u2());
                    break;

                case CONSTANT_MethodType:
                    cst = new ConstantMethodType(b.u2());
                    break;

                case CONSTANT_InvokeDynamic:
                    cst = new ConstantInvokeDynamic(b.u2(),b.u2());
                    break;

                case CONSTANT_Module:
                    cst = new ConstantModule(b.u2());
                    break;

                case CONSTANT_Package:
                    cst = new ConstantPackage(b.u2());
                    break;

                default:
                    System.out.println("Could not recognize tag " + tag);
                    System.exit(-1);
            }
            if(cst != null)
                cpool.add(cst);
        }
    }

    private void readHeaders() {
        accessFlags = b.u2();
        thisClassIndex = b.u2();
        superClassIndex = b.u2();
    }

    private void readInterfaces() {
        interfaces = new short[b.u2()];
        for(int i = 0; i < interfaces.length; i++)
            interfaces[i] = b.u2();
    }

    public void read() {
        readVersionInfo();
        readConstantPool();
        readHeaders();
        readInterfaces();
    }

    public Constant getCpoolEntry(short index) {
        return cpool.get(index-1);
    }

	public List<Constant> getCpool() {
		return cpool;
	}
}
