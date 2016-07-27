package persiandatepicker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mghafori.persiandatapicker.Choise_Date;
import com.mghafori.persiandatapicker.R;

import java.util.List;

/**
 * Created by Mohsen Ghafori on 02/14/2016.
 * MGhafori.ir
 */
public class Adapter_Days extends RecyclerView.Adapter<Adapter_Days.Holder_Days> {
    private List<String> Days;
    private String [] titleDays;
    private int month;
    private int year;
    String month_title;
    Context ctx;
    String TAG="Adapter_Days";
    public Adapter_Days(Context ctx,List<String> days,int month,int year,String month_title) {
        Days = days;
        this.ctx=ctx;
        this.month=month;
        this.year=year;
        this.month_title=month_title;
        titleDays=ctx.getResources().getStringArray(R.array.TitleDays);

    }

    @Override
    public Holder_Days onCreateViewHolder(ViewGroup parent, int viewType) {
       View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.txtv_day,parent,false);

        return new Holder_Days(view);
    }

    @Override
    public void onBindViewHolder(final Holder_Days holder, int position) {
            if(position<7)
            {
                holder.txtv_day.setText(titleDays[position]);
            }else {
                holder.txtv_day.setText(Days.get(position-7));
            }
        holder.txtv_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.txtv_day.getText().toString().length()>0 && holder.txtv_day.getText().toString().length()<3 ) {
                    String month_str=String.valueOf(month);
                    String Day_str=holder.txtv_day.getText().toString();
                    if(month_str.length()==1)
                    {
                        month_str="0"+month_str;
                    }
                    if(Day_str.length()==1)
                    {
                        Day_str="0"+Day_str;
                    }
                    Choise_Date.Date_Choise_Tite.setText( Day_str+ " " + month_title + " " + year);
                    Choise_Date.Date_Choise=year + "-" + month_str + "-" + Day_str;
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return Days.size()+7;
    }

    public class Holder_Days extends RecyclerView.ViewHolder{
        public TextView txtv_day;
        public Holder_Days(View itemView) {
            super(itemView);
            txtv_day = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}
