import java.util.HashMap;
import java.util.Set;

public class HashMaps {

	public static void main(String[] args) {
		HashMap<String, String> trackList = new HashMap<String, String>();
		trackList.put("Que calor", "Que calor, oeo,\r\n" + 
				"Que calor que tengo yo\r\n" + 
				"Que levante la mano\r\n" + 
				"Como yo\r\n" + 
				"El que quiere un vino en cart�n\r\n" + 
				"El que quiere un vino en cart�n");
		trackList.put("Un beso y una flor", "Dejar� mi casa por ti\r\n" + 
				"dejar� mi barrio y me ir�\r\n" + 
				"lejos de aqui\r\n" + 
				"cruzar� llorando el jard�n\r\n" + 
				"y con tus recuerdos partir�\r\n" + 
				"lejos de aqu�");
		trackList.put("No me vuelvo a enamorar", "No me vuelvo a enamorar para sufrir\r\n" + 
				"no me vuelvo a enamorar menos de ti\r\n" + 
				"no me vuelvo a enamorar para llorar\r\n" + 
				"no me vuelvo a enamorar nunca jamas");
		trackList.put("Yo tomo licor", "Yo tomo licor, yo tomo cerveza\r\n" + 
				"Y me gustan las chicas\r\n" + 
				"Y la cumbia me divierte y me excita\r\n" + 
				"Salgo a caminar\r\n" + 
				"Recorro boliches\r\n" + 
				"Me pierdo en las noches\r\n" + 
				"Vivimos cosas buenas junto a mis amigos");

		Set<String> keys = trackList.keySet();
		for(String key : keys) {
			System.out.println("\n\n"+key+": \n"+trackList.get(key));
		}
	}

}
