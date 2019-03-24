package common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final LocalDateTime TODAY = LocalDateTime.now();

    private static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DateUtils.YYYY_MM_DD);

}
