package util;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConversaoDeDataUtil {

	public static LocalDateTime timestampToLocalDateTime(Timestamp dataEmTimestamp) {
		LocalDateTime dataEmLocalDateTime = dataEmTimestamp.toLocalDateTime();
		return dataEmLocalDateTime;
	}

	public static Timestamp localDateTimeToTimestamp(LocalDateTime dataEmLocalDateTime) {
		Timestamp dataEmTimestamp = Timestamp.valueOf(dataEmLocalDateTime);
		return dataEmTimestamp;
	}

	public static LocalDate dateToLocalDate(Date dataEmDate) {
		LocalDate dataEmLocalDate = dataEmDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return dataEmLocalDate;
	}

	public static Date localDateToDate(LocalDate dataEmLocalDate) {
		Date dataEmDate = Date.valueOf(dataEmLocalDate);
		return dataEmDate;
	}
}
