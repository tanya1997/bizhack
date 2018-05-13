package com.example.empyrean.bizhackdaytwo.RequestPackage;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.util.ArrayList;


public class JsonParsing{


    public ArrayList<TradeData> parseData(String line){
        JsonElement jelement = new JsonParser().parse(line);
        JsonArray jsonArray = jelement.getAsJsonArray();
        ArrayList<TradeData> listDataModel = new ArrayList<TradeData>();
        for (int i = 0; i< jsonArray.size(); i++){
            JsonObject jobject = jsonArray.get(i).getAsJsonObject();
            TradeData test = new TradeData();
            test.id = jobject.get("id").getAsInt();
            test.cost = jobject.get("cost").getAsInt();
            test.description = jobject.get("description").getAsString();
            test.title = jobject.get("title").getAsString();

            listDataModel.add(test);
        }



        return listDataModel;

    }

}