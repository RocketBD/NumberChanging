package util;

public class Util {
	
	public static int numberToDEC(String input,char type) {
		int sum = 0;
		switch (type) {
		case Constant.jz2:
			for(int i=input.length()-1;i>=0;i--) {
				int x = input.charAt(i);
				if(x!='0') {
					sum += (x-'0')*(int)Math.pow(2, input.length()-i-1);
				}
			}
			return sum;
		case Constant.jz8:
			for(int i=input.length()-1;i>=0;i--) {
				int x = input.charAt(i);
				if(x!='0') {
					sum += (x-'0')*(int)Math.pow(8, input.length()-i-1);
				}
			}
			return sum;
		case Constant.jz16:
			for(int i=input.length()-1;i>=0;i--) {
				int x = input.charAt(i);
				if(x!='0') {
					if(x>='a'&&x<='f') {
						x = x - 'a' + 10;
					}else if(x>='A'&&x<='F') {
						x = x - 'A' +10;
					}else {
						x -= '0';
					}
					sum += x*(int)Math.pow(16, input.length()-i-1);
				}
			}
			return sum;
		default:
			for(int i=input.length()-1;i>=0;i--) {
				int x = input.charAt(i);
				if(x!='0') {
					sum += (x-'0')*(int)Math.pow(10, input.length()-i-1);
				}
			}
			return sum;
		}
	}
	
	public static boolean charCheckO(char c) {
		if(c<='9'&&c>='0') {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean charCheckH(char c) {
		if(charCheckO(c)) {
			return true;
		}else if((c<='f'&&c>='a')||c<='F'&&c>='A'){
			return true;
		}else {
			return false;
		}
	}

	
	public static String setHEX(Integer input) {
		int temp = input.intValue();
		if(temp==0) {
			return "0";
		}
		char[] output;
		int[] t = new int[100];
		int size = 0;
		for(@SuppressWarnings("unused")
		int i=0;temp>0;i++) {
			if(size==t.length) {
				Util.getBigger(t);
			}
			t[size] = temp % 16;
			size++;
			temp = (int)temp / 16;
		}
		output = new char[size];
		for(int i=size-1;i>=0;i--) {
			int x = t[i];
			if(x>9) {
				output[size-i-1] = (char)(x+'A'-10);
			}else {
				output[size-i-1] = (char) (x+'0');
			}
		}
		return new String(output);
	}

	
	public static String setBIN(Integer input) {
		int temp = input.intValue();
		if(temp==0) {
			return "0";
		}
		char[] output;
		int[] t = new int[100];
		int size = 0;
		for(@SuppressWarnings("unused")
		int i=0;temp>0;i++) {
			if(size==t.length) {
				Util.getBigger(t);
			}
			t[size] = temp % 2;
			size++;
			temp = (int)temp / 2;
		}
		output = new char[size];
		for(int i=size-1;i>=0;i--) {
			output[size-i-1] = (char) (t[i]+'0');
		}
		return new String(output);
	}

	
	public static String setOCT(Integer input) {
		int temp = input.intValue();
		if(temp==0) {
			return "0";
		}
		char[] output;
		int[] t = new int[100];
		int size = 0;
		for(@SuppressWarnings("unused")
		int i=0;temp>0;i++) {
			if(size==t.length) {
				Util.getBigger(t);
			}
			t[size] = temp % 8;
			size++;
			temp = (int)temp / 8;
		}
		output = new char[size];
		for(int i=size-1;i>=0;i--) {
			output[size-i-1] = (char) (t[i]+'0');
		}
		return new String(output);
	}
	
	public static int[] getBigger(int[] input) {
		int[] output = new int[input.length*2];
		System.arraycopy(input, 0, output, 0, input.length);
		return output;
	}
}
