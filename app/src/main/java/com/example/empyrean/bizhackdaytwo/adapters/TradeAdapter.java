package com.example.empyrean.bizhackdaytwo.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.empyrean.bizhackdaytwo.R;

import java.util.ArrayList;

public class TradeAdapter extends ArrayAdapter<Lot> implements View.OnClickListener{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Lot> objects;

    public TradeAdapter(@NonNull Context context, int resource){
        super(context, resource);
        ctx = context;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Lot lot = getItem(position);

        if (lot == null)
            return convertView;

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.trade_item, parent, false);
        }

        ((TextView) view.findViewById(R.id.tvTitle)).setText(lot.title);
        ((TextView) view.findViewById(R.id.tvDescripton)).setText(lot.description);
        ((TextView) view.findViewById(R.id.tvCost)).setText(lot.cost);
        ((ImageView) view.findViewById(R.id.ivPhoto)).setImageResource(lot.imageResourceId);

        return view;
    }
}
