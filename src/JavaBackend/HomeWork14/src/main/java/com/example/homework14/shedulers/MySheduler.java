package com.example.homework14.shedulers;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Configuration
@EnableScheduling
public class MySheduler {
    //      ## 1. Базовые примеры с символом *
    // 1. Каждую секунду
    @Scheduled(cron = "* * * * * *")
    public void everySecond() {
        System.out.println("Выполняется каждую секунду: " + LocalDateTime.now());
    }

    // 2. Каждую минуту в 0 секунд
    @Scheduled(cron = "0 * * * * *")
    public void everyMinuteAtZeroSecond() {
        System.out.println("Выполняется каждую минуту в 0 секунд: " + LocalDateTime.now());
    }

    // 3. Каждый час в начале часа
    @Scheduled(cron = "0 0 * * * *")
    public void everyHour() {
        System.out.println("Выполняется каждый час: " + LocalDateTime.now());
    }

    // 4. Каждый день в полночь
    @Scheduled(cron = "0 0 0 * * *")
    public void everyDayAtZeroHour() {
        System.out.println("Выполняется каждый день в полночь: " + LocalDateTime.now());
    }

    // 5. Первого числа каждого месяца в полночь
    @Scheduled(cron = "0 0 0 1 * *")
    public void everyFirstDayAtZeroHour() {
        System.out.println("Выполняется каждое 1-е число месяца в полночь: " + LocalDateTime.now());
    }

    //      ## 2. Примеры с конкретным временем
    // 6. Каждый день в 10:30:00
    @Scheduled(cron = "0 30 10 * * *")
    public void everyDayAtHalfEleven() {
        System.out.println("Выполняется каждый день в 10:30 " + LocalDateTime.now());
    }

    // 7. Каждый день в 15:45:30
    @Scheduled(cron = "30 45 15 * * *")
    public void everyDayAt154530() {
        System.out.println("Выполняется каждый день в 15:45:30 " + LocalDateTime.now());
    }

    // 8. Каждое воскресенье в 9:00:00
    @Scheduled(cron = "0 0 9 * * sun")
    public void everySundayAtNine() {
        System.out.println("Выполняется каждое воскресенье в 9:00 " + LocalDateTime.now());
    }

    // 9. Каждый понедельник в 8:15:00
    @Scheduled(cron = "0 15 8 * * mon")
    public void everyMondayAtEightFifteen() {
        System.out.println("Выполняется каждый понедельник в 8:15 " + LocalDateTime.now());
    }

    // 10. 15 января каждого года в 12:00:00
    @Scheduled(cron = "0 0 12 15 jan *")
    public void everyFifteenJanuaryAtTwelve() {
        System.out.println("Выполняется каждого 15 января в 12:00" + LocalDateTime.now());
    }

    // 11. Каждые 30 секунд
    @Scheduled(cron = "0/30 * * * * *")
    public void everyThirtySeconds() {
        System.out.println("Выполняется каждые 30 секунд " + LocalDateTime.now());
    }

    // 12. Каждые 15 минут
    @Scheduled(cron = "0 */15 * * * *")
    public void everyFifteenMinutes() {
        System.out.println("Выполняется каждые 15 минут " + LocalDateTime.now());
    }

    // 13. Каждые 2 часа в начале часа
    @Scheduled(cron = "0 0 */2 * * *")
    public void everyTwoHours() {
        System.out.println("Выполняется каждые 2 часа " + LocalDateTime.now());
    }

    // 14. Каждые 5 дней в полночь
    @Scheduled(cron = "0 0 0 */5 * *")
    public void everyFiveDaysAtZeroHour() {
        System.out.println("Выполняется каждые 5 дней в полночь " + LocalDateTime.now());
    }

    // 15. Каждые 3 месяца первого числа
    @Scheduled(cron = "0 0 0 1 */3 *")
    public void everyThreeMonths() {
        System.out.println("Выполняется каждые 3 месяца первого числа" + LocalDateTime.now());
    }

    //        ## 4. Примеры с символом , (список)
    // 16. В определенные секунды каждой минуты
    @Scheduled(cron = "10,20,30,40 * * * * *")
    public void executeAtCertainSeconds() {
        System.out.println("Выполняется в 10ю, 20ю, 30ю и 40ю секунды каждую минуту " + LocalDateTime.now());
    }

    // 17. В определенные минуты каждого часа
    @Scheduled(cron = "0 15,30,45 * * * *")
    public void executeAtCertainMinutes() {
        System.out.println("Выполняется в 15, 30 и 45 минут каждого часа " + LocalDateTime.now());
    }

    // 18. В рабочие часы (9, 12, 15 часов)
    @Scheduled(cron = "0 0 9,12,15 * * *")
    public void executeAtWorkTime() {
        System.out.println("Выполняется в 9, 12 и 15 часов каждый день" + LocalDateTime.now());
    }

    // 19. В определенные дни недели
    @Scheduled(cron = "0 0 0 * * 1,3,5")
    public void executeAtCertainDayofWeek() {
        System.out.println("Выполняется каждый понедельник, среду и пятницу в полночь" + LocalDateTime.now());
    }

    // 20. В летние месяцы каждую пятницу
    @Scheduled(cron = "0 0 9 * 6-8 fri")
    public void executeAtSummerMonthsFriday() {
        System.out.println("Выполняется каждую пятницу с июня по июль в 9 утра " + LocalDateTime.now());
    }

    //            ## 5. Примеры с символом - (диапазон)
    // 21. Каждую минуту в рабочие часы
    @Scheduled(cron = "0 * 9-18 * * *")
    public void everyMinuteEveryHourAtWorkingTime() {
        System.out.println("Выполняется с 9 до 18 каждую минуту " + LocalDateTime.now());
    }

