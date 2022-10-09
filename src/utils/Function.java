package utils;

import model.Region;
import model.Request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.abs;

public class  Function {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);

                // if last two chars equal
                if (c1 == c2) {
                    // update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }

    public static double minDistanceOf2Objects(Request rq1, Request rq2) {

        List<Region> list1 = rq1.getRegions();
        List<Region> list2 = rq2.getRegions();
        int len1 = rq1.getRegions().size();
        int len2 = rq2.getRegions().size();

        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        // iterate though, and check last char
        for (int i = 0; i < len1; i++) {
            Region c1 = rq1.getRegions().get(i);
            for (int j = 0; j < len2; j++) {
                Region c2 = rq2.getRegions().get(j);

                // if last two chars equal
                if (c1.getName().equals(c2.getName())) {
                    // update dp value for +1 length
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }

        return dp[len1][len2];
    }

    public static Date convertTime(String date) throws ParseException {
        String pattern = "HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date time = simpleDateFormat.parse(date);
        return time;
    }

    public static long differenceInTime(Date date1, Date date2) {

        long difference_In_Time = abs(date1.getTime() - date2.getTime());
        // Calucalte time difference in minutes
        long minutes_difference = (difference_In_Time / (1000 * 60)) % 60;

        // Calucalte time difference in hours
        long hours_difference = (difference_In_Time / (1000 * 60 * 60)) % 24;

        // Calucalte all to minutes
        if (hours_difference > 0) {
            minutes_difference = (hours_difference * 60) + minutes_difference;
        }
        return minutes_difference;
    }
}
