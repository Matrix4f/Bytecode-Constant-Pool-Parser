# Bytecode-Constant-Pool-Parser
An easy-to-use library for reading the ConstantPool section of class files dealing with Java bytecode.

# Example (How-to-use)

```java
try {
    byte[] classbytes = IO.dump(new FileInputStream("ClassFile.class"));
    CpoolReader cr = new CpoolReader(classbytes);
    cr.read();

    for (Constant cst : cr.getCpool()) {
        //Do stuff here!
    }
} catch (IOException e) {
    e.printStackTrace();
}
```
