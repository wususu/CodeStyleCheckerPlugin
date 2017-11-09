package checker;

public class StringUtils {

	public static boolean isClassName(String s){
		System.out.println("in");
		char[] c = s.toCharArray();
		
		return ( 
				Character.isUpperCase(c[0]) 
				&&
				Character.isLowerCase(c[1])
				);
	}
	
	public static boolean isMethodName(String s){
		char[] c = s.toCharArray();
	
		return ( 
				Character.isLowerCase(c[0])
				);
	}
	
	public static boolean isFieldName(String s){
		char[] c = s.toCharArray();
		
		return ( 
				Character.isLowerCase(c[0])
				);
	}
	
	public static boolean isConstName(String s){
		boolean checker = true;
		char[] c = s.replace("_", "").toCharArray();
		for (char d : c) {
			checker = checker && Character.isUpperCase(d);
		}
		
		return checker;
	}
}
