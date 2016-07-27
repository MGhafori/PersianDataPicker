package com.mghafori.persiandatapicker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.widget.TextView;
import persiandatepicker.Adapter_MonthView;
import persiandatepicker.CalenderConvertor;
import persiandatepicker.Jalali;
/**
 * Created by Mohsen Ghafori on 02/14/2016.
 * MGhafori.ir
 */
public class Choise_Date extends AppCompatActivity {
    RecyclerView CalendarView;
    Context ctx=this;
    public static String Date_Choise="";
    public static TextView Date_Choise_Tite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choise__date);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        Date_Choise_Tite = (TextView) toolbar.findViewById(R.id.toolbar_title);
        CalendarView= (RecyclerView) findViewById(R.id.view_calendar);
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();

        CalenderConvertor convertor=new CalenderConvertor();
        convertor.GregorianToPersian(today.year,today.month,today.monthDay);
        Jalali jalali=convertor.GetJalali();
        String [] month=getResources().getStringArray(R.array.TitleMonth);
        Adapter_MonthView adapter_monthView=new Adapter_MonthView(ctx, month,jalali);
        CalendarView.setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false));
        CalendarView.setAdapter(adapter_monthView);
    }




}
