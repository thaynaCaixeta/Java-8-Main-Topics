import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate hoje = LocalDate.now();
		System.out.println("Hoje: " + hoje.format(formatador));
		
		LocalDate olimpiadasTokio = LocalDate.of(2021, Month.JULY, 23);
		System.out.println("Olimpiadas Tokio: " + olimpiadasTokio.format(formatador));
		
		Period intervalo = Period.between(hoje, olimpiadasTokio);
		
		LocalDate proximasOlimpiadas = olimpiadasTokio.plusYears(4);
		
		System.out.println("Proximas olimpiadas: " + proximasOlimpiadas.format(formatador));
		System.out.println("Intervalo até as próximas olimpíadas: " + intervalo);
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println("Data com hora: " + agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm")));
		
		LocalTime hora = LocalTime.of(15,  30);
		System.out.println(hora);
	}
}
