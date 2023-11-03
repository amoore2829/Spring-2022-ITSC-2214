package Exceptions;

public class ElementNotFoundException extends Exception {

    public ElementNotFoundException() {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: invokespecial java/lang/Exception."<init>":()V
         * 4: return
         *  */
        // </editor-fold>
    }

    public ElementNotFoundException(String el) {
        // <editor-fold defaultstate="collapsed" desc="Compiled Code">
        /* 0: aload_0
         * 1: new           java/lang/StringBuilder
         * 4: dup
         * 5: invokespecial java/lang/StringBuilder."<init>":()V
         * 8: ldc           The element
         * 10: invokevirtual java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         * 13: aload_1
         * 14: invokevirtual java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         * 17: ldc           was not found in the collection.
         * 19: invokevirtual java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
         * 22: invokevirtual java/lang/StringBuilder.toString:()Ljava/lang/String;
         * 25: invokespecial java/lang/Exception."<init>":(Ljava/lang/String;)V
         * 28: return
         *  */
        // </editor-fold>
    }
}
