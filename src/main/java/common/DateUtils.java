package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final LocalDateTime TODAY_DATE = LocalDateTime.now();
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DateUtils.YYYY_MM_DD);

    public static final String TODAY = TODAY_DATE.format(DateUtils.FORMATTER);
}
