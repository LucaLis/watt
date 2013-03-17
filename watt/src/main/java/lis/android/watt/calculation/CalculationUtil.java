package lis.android.watt.calculation;

/**
 * Created with IntelliJ IDEA.
 * User: lli
 * Date: 17.03.13
 * Time: 21:32
 * To change this template use File | Settings | File Templates.
 */
public class CalculationUtil {
    public static double calculateYearCost(double kwhPrice, double devicePower, double dailyWorkHours) {
        return calculateDayCost(kwhPrice, devicePower, dailyWorkHours) * 365;
    }

    public static double calculateMonthCost(double kwhPrice, double devicePower, double dailyWorkHours) {
        return calculateYearCost(kwhPrice, devicePower, dailyWorkHours) / 12;
    }

    public static double calculateDayCost(double kwhPrice, double devicePower, double workHoursPerDay) {
        return kwhPrice * devicePower * workHoursPerDay / 1000d;
    }
}
