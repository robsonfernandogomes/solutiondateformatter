package com.robson.gomes;

import java.time.Duration;

public class SolutionDateFormatter {

    private static final String MONTH_LABEL= "month";
    private static final String YEAR_LABEL= "year";
    private static final String DAY_LABEL= "day";
    private static final String HOUR_LABEL= "hour";
    private static final String MINUTE_LABEL= "minute";
    private static final String SECOND_LABEL= "second";

    private static final String DEFAULT_SEPARATOR = ", ";
    private static final int TOTAL_DAYS_OF_YEAR = 365;
    private static final int TOTAL_DAYS_OF_MONTH = 30;

    private static final int MINUTE_IN_SECONDS = 60;
    private static final int HOUR_IN_SECONDS = 60*MINUTE_IN_SECONDS;
    private static final int DAY_IN_SECONDS = 24*HOUR_IN_SECONDS;

    private static String getCorrectLabelByCounter(String timeLabel, long counter){
        if( counter > 1){
            return timeLabel+"s";
        }
        return timeLabel;
    }

    public static void main(String[] args) {
        System.out.println(SolutionDateFormatter.formatElegantly(63072000));
    }

    private static String formatSeparators(String formatedDate){
        if(formatedDate.contains(DEFAULT_SEPARATOR)){
           formatedDate = formatedDate.substring(0, formatedDate.lastIndexOf(',')) + " and" +formatedDate.split(",")[formatedDate.split(",").length-1];
        }

        return formatedDate;
    }
 
    public static String formatElegantly(long seconds){
        StringBuffer formatedDate = new StringBuffer("");

        if( seconds == 0){
            return "now";
        }
        
        Duration durationData = Duration.ofSeconds(seconds);

        durationData = generateYearsData(formatedDate,durationData);
        durationData = generateMonthsData(formatedDate,durationData);
        durationData = generateDaysData(formatedDate,durationData);
        durationData = generateHoursData(formatedDate,durationData);
        durationData = generateMinutesData(formatedDate,durationData);
        durationData = generateSecondsData(formatedDate,durationData);
        
        return formatSeparators(formatedDate.toString());

    }


    private static Duration generateYearsData(StringBuffer formatedDate, Duration durationData) {
        if(durationData.toDaysPart() > 0){
            long totalYears = durationData.toDaysPart()/TOTAL_DAYS_OF_YEAR;
            if( totalYears > 0l){
                formatedDate.append(totalYears+" "+getCorrectLabelByCounter(YEAR_LABEL,totalYears));
            }
            return durationData.minusSeconds(totalYears*TOTAL_DAYS_OF_YEAR * DAY_IN_SECONDS);
        }
        return durationData;
    }

    private static Duration generateMonthsData(StringBuffer formatedDate, Duration durationData) {
        if(durationData.toDaysPart() > 0){
            long totalMonths = durationData.toDaysPart()/TOTAL_DAYS_OF_MONTH;
            if( totalMonths > 0l){
                if(!formatedDate.isEmpty()){
                    formatedDate.append(DEFAULT_SEPARATOR);    
                }
                formatedDate.append(totalMonths+" "+getCorrectLabelByCounter(MONTH_LABEL,totalMonths));
            }
            return durationData.minusSeconds(totalMonths*TOTAL_DAYS_OF_MONTH * DAY_IN_SECONDS);

        }
        return durationData;

    }

    private static Duration generateDaysData(StringBuffer formatedDate, Duration durationData) {
        long days = durationData.toDaysPart();
        if( days > 0l){
            if(!formatedDate.isEmpty()){
                formatedDate.append(DEFAULT_SEPARATOR);    
            }
            formatedDate.append(days+" "+getCorrectLabelByCounter(DAY_LABEL,days));
            return durationData.minusSeconds(days*DAY_IN_SECONDS);

       }
       return durationData;

    }

    private static Duration generateHoursData(StringBuffer formatedDate, Duration durationData) {
        long hours = durationData.toHoursPart();
        if( hours > 0l){
            if(!formatedDate.isEmpty()){
                formatedDate.append(DEFAULT_SEPARATOR);    
            }
            formatedDate.append(hours+" "+getCorrectLabelByCounter(HOUR_LABEL,hours));
            return durationData.minusSeconds(hours*HOUR_IN_SECONDS);

       }
       return durationData;

    }

    private static Duration generateMinutesData(StringBuffer formatedDate, Duration durationData) {
        long minutes = durationData.toMinutesPart();
        if( minutes > 0l){
            if(!formatedDate.isEmpty()){
                formatedDate.append(DEFAULT_SEPARATOR);    
            }
            formatedDate.append(minutes+" "+getCorrectLabelByCounter(MINUTE_LABEL,minutes));
            return durationData.minusSeconds(minutes*MINUTE_IN_SECONDS);

       }
       return durationData;

    }
    
    private static Duration generateSecondsData(StringBuffer formatedDate, Duration durationData) {
        long seconds = durationData.toSecondsPart();
        if( seconds > 0l){
            if(!formatedDate.isEmpty()){
                formatedDate.append(DEFAULT_SEPARATOR);    
            }
            formatedDate.append(seconds+" "+getCorrectLabelByCounter(SECOND_LABEL,seconds));
       }
       return durationData;

    }

}