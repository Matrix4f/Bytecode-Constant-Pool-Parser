package me.matrix4f.cr.cp;

public class ConstantClass extends Constant {

    private short namePointer;

    public ConstantClass(short namePointer) {
        super(CONSTANT_Class);
        this.namePointer = namePointer;
    }

    public short getNamePointer() {
        return namePointer;
    }
}
