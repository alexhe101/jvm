package com.alex.classfile.constantInfo;

import com.alex.classfile.ClassReader;
import com.alex.classfile.ConstantInfo;
import com.alex.classfile.ConstantPool;

/**
 * @program: jvm
 * @description:
 * @author: alex101
 * @create: 2022-01-27 16:36
 **/
public class ConstantFieldrefInfo extends ConstantMemberRefInfo {
    public ConstantFieldrefInfo(ConstantPool constantPool) {
        super(constantPool);
    }
}
