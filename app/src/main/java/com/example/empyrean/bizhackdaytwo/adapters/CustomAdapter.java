package com.example.empyrean.bizhackdaytwo.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.empyrean.bizhackdaytwo.R;

import java.io.InputStream;
import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context mContext;

    private static class ViewHolder {
        TextView txtStatus;
        ImageView imgLog1;
        TextView txtName1;
        TextView txtResult;
        ImageView imgLog2;
        TextView txtName2;
        TextView txtPlace;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.acessible_sites_item, data);
        this.dataSet = data;
        this.mContext=context;

    }


    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        DataModel dataModel=(DataModel)object;
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.acessible_sites_item, parent, false);
            viewHolder.txtStatus = (TextView) convertView.findViewById(R.id.status);
            viewHolder.imgLog1 = (ImageView) convertView.findViewById(R.id.log1);
            viewHolder.txtName1 = (TextView) convertView.findViewById(R.id.name1);
            viewHolder.txtResult = (TextView) convertView.findViewById(R.id.result);
            viewHolder.imgLog2 = (ImageView) convertView.findViewById(R.id.log2);
            viewHolder.txtName2 = (TextView) convertView.findViewById(R.id.name2);
            viewHolder.txtPlace = (TextView) convertView.findViewById(R.id.place);


            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        lastPosition = position;

        viewHolder.txtStatus.setText(dataModel.getStatus());

        viewHolder.imgLog1.setImageResource(mContext.getResources().getIdentifier("team" + dataModel.getLog1() , "drawable", mContext.getPackageName()));
        viewHolder.imgLog2.setImageResource(mContext.getResources().getIdentifier("team" + dataModel.getLog2() , "drawable", mContext.getPackageName()));
        viewHolder.txtName1.setText(dataModel.getName1());
        viewHolder.txtName2.setText(dataModel.getName2());
        viewHolder.txtPlace.setText(dataModel.getPlace());
        viewHolder.txtResult.setText(dataModel.getResult());
        return convertView;
    }



}