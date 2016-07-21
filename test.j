	; CSX Lite program translated into Java bytecodes (Jasmin format)
	.class	public  test
	.super	java/lang/Object
	.method	 public static  main([Ljava/lang/String;)V
	.limit	locals  2
	ldc	123
	istore	0
	ldc	456
	istore	1
	iload	0
	iload	0
	iadd
	istore	0
	iload	0
	iload	1
	iadd
	ldc	100
	isub
	invokestatic	 CSXLib/printInt(I)V
	return
	.limit	stack  10
	.end	method
