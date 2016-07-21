
.class public Demi
.super java/lang/Object

.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

.method public static main([Ljava/lang/String;)V

   ; push System.out onto the stack
   getstatic java/lang/System/out Ljava/io/PrintStream;

   ; push a string onto the stack
   ldc 1234567890

   ; call the PrintStream.println() method.
   invokevirtual java/io/PrintStream/println(I)V

   ; done
   .limit stack 1
   return
.end method
