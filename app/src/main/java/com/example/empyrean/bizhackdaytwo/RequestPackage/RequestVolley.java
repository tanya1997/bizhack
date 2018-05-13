package com.example.empyrean.bizhackdaytwo.RequestPackage;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.empyrean.bizhackdaytwo.TradeActivity;
import com.example.empyrean.bizhackdaytwo.TradeInterface;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class RequestVolley {
    public void GetRequest(final Context ctx){
        RequestQueue queue = Volley.newRequestQueue(ctx);
        String url = "http://172.31.5.33/api/method/getTrade";
        JsonArrayRequest getRequest = new JsonArrayRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("supertest", response.toString());
                        JsonParsing test = new JsonParsing();
                        TradeInterface main = new TradeActivity();
                         main.ShowItems(ctx, test.parseData(response.toString()));
                        //Success Callback

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("supertest", error.toString());
                        //Failure Callback

                    }
                });

        queue.add(getRequest);

    }

    public void Post(final Context ctx, final String price, final String id){

        RequestQueue queue = Volley.newRequestQueue(ctx);
        String url = "http://172.31.5.33/api/method/putTrade";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("id", id);
                params.put("cost", price);

                return params;
            }
        };
        queue.add(postRequest);

    }


}

