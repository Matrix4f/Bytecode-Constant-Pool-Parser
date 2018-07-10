package me.matrix4f.cr.cp;

public class ConstantMethodRef extends ConstantRef {
    public ConstantMethodRef(short classIndex, short natIndex) {
        super(CONSTANT_Methodref, classIndex, natIndex);
    }
}
