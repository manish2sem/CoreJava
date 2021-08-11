package DessignPattern.HeadFirst.Decorator.JvaBuiltinSupport.IOdecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * write a decorator that converts all uppercase characters to lowercase in the input stream.
 *  In other words, if we read in “I know the Decorator Pattern therefore I RULE!”
 *  then your decorator converts this to “i know the decorator pattern therefore i rule!”
 * @author sinhama
 *
 */

public class LowerCaseStream extends FilterInputStream{
	public LowerCaseStream(InputStream in){
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}

	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset+result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}


/**
 * FilterInputStream</code> contains some other input stream, 
 * which it uses as  its  basic source of data, 
 * possibly transforming  * the data along the way or providing  additional functionality. 
 */
