package net.austinclarke.randomeyes;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Austin on 11/6/2015.
 */

class getCustomListAdapter extends ArrayAdapter {

    private Context mContext;
    private int id;
    private List<String> items ;
    GFont font = new GFont(this.getContext());

    public getCustomListAdapter(Context context, int textViewResourceId, List<String> list)
    {
        super(context, textViewResourceId, list);
        mContext = context;
        id = textViewResourceId;
        items = list ;

    }

    @Override
    public View getView(int position, View v, ViewGroup parent)
    {
        View mView = v ;
        if(mView == null){
            LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mView = vi.inflate(id, null);
        }

        TextView text = (TextView) mView.findViewById(R.id.customListView);

        if(items.get(position) != null )
        {
            text.setTextColor(ContextCompat.getColor(this.getContext(), R.color.black));
            text.setTypeface(GFont.main);
            text.setText(items.get(position));
            text.setBackgroundColor(ContextCompat.getColor(this.getContext(), R.color.toolbar_color));
            //int color = Color.argb( 200, 255, 64, 64 );
            //text.setBackgroundColor( color );

        }

        return mView;
    }

}