    // 22. Каждый час в будние дни
    @Scheduled(cron = "0 0 * * * mon-fri")
    public void everyHourEveryWorkingDay() {
        System.out.println("Выполняется каждый час в будние дни " + LocalDateTime.now());
    }

    // 23. В середине каждого месяца
    @Scheduled(cron = "0 0 0 10-20 * * ")
    public void everyMiddleOfMonth() {
        System.out.println("Каждый день в середине месяца(понял как с 10го по 20е число, к примеру) " + LocalDateTime.now());
    }

    // 24. В первой половине года по выходным
    @Scheduled(cron = "0 0 0 * 1-6 sat,sun")
    public void everySaturdayAndSundayAtFirstHalfOfYear() {
        System.out.println("Выполняется каждую субботу и воскресенье в первой половине года " + LocalDateTime.now());
    }

    // 25. Каждые 5 секунд в определенном диапазоне минут
    @Scheduled(cron = "*/5 10-30 * * * *")
    public void everyFiveSecondsBetweenTenAndThirtyMinutes() {
        System.out.println("Выполняется каждые 5 секунд с 10-й по 30ю минуты " + LocalDateTime.now());
    }

    //            ## 6. Примеры с символом L (последний)
    // 26. Последний день каждого месяца в 23:59:59
    @Scheduled(cron = "59 59 23 L * *")
    public void everyLastDayOfMonth() {
        System.out.println("Выполняется в 23:59:59 каждый последний день месяца " + LocalDateTime.now());
    }

    // 27. Последняя пятница каждого месяца в 17:00
    @Scheduled(cron = "0 0 17 * * friL")
    public void everyLastFridayEveryMonth() {
        System.out.println("Выполняется каждую последнюю пятницу месяца в 17:00" + LocalDateTime.now());
    }

    // 28. Последний рабочий день месяца
    @Scheduled(cron = "0 0 0 LW * * ")
    public void everyLastWorkingDay() {
        System.out.println("Выполняется в последний рабочий день каждого месяца " + LocalDateTime.now());
    }

    //## 7. Примеры с символом # (N-й день недели)
// 29. Вторая среда каждого месяца
    @Scheduled(cron = "0 0 0 * * wed#2")
    public void everySecondWednesday() {
        System.out.println("Выполняется каждую вторую среду месяца" + LocalDateTime.now());
    }

    // 30. Третий понедельник каждого месяца в январе и июле
    @Scheduled(cron = "0 0 0 * 1,7 mon#3")
    public void everyThirdMondayJanuaryAndJuly() {
        System.out.println("Выполняется каждый третий понедельник в январе и июле " + LocalDateTime.now());
    }

    //## Дополнительные комплексные примеры
    //### Комбинированные выражения
    // Рабочие дни каждые 30 минут с 9 до 18
    @Scheduled(cron = "0 */30 9-18 * * mon-fri")
    public void everyThirtyMinutesAtWorkingHoursAndDays() {
        System.out.println("Выполняется каждые 30 минут в рабочие часы рабочих дней " + LocalDateTime.now());
    }

    // Каждые 10 секунд в первые 5 минут каждого часа
    @Scheduled(cron = "*/10 0-4 * * * *")
    public void everyTenSecondsEveryFirstFiveMinutes() {
        System.out.println("Выполняется каждые 10 секунд в первые 5 минут " + LocalDateTime.now());
    }

    // Каждый квартал в первый день в полночь
    @Scheduled(cron = "0 0 0 1 1,4,7,10 *")
    public void everyQuarter() {
        System.out.println("Выполняется каждый квартал в первый день в полночь " + LocalDateTime.now());
    }

    // Последнее воскресенье марта (переход на летнее время в EU)
    @Scheduled(cron = "0 0 0 * 3 sunL")
    public void lastSundayOfMarch() {
        System.out.println("Выполняется в последнее воскресенье марта " + LocalDateTime.now());
    }

    // Будние дни каждые 2 часа кроме обеда
    @Scheduled(cron = "0 0 0-12/2,13-23/2 * * 1-5")
    public void everyTwoHoursExceptDinner() {
        System.out.println("Выполняется в будние дни каждые 2 часа кроме обеда " + LocalDateTime.now());
    }

    //### Практические сценарии
// Резервное копирование каждую ночь в 2:30
    @Scheduled(cron = "0 30 2 * * *")
    public void executeBackup() {
        backup();
    }

    // Очистка логов каждое воскресенье в 3:00
    @Scheduled(cron = "0 0 3 * * sun")
    public void executeLogsClearing() {
        logsClearing();
    }

    // Отчет каждый первый рабочий день месяца
    @Scheduled(cron = "0 0 0 1w * *")
    public void executeReportCreator() {
        createReport();
    }

    // Проверка системы каждые 5 минут в рабочее время
    @Scheduled(cron = "0 */5 9-18 * * *")
    public void executeSystemChecker() {
        checkSystem();
    }

    // Напоминание о встрече каждую пятницу в 16:30
    @Scheduled(cron = "0 30 16 * * fri")
    public void executeReminder() {
        remainder();
    }


    public void backup() {
        System.out.println("Выполняется резервное копирование");
    }

    public void logsClearing() {
        System.out.println("Очистка логов");
    }

    public void createReport() {
        System.out.println("Создание отчета");
    }

    public void checkSystem() {
        System.out.println("Проверка системы");
    }

    public void remainder() {
        System.out.println("Напоминание");
    }

}
