package persiandatepicker;

/**
 * Created by Mohsen Ghafori on 02/14/2016.
 * MGhafori.ir
 */
public class Jalali {

    String TAG="Jalali";
    private int Day;
    private int DayOfWeek;
    private int Month;
    private int Year;

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public int getDayOfWeek() {
        return DayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        DayOfWeek = dayOfWeek;
    }
}
