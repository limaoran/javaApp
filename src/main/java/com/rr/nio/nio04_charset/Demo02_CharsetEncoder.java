package com.rr.nio.nio04_charset;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * 编码
 * @author Administrator
 *
 */
public class Demo02_CharsetEncoder {
	public static void main(String[] args) throws CharacterCodingException, UnsupportedEncodingException {
		
		Charset charset = Charset.forName("UTF-8");

		//得到我们的编码器
		CharsetEncoder encoder = charset.newEncoder();
		//得到我们的解码器
		CharsetDecoder decoder = charset.newDecoder();
		
		CharBuffer charBuf = CharBuffer.wrap("济南的泉水！");
		//编码
		ByteBuffer byteBuf = encoder.encode(charBuf);
//		byteBuf.flip();
//		System.out.println(new String(byteBuf.array(),"UTF-8"));
		
		//解码
		CharBuffer charBuf2 = decoder.decode(byteBuf);
		charBuf2.flip();
		System.out.println(new String(charBuf2.array()));
	}
}
