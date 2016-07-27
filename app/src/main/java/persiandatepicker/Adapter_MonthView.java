package persiandatepicker;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.mghafori.persiandatapicker.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mohsen Ghafori on 02/14/2016.
 * MGhafori.ir
 */
public class Adapter_MonthView extends RecyclerView.Adapter<Holder_Calendar> {
    private Context context;
    private String[] month;
    private Jalali jalali;
    String TAG="Adapter_MonthView";
    public Adapter_MonthView(Context context, String[] month,Jalali jalali) {
        this.context = context;
        this.month = month;
        this.jalali=jalali;
    }

    @Override
    public Holder_Calendar onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_calendar,parent,false);
        return new Holder_Calendar(view);
    }

    @Override
    public void onBindViewHolder(Holder_Calendar holder, int position) {
        final float scale = context.getResources().getDisplayMetrics().density;
        int pixels = (int) (280 * scale + 0.5f);
        holder.simplemonth.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,pixels));
        holder.simplemonth.setLayoutManager(new GridLayoutManager(context, 7, 1, false));
        int months=getMonthPos(jalali.getMonth(), position)+1;
       List<String> day= getDayofmonth(months, getYear(jalali.getMonth(), position));

        Adapter_Days adapter_days=new Adapter_Days(context,day,months,getYear(jalali.getMonth(), position),month[getMonthPos(jalali.getMonth(), position)]);
        holder.simplemonth.setAdapter(adapter_days);
        holder.txtv_title_month.setText(month[getMonthPos(jalali.getMonth(), position)] + " " + getYear(jalali.getMonth(), position));

    }

    @Override
    public int getItemCount() {
        return 48;
    }

    private List<String> getDayofmonth(int month,int year)
    {
        List<String> days=new ArrayList<>();
        CalenderConvertor calenderConvertor=new CalenderConvertor();
        calenderConvertor.PersianToGregorian(year, month, 1);
        int offsetday=getdayofweek(calenderConvertor.toString());
        if(offsetday==7)
        {
            offsetday=0;
        }

        if(month<7)
        {
            while (offsetday>0)
            {
                days.add("");
                offsetday--;
            }
            for(int i=1;i<32;i++)
            {
                days.add(String.valueOf(i));
            }
            return days;

        }else if(month>6 && month <12) {
            while (offsetday>0)
            {
                days.add("");
                offsetday--;
            }
            for(int i=1;i<31;i++)
            {
                days.add(String.valueOf(i));
            }
            return days;

        }else if(month==12)
        {
            Log.e(TAG, "month: "+month );
            if(isKabise(year))
            {
                Log.d(TAG, "getDayofmonth() returned: isKabise");
                while (offsetday>0)
                {
                    days.add("");
                    offsetday--;
                }
                for(int i=1;i<31;i++)
                {
                    days.add(String.valueOf(i));
                }
            }else {
                while (offsetday>0)
                {
                    days.add("");
                    offsetday--;
                }
                for(int i=1;i<30;i++)
                {
                    days.add(String.valueOf(i));
                }
            }
            return days;
        }
        return new ArrayList<>();

    }
    private int getdayofweek(String date)
    {
        String string = date;
        Calendar calender = Calendar.getInstance();
        try {
            calender.setTime(new SimpleDateFormat("yyyy-MM-d").parse(string));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return  calender.get(Calendar.DAY_OF_WEEK);
    }



    private boolean isKabise(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int getYear(int offset,int position)
    {
        int sum=position+offset;

        int div=sum/12;

        return jalali.getYear()+div;
    }

    private int getMonthPos(int offset,int position)
    {
        int sum=position+offset;

        return sum%12;
    }
}
