package com.example.empyrean.bizhackdaytwo.adapters;

import android.net.Uri;

public class DataModel {

    String status;
    String log1;
    String name1;
    String result;
    String log2;
    String name2;
    String place;


    public DataModel(String status, String log1, String name1, String result,
                     String log2, String name2, String place) {
        this.status=status;
        this.log1 = log1;
        this.name1 = name1;
        this.log2 = log2;
        this.name2 = name2;
        this.result = result;
        this.place = place;
    }

    public void setStatus(String status){
        this.status = status;
    }



    public String getStatus() {
        return status;
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getLog1() {
        return log1;
    }

    public String getResult() {
        return result;
    }

    public String getLog2() {
        return log2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getPlace() {
        return place;
    }
}
