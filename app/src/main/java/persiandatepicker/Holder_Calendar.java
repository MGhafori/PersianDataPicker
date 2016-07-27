package persiandatepicker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mghafori.persiandatapicker.R;


/**
 * Created by Mohsen Ghafori on 02/14/2016.
 * MGhafori.ir
 */
public class Holder_Calendar extends RecyclerView.ViewHolder {
    public RecyclerView simplemonth;
    public TextView txtv_title_month;
    public Holder_Calendar(View itemView) {
        super(itemView);
        simplemonth= (RecyclerView) itemView.findViewById(R.id.view_simplecalendar);
        txtv_title_month= (TextView) itemView.findViewById(R.id.txtv_monthname);

    }
}
