package com;

import java.io.*;
import java.text.SimpleDateFormat;

public class HelpingMethods {

	public void p(String s) {
		java.lang.System.out.println(s);
	}

	public String cubicArrayToString(int[][] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + arrayToString(a[i]) + "\n";
		}
		return s;
	}

	public String arrayToString(int[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i] + "|";
		}
		return s;
	}

	public String arrayToString(boolean[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i] + "|";
		}
		return s;
	}

	public String arrayToString(double[] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			s = s + a[i] + "|";
		}
		return s;
	}

	public void printArray(boolean[] a) {
		p("");
		PrintStream z = java.lang.System.out;
		for (int i = 0; i < a.length; i++) {
			z.print("" + a[i] + "|");
		}
		p("");
	}

	public void printArray(String[] a) {
		p("");
		PrintStream z = java.lang.System.out;
		for (int i = 0; i < a.length; i++) {
			z.print("" + a[i] + "|");
		}
		p("");
	}

	public void printArray(int a[][][]) {

		for (int i = 0; i < a.length; i++) {
			p("array " + (i + 1) + ":");
			if (a[i] != null) {
				printArray(a[i]);
			}
		}
	}

	public void printArray(int a[][]) {
		for (int i = 0; i < a.length; i++) {
			java.lang.System.out.print("\n|");
			for (int j = 0; a[i] != null && j < a[i].length; j++) {
				java.lang.System.out.print(a[i][j] + "|");
				if ((j + 1) % 4 == 0 && j > 1) {
					java.lang.System.out.print("  ");
				}
			}
		}
		p("");
	}

	public void printArray(String[][] a) {
		for (int i = 0; i < a.length; i++) {
			printArray(a[i]);
		}
	}

	public void printArray(double a[][]) {
		for (int i = 0; i < a.length; i++) {
			java.lang.System.out.print("\n|");
			for (int j = 0; a[i] != null && j < a[i].length; j++) {
				java.lang.System.out.print(a[i][j] + "|");
				if ((j + 1) % 4 == 0 && j > 1) {
					java.lang.System.out.print("  ");
				}
			}
		}
		p("");
	}

	public double sum(double[] a) {
		double sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public int sum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public int sum(int[][] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
		}
		return sum;
	}

	public int sumFromTo(int[] a, int min, int max) {
		int sum = 0;
		for (int k = min; k <= max; k++) {
			sum += a[k];
		}
		return sum;
	}

	public void printArray(Object a[]) {
		for (Object x : a)
			p("" + x);
	}

	public void printArray(int a[]) {
		p("" + arrayToString(a));
	}

	public void printArray(double a[]) {
		for (int i = 0; i < a.length; i++) {
			java.lang.System.out.print("" + a[i] + "|");
		}
		p("\n");
	}

	public String[] fillArray(String[] a, String s) {
		for (int i = 0; i < a.length; i++) {
			a[i] = s;
		}
		return a;
	}

	public int[] fillArray(int[] a, int x) {
		for (int i = 0; i < a.length; i++) {
			a[i] = x;
		}
		return a;
	}

	public int[][] fillArray(int[][] a, int x) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = x;
			}
		}
		return a;
	}

	public double[][] fillArray(double[][] a, double x) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = x;
			}
		}
		return a;
	}

	public double[] fillArray(double[] a, double x) {
		for (int j = 0; j < a.length; j++) {
			a[j] = x;
		}
		return a;
	}

	public static double[][][] fillArray(double[][][] a, double val) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (int k = 0; k < a[i][j].length; k++) {
					a[i][j][k] = val;
				}
			}
		}
		return a;
	}

	public String[][][] fillArray(String[][][] a, String s) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (int k = 0; k < a[i][j].length; k++) {
					a[i][j][k] = s;
				}
			}
		}
		return a;
	}

	public String[][][][] fillArray(String[][][][] a, String s) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				for (int k = 0; k < a[i][j].length; k++) {
					for (int l = 0; l < a[i][j][k].length; l++) {
						a[i][j][k][l] = s;
					}
				}
			}
		}
		return a;
	}

	public double factorial(int x) {
		if (x < 0) {
			p("Fehler: factorial fuer " + x + " nicht definiert");
			return 0;
		}
		if (x < 2) {
			return 1;
		}
		return x * factorial(x - 1);
	}

	public boolean equals(int[][] a, int[][] b) {
		if (a.length == b.length) {
			for (int i = 0; i < a.length; i++) {
				if (a[i] == null && b[i] != null || b[i] == null && a[i] != null || a[i].length != b[i].length) {
					return false;
				}
				for (int j = 0; j < a[i].length; j++) {
					if (a[i][j] != b[i][j])
						return false;
				}
			}
		}
		return true;
	}

	public int[] flip(int[] a) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			b[b.length - 1 - i] = a[i];
		}
		return b;
	}

	public int indexOf(String[] a, String s) {
		if (a == null) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null && a[i].equals(s)) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(double[] a, double x) {
		if (a == null) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(boolean[] a, boolean x) {
		if (a == null) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public int indexOf(int[] a, int x) {
		if (a == null) {
			return -1;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public int[] indexesOf(boolean[] a, boolean x) {
		int[] ix = new int[0];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				ix = copyArray(ix, 1);
				ix[count] = i;
				count++;
			}
		}
		if (count == 0) {
			return new int[] { -1 };
		}
		return ix;
	}

	public int[] indexesOf(int[] a, int x) {
		int[] ix = new int[0];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (x == a[i]) {
				ix = copyArray(ix, 1);
				ix[count] = i;
				count++;
			}
		}
		if (count == 0) {
			return new int[] { -1 };
		}
		return ix;
	}

	public boolean containsSubstring(String[] a, String s) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null && a[i].contains(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(String[] a, String s) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null && a[i].equals(s)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int[] a, int x) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(double[] a, double x) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(boolean[] a, boolean x) {
		if (a == null) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int[][] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (indexOf(a[i], x) > -1) {
				return true;
			}
		}
		return false;
	}

	public int indexOfContains(int[][] a, int x) {
		for (int i = 0; i < a.length; i++) {
			if (contains(a[i], x)) {
				return i;
			}
		}
		return -1;
	}

	public int indexOfContains(double[][] a, double x) {
		for (int i = 0; i < a.length; i++) {
			if (contains(a[i], x)) {
				return i;
			}
		}
		return -1;
	}

	public int count(int[] a, int x) {
		if (a == null) {
			return 0;
		}
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				c++;
			}
		}
		return c;
	}

	public int count(int[][] a, int x) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += count(a[i], x);
		}
		return sum;
	}

	public int count(int[][] a, int x, boolean skipLast) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += count(copyArray(a[i], -1), x);
		}
		return sum;
	}

	public boolean[] flip(boolean[] a) {
		boolean[] b = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = !a[i];
		}
		return b;
	}

	public boolean[] multiply(boolean[] a, boolean[] b) {
		boolean[] c = new boolean[Math.min(a.length, b.length)];
		for (int i = 0; i < a.length && i < b.length; i++) {
			c[i] = a[i] && b[i];
		}
		return c;
	}

	public int count(boolean[] a, boolean x) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				sum++;
			}
		}
		return sum;
	}

	public double[] copyArray(double[] a, int firstIndex, int lastIndex) {
		if (a == null) {
			return null;
		}
		double[] b = new double[lastIndex - firstIndex + 1];
		for (int i = firstIndex; i <= lastIndex; i++) {
			b[i - firstIndex] = a[i];
		}
		return b;
	}

	public double[] copyArray(double[] a, int additionalSpace) {
		if (a == null) {
			if (additionalSpace <= 0) {
				return null;
			} else {
				return new double[additionalSpace];
			}
		}
		double[] b = new double[Math.max(0, a.length + additionalSpace)];
		for (int i = 0; i < a.length && i < b.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public String[] copyArray(String[] a) {
		if (a == null)
			return null;
		String[] array = new String[a.length];
		for (int i = 0; i < a.length; i++) {
			array[i] = a[i];
		}
		return array;
	}

	public String[][] copyArray(String[][] a) {
		String[][] array = new String[a.length][];
		for (int i = 0; i < a.length; i++) {
			array[i] = copyArray(a[i]);
		}
		return array;
	}

	public int[] copyArray(int[] a) {
		return copyArray(a, 0);
	}

	public int[] copyArray(int[] a, int additionalSpace) {
		if (a == null) {
			if (additionalSpace <= 0) {
				return null;
			} else
				return new int[additionalSpace];
		}
		int[] b = new int[Math.max(0, a.length + additionalSpace)];
		for (int i = 0; i < b.length && i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public int[][] copyArray(int[][] a) {
		if (a == null) {
			return null;
		}
		int[][] b = new int[a.length][];
		for (int i = 0; i < b.length; i++) {
			b[i] = copyArray(a[i]);
		}
		return b;
	}

	public int[][][] copyArray(int[][][] a, int additionalSpace) {
		if (a == null) {
			return null;
		}
		int[][][] b = new int[a.length + additionalSpace][][];
		for (int i = 0; i < a.length && i < b.length; i++) {
			b[i] = copyArray(a[i]);
		}
		return b;
	}

	public boolean[] copyArray(boolean[] a) {
		return copyArray(a, 0);
	}

	public boolean[] copyArray(boolean[] a, int additionalSpace) {
		boolean[] b = new boolean[Math.max(0, a.length + additionalSpace)];
		for (int i = 0; i < a.length && i < b.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public int[] minus(int[] c, int[] d) {
		int[] a = copyArray(c);
		int[] b = copyArray(d);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] == b[i]) {
					a[j] = a[a.length - 1];
					b[i] = b[b.length - 1];
					a = copyArray(a, -1);
					b = copyArray(b, -1);
					j = a.length;
					i--;
				}
			}
		}
		return a;
	}

	public int[] plus(int[] a, int[] b) {
		if ((a == null || a.length == 0) && (b == null || b.length == 0)) {
			return null;
		}
		if (a == null)
			a = new int[0];
		if (b == null)
			b = new int[0];
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for (int i = a.length; i < c.length; i++) {
			c[i] = b[i - a.length];
		}
		return c;
	}

	public int[] plus(int[] a, int[] b, int[] c) {
		if ((a == null || a.length == 0) && (b == null || b.length == 0) && (c == null || c.length == 0)) {
			return null;
		}
		return plus(plus(a, b), c);
	}

	public boolean[] plus(boolean[] a, boolean[] b) {
		boolean[] c = new boolean[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for (int i = a.length; i < c.length; i++) {
			c[i] = b[i - a.length];
		}
		return c;
	}

	public int[] allGreaterThan(int[] a, int lim, boolean greater) {
		int[] b = new int[0];
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (greater == a[i] > lim) {
				b = copyArray(b, 1);
				b[count] = a[i];

				count++;
			}
		}
		return b;
	}

	public int maximum(int[][] a) {
		int max = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; a[i] != null && j < a[i].length; j++) {
				max = Math.max(max, a[i][j]);
			}
		}
		return max;
	}

	public int maximum(int[] a) {
		int max = a[0];
		for (int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	public double maximum(double[] a) {
		double max = a[0];
		for (int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i]);
		}
		return max;
	}

	public int minimum(int[] a) {
		int min = a[0];
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
		}
		return min;
	}

	public double minimum(double[] a) {
		double min = a[0];
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
		}
		return min;
	}

	public String[] copyArray(String[] a, int additionalSpace) {
		if (a == null) {
			if (additionalSpace <= 0) {
				return null;

			} else
				return new String[additionalSpace];
		}
		String[] b = new String[a.length + additionalSpace];
		for (int i = 0; i < b.length && i < a.length; i++) {
			b[i] = a[i];
		}
		return b;
	}

	public int[] getArrayByString(String s) {
		s = s.replace(" ", "").replace("|", " ");

		String[] b = s.split(" ");

		int[] a = new int[b.length - 1];
		for (int i = 1; i < b.length; i++) {
			a[i - 1] = Integer.parseInt(b[i]);
		}
		return a;
	}

	public boolean[] getBooleanArrayByString(String s) {
		s = s.replace(" ", "").replace("|", " ");

		String[] b = s.split(" ");

		boolean[] a = new boolean[b.length - 1];
		for (int i = 1; i < b.length; i++) {
			a[i - 1] = Boolean.parseBoolean(b[i]);
		}
		return a;
	}

	public double[] getDoubleArrayByString(String s) {
		s = s.replace(" ", "").replace("|", " ");

		String[] b = s.split(" ");

		double[] a = new double[b.length - 1];
		for (int i = 1; i < b.length; i++) {
			a[i - 1] = Double.parseDouble(b[i]);
		}
		return a;
	}

	public String readFile(String path) {
		String filetext = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			for (String line; (line = reader.readLine()) != null;) {
				filetext = filetext + line + "\n";
			}
			reader.close();
		} catch (Exception e) {
			p("File " + path + " doesn't exist");
		}
		return filetext;
	}

	public void printToFile(String path, String s, boolean append) {
		String[] values = new String[0];
		String history = "";
		if (append) {
			history = readFile(path);
		}
		history = history + s;
		values = history.split("\n");
		try {
			FileOutputStream fOS = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fOS);
			BufferedWriter br = new BufferedWriter(osw);
			for (String value : values) {
				br.write(value, 0, value.length());
				br.newLine();

			}
			br.flush();
			br.close();
		} catch (Exception e) {
			p(e.toString());
		}
	}

	public String stackTraceToString(StackTraceElement[] trace) {
		String s = "";
		for (int i = 0; i < trace.length; i++) {
			s += trace[i] + "\n";
		}
		return s;
	}

	public static String executeCommand(String command) {
		String[] commandAndArgs;
		if (!System.getProperty("os.name").contains("indows"))
			commandAndArgs = new String[] { "bash", "-c", command };
		else
			commandAndArgs = new String[] { "cmd", "/c", command };
		String result = "";
		try {
			Process process = Runtime.getRuntime().exec(commandAndArgs);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (String line; (line = reader.readLine()) != null;) {
				result = result + line + "\n";
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String[] getCoordinatesAndLocation(String ip) {
		String command = "nmap -Pn -sS -p80 --script ip-geolocation-geoplugin " + ip;
		String output = executeCommand(command);
		int coordinatesBeginning = output.indexOf("coordinates:");
		if (coordinatesBeginning == -1) {
			coordinatesBeginning = output.indexOf("coordinates (lat,lon):");
			if (coordinatesBeginning == -1) {
				p("Error: got no coordinates for ip " + ip);
				return new String[] { "", "" };
			}
			coordinatesBeginning += 9;
		}
		String location = output.substring(coordinatesBeginning + 13);
		String[] coordinates = location.substring(0, location.indexOf("\n")).split(",");
		String country = location
				.substring(Math.max(location.indexOf("location:") + 10, location.indexOf("state:") + 7));
		return new String[] { coordinates[1] + "," + coordinates[0], country };
	}

	public String getDateNow(String format)// Methode, die das aktuelle Datum als String im entsprechenden Format
											// zurückgibt
	{
		java.util.Date dateNow = new java.util.Date(java.lang.System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(dateNow);
	}

	public String getDateByMillis(String format, long millis) {
		java.util.Date date = new java.util.Date(millis);
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
}
