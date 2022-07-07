package alan.analizador.util;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Util {
	public static DateTimeFormatter getFormatter(){
		return DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM )
			.withLocale(Locale.UK)
			.withZone(ZoneId.of("America/Guatemala"));
	}
}
