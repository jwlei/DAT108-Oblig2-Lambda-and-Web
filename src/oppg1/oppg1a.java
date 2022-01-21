package oppg1;

	import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;

	public class oppg1a {

	    public static void main(String[] args) {

	        List<String> tallListe = Arrays.asList("10", "1", "20", "110", "21", "12");
	        Collections.sort(tallListe, (String s1, String s2) ->
	        {
	            Integer verdi1 = Integer.parseInt(s1);
	            Integer verdi2 = Integer.parseInt(s2);
	            return verdi1.compareTo(verdi2);
	        });
	        System.out.println(tallListe);
	    }

}
