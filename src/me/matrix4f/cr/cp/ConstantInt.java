package me.matrix4f.cr.cp;

public class ConstantInt extends Constant {

    private int value;

    public ConstantInt(int value) {
        super(CONSTANT_Integer);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
