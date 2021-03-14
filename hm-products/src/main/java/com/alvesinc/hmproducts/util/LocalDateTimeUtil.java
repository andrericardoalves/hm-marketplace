package com.alvesinc.hmproducts.util;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeUtil {

	public static boolean isSameDay(LocalDateTime timestamp,  LocalDateTime timestampToCompare) {
			    return timestamp.truncatedTo(ChronoUnit.DAYS)
			      .isEqual(timestampToCompare.truncatedTo(ChronoUnit.DAYS));
  }
}
