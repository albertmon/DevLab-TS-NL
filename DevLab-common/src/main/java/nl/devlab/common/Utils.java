package nl.devlab.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Utils {

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
	
	public static long copy(InputStream is, OutputStream os) {
		
		byte[] buf = new byte[8192];
		long total = 0;
		int len = 0;
		
		try {
			while (-1 != (len = is.read(buf))) {
				os.write(buf, 0, len);
				total += len;
			}
		} catch (IOException ioe) {
			throw new RuntimeException("error reading stream", ioe);
		}
		
		return total;
	}

	/**
	 * @param input
	 *            string value
	 * @return true if it's a number else false
	 */
	public static boolean isNumber(final String input) {
		boolean rtnResult = false;

		try {
			Integer.parseInt(input);
			rtnResult = true;
		} catch (NumberFormatException e) {

		}
		return rtnResult;
	}

	public static byte[] getBytes(InputStream is) throws IOException {

		int len;
		int size = 1024;
		byte[] buf;

		if (is instanceof ByteArrayInputStream) {
			size = is.available();
			buf = new byte[size];
			len = is.read(buf, 0, size);
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			buf = new byte[size];
			while ((len = is.read(buf, 0, size)) != -1) {
				bos.write(buf, 0, len);
			}
			buf = bos.toByteArray();
		}
		return buf;
	  }
	
	public static String formatRoundUp(String formatTemplate, Double value) {
		
		DecimalFormat df = new DecimalFormat(formatTemplate);
		df.setRoundingMode(RoundingMode.HALF_UP);
		
		String foramttedValue = df.format(value);
		
		return foramttedValue;
	  }

	
}
