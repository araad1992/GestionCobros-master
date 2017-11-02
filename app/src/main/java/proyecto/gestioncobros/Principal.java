package proyecto.gestioncobros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pl.rafman.scrollcalendar.ScrollCalendar;
import pl.rafman.scrollcalendar.contract.DateWatcher;
import pl.rafman.scrollcalendar.contract.MonthScrollListener;
import pl.rafman.scrollcalendar.contract.OnDateClickListener;
import pl.rafman.scrollcalendar.data.CalendarDay;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        ScrollCalendar scrollCalendar = (ScrollCalendar) findViewById(R.id.scrollCalendar);
        scrollCalendar.setOnDateClickListener(new OnDateClickListener() {
            @Override
            public void onCalendarDayClicked(int year, int month, int day) {

            }
        });
        scrollCalendar.setDateWatcher(new DateWatcher() {
            @Override
            public int getStateForDate(int year, int month, int day) {
                //    CalendarDay.DEFAULT,
                //    CalendarDay.DISABLED,
                //    CalendarDay.TODAY,
                //    CalendarDay.UNAVAILABLE,
                //    CalendarDay.SELECTED,
                return CalendarDay.DEFAULT;
            }
        });
        scrollCalendar.setMonthScrollListener(new MonthScrollListener() {
            @Override
            public boolean shouldAddNextMonth(int lastDisplayedYear, int lastDisplayedMonth) {
                // return false if you don't want to show later months
                return true;
            }
            @Override
            public boolean shouldAddPreviousMonth(int firstDisplayedYear, int firstDisplayedMonth) {
                // return false if you don't want to show previous months
                return true;
            }
        });
    }
}
