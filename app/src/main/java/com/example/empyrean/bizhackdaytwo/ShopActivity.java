package com.example.empyrean.bizhackdaytwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.empyrean.bizhackdaytwo.adapters.Person;
import com.example.empyrean.bizhackdaytwo.adapters.RVAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);

        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        initializeData();

        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);




    }private List<Person> persons;

    // This method creates an ArrayList that has three Person objects
// Checkout the project associated with this tutorial on Github if
// you want to use the same images.
    private void initializeData() {
        persons = new ArrayList<>();
        persons.add(new Person("Чпсы", this.getString(R.string.chips), R.drawable.shop1));
        persons.add(new Person("Дождевик", this.getString(R.string.raincoad), R.drawable.shop3));
        persons.add(new Person("Вода", this.getString(R.string.water), R.drawable.shop7));
        persons.add(new Person("Шарф", this.getString(R.string.scarf), R.drawable.shop4));
        persons.add(new Person("Магнит", this.getString(R.string.megnit), R.drawable.shop5));
        persons.add(new Person("Кружка", this.getString(R.string.cap), R.drawable.shop6));
        persons.add(new Person("Зонт", this.getString(R.string.Umbrella), R.drawable.shop2));
    }
}
