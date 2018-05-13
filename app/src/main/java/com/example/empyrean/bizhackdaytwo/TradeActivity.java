package com.example.empyrean.bizhackdaytwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.empyrean.bizhackdaytwo.adapters.Lot;
import com.example.empyrean.bizhackdaytwo.adapters.TradeAdapter;

public class TradeActivity extends AppCompatActivity {

    ListView lvTrades;
    TradeAdapter tradeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        tradeAdapter = new TradeAdapter(this, R.layout.trade_item);
        tradeAdapter.add(new Lot("Мяч", "Забитый КЕРЖАКОВЫМ ОФИГЕТЬ", "14 рублей", R.mipmap.ball_foreground));
        tradeAdapter.add(new Lot("Мяч", "Забитый КЕРЖАКОВЫМ ОФИГЕТЬ", "14 рублей", R.mipmap.ball_foreground));
        tradeAdapter.add(new Lot("Мяч", "Забитый КЕРЖАКОВЫМ ОФИГЕТЬ", "14 рублей", R.mipmap.ball_foreground));
        tradeAdapter.add(new Lot("Мяч", "Забитый КЕРЖАКОВЫМ ОФИГЕТЬ", "14 рублей", R.mipmap.ball_foreground));
        tradeAdapter.add(new Lot("Шарф", "Тот самый шарф, который ничего не значит!", "125 рублей", R.mipmap.scaf_foreground));
        tradeAdapter.add(new Lot("Шарф", "Тот самый шарф, который ничего не значит!", "125 рублей", R.mipmap.scaf_foreground));
        tradeAdapter.add(new Lot("Шарф", "Тот самый шарф, который ничего не значит!", "125 рублей", R.mipmap.scaf_foreground));
        tradeAdapter.add(new Lot("Шарф", "Тот самый шарф, который ничего не значит!", "125 рублей", R.mipmap.scaf_foreground));


        lvTrades = findViewById(R.id.lvTrades);
        lvTrades.setAdapter(tradeAdapter);
    }
}
