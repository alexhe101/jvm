package com.alex.instructions.references;

import com.alex.instructions.base.Index16Instruction;
import com.alex.instructions.base.MethodInovkeLogic;
import com.alex.rtda.Frame;
import com.alex.rtda.heap.Method;
import com.alex.rtda.heap.MethodRef;
import com.alex.rtda.heap.RuntimeConstantPool;

public class INVOKE_STATIC extends Index16Instruction {
    @Override
    public void execute(Frame frame) {
        RuntimeConstantPool runtimeConstantPool = frame.getMethod().getClazz().getConstantPool();
        MethodRef methodRef = (MethodRef) runtimeConstantPool.getConstant(getIndex()).getValue();
        Method resolvedMethod = methodRef.resolvedMethod();
        if(!resolvedMethod.isStatic())
        {
            throw new IncompatibleClassChangeError();
        }
        MethodInovkeLogic.InvokeMethod(frame,resolvedMethod);
    }
}
