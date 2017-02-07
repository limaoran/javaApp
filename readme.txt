
一：缓冲区

	1.一定要明白nio都是以缓冲区进行操作的。
	2.缓冲区对于各个基本数据类型都有实现，除了Boolean类型之外。
	3.缓冲区存在position，limit，capacity三个状态变量。
	4.缓冲区的操作中通过allocate()创建缓冲区，或使用只读、直接缓冲区。
	
二：通道
	文件的读入方式：
		1.RandomAccessFile	较慢
		2.FileInputStream	较慢
		3.缓冲读取			较快
		4.内存映射			最快
		MappedByteBuffer使用此种方式读取的内容是最快的。它需要将一个输入流绑定
		

三：文件锁
	1.了解FileLock类的基本操作即可
	2.通过通道取得FileLock的实例化对象。

四：字符集
	1.了解Charset类的作用
	2.了解编码和解码的操作
	

