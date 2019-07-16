/**
 * 
 */
/*
 * package com.example.demomicroservice2;
 * 
 * import java.time.LocalDateTime; import java.time.format.DateTimeFormatter;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.scheduling.annotation.Scheduled; import
 * org.springframework.stereotype.Component;
 * 
 * import com.example.demomicroservice2.service.RoundService;
 * 
 *//**
	 * @author juhi.b.jain
	 *
	 *//*
		 * @Component public class RoundStatusScheduler {
		 * 
		 * @Autowired RoundService roundService;
		 * 
		 * private static final Logger logger =
		 * LoggerFactory.getLogger(RoundStatusScheduler.class); private static final
		 * DateTimeFormatter dateTimeFormatter =
		 * DateTimeFormatter.ofPattern("HH:mm:ss");
		 * 
		 * @Scheduled(cron = "0 04 16 * * *", zone = "IST") public void closeRounds() {
		 * logger.info("Fixed Rate Task :: Execution Time - {}",
		 * dateTimeFormatter.format(LocalDateTime.now()) ); roundService.closeRounds();
		 * }
		 * 
		 * 
		 * @Scheduled(fixedRate = 5000) public void scheduleTaskWithFixedRate() {
		 * logger.
		 * info("Fixed Rate Task :: Execution Time of scheduleTaskWithFixedRate - {}",
		 * dateTimeFormatter.format(LocalDateTime.now()) ); }
		 * 
		 * 
		 * 
		 * }
		 */