
public class StringManipulator {
	String trimAndConcat(String a, String b) {
		return (a.trim()+b.trim());		
	}
	Integer getIndexOrNull(String a, char b) {
		if(a.indexOf(b)!=-1)
			return a.indexOf(b);
		else
			return null;
	}

	Integer getIndexOrNull(String a, String b) {
		if(a.indexOf(b)!=-1)
			return a.indexOf(b);
		else
			return null;
	}

	String concatSubstring(String a, int b, int c, String d) {
		return a.substring(b, c).concat(d);
	}
}
