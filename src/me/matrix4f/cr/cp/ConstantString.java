package me.matrix4f.cr.cp;

public class ConstantString extends Constant {

    private short valueIndex;

    public ConstantString(short valueIndex) {
        super(CONSTANT_String);
        this.valueIndex = valueIndex;
    }

    public short getValueIndex() {
        return valueIndex;
    }
}
