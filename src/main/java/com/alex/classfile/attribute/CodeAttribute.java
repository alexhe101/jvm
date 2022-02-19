package com.alex.classfile.attribute;

import com.alex.classfile.AttributeInfo;
import com.alex.classfile.ClassReader;
import com.alex.classfile.ConstantPool;

public class CodeAttribute extends AttributeInfo {
    private ConstantPool constantPool;
    private  int maxStack;
    private  int maxLocals;
    private byte[] code;
    private ExceptionTableEntry[] exceptionTable;
    private AttributeInfo[] attributes;

    public CodeAttribute(ConstantPool constantPool) {
        this.constantPool = constantPool;
    }


    @Override
    public void readInfo(ClassReader classReader) {
        maxStack = classReader.readUint16();
        maxLocals = classReader.readUint16();
        int codeLength = classReader.readUint32();
        code = classReader.readBytes(codeLength);
        exceptionTable = readExceptionTable(classReader);
        attributes = readAttributes(classReader,constantPool);
    }

    private ExceptionTableEntry[] readExceptionTable(ClassReader classReader)
    {
        int len = classReader.readUint16();
        exceptionTable = new ExceptionTableEntry[len];
        for (int i = 0; i < len; i++) {
            exceptionTable[i] = new ExceptionTableEntry(classReader);
        }
        return exceptionTable;
    }
}
