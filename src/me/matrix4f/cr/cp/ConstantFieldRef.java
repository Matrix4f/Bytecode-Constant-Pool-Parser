package me.matrix4f.cr.cp;

public class ConstantFieldRef extends ConstantRef {
    public ConstantFieldRef(short classIndex, short natIndex) {
        super(CONSTANT_Fieldref, classIndex, natIndex);
    }
}
