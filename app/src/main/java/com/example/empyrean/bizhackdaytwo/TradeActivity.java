package com.example.empyrean.bizhackdaytwo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.empyrean.bizhackdaytwo.RequestPackage.RequestVolley;
import com.example.empyrean.bizhackdaytwo.RequestPackage.TradeData;
import com.example.empyrean.bizhackdaytwo.adapters.Lot;
import com.example.empyrean.bizhackdaytwo.adapters.TradeAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TradeActivity extends AppCompatActivity implements TradeInterface {

    static ListView lvTrades;
    static TradeAdapter tradeAdapter;
    static private Timer mTimer;
    static private MyTimerTask mMyTimerTask;
    static ArrayList<TradeData> mainLIst;
    static Context ctx;

    @Override
    protected void onResume() {
        super.onResume();
        mTimer = new Timer();
        mMyTimerTask = new MyTimerTask();
        mTimer.schedule(mMyTimerTask, 0, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Smart stadium");
        setContentView(R.layout.activity_trade);
        lvTrades = findViewById(R.id.lvTrades);
        lvTrades.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                final Integer cost = mainLIst.get(position).cost;
                final String[] stavka = new String[]{String.valueOf(cost * 1.2), String.valueOf(cost * 1.4), String.valueOf(cost * 2)};
                AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                builder.setTitle("Сделайте ставку")
                        .setItems(stavka, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                RequestVolley test = new RequestVolley();
                                test.Post(ctx, stavka[which],String.valueOf(position));


                                // The 'which' argument contains the index position
                                // of the selected item
                            }
                        });
                builder.create();
                builder.show();
            }
        });

    }

    @Override
    public void ShowItems(Context ctx, ArrayList<TradeData> data) {
        mainLIst = data;
        this.ctx = ctx;
        tradeAdapter = new TradeAdapter(ctx, R.layout.trade_item);

        for (int i = 0; i < data.size(); i++){
            if (data.get(i).title.equals("Мяч"))
                tradeAdapter.add(new Lot(data.get(i).title, data.get(i).description, String.valueOf(data.get(i).cost), R.mipmap.ball_foreground));
            if (data.get(i).title.equals("Шарф"))
                tradeAdapter.add(new Lot(data.get(i).title, data.get(i).description, String.valueOf(data.get(i).cost), R.mipmap.scaf_foreground));
        }

        lvTrades.setAdapter(tradeAdapter);

    }


    class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    RequestVolley test = new RequestVolley();
                    test.GetRequest(TradeActivity.this);
                }
            });
        }
    }
}
