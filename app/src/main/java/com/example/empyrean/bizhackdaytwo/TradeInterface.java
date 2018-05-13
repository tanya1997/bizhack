package com.example.empyrean.bizhackdaytwo;

import android.content.Context;

import com.example.empyrean.bizhackdaytwo.RequestPackage.TradeData;

import java.util.ArrayList;

public interface TradeInterface {
    void ShowItems(Context ctx, ArrayList<TradeData> data);
}
