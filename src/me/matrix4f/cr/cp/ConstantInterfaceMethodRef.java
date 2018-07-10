package me.matrix4f.cr.cp;

public class ConstantInterfaceMethodRef extends ConstantRef {
    public ConstantInterfaceMethodRef(short classIndex, short natIndex) {
        super(CONSTANT_InterfaceMethodref, classIndex, natIndex);
    }
}
