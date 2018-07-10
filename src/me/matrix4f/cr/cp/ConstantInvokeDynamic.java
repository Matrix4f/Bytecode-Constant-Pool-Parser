package me.matrix4f.cr.cp;

public class ConstantInvokeDynamic extends Constant {

    private short bootstrapMethodAttrIndex, natIndex;

    public ConstantInvokeDynamic(short bootstrapMethodAttrIndex, short natIndex) {
        super(CONSTANT_InvokeDynamic);
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.natIndex = natIndex;
    }

    public short getNatIndex() {
        return natIndex;
    }

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }
}
