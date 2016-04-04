package appewtc.masterung.learnasyncetaskv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by masterUNG on 4/4/16 AD.
 */
public class MyAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] titleStrings, priceStrings, iconStrings;

    public MyAdapter(Context context,
                     String[] titleStrings,
                     String[] priceStrings,
                     String[] iconStrings) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.priceStrings = priceStrings;
        this.iconStrings = iconStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);

        TextView titleTextView = (TextView) view1.findViewById(R.id.textView);
        titleTextView.setText(titleStrings[i]);

        TextView priceTextView = (TextView) view1.findViewById(R.id.textView2);
        priceTextView.setText(priceStrings[i]);

        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        Picasso.with(context)
                .load(iconStrings[i])
                .resize(100, 100)
                .into(iconImageView);

        return view1;
    }
}   // Main Class
