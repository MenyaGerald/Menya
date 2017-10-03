package com.gerald.mbararamarket1;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    String[] items={ "Foods", "Fruits",};


    private Context pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pt = MainActivity.this;


        int configuration=getResources().getConfiguration().orientation;
        if(configuration== Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.fragment_fragment_portrait);
            ListView listView= (ListView) findViewById(R.id.ItemList);

            ListAdapter adt=new ArrayAdapter<String>(pt,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adt);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                RelativeLayout men1= (RelativeLayout) findViewById(R.id.fragClothes);
                RelativeLayout men2= (RelativeLayout) findViewById(R.id.c);


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String user_chose=String.valueOf(parent.getItemAtPosition(position));
                    switch (user_chose){
                        case "Fruits":

                            men2.setVisibility(View.INVISIBLE);
                            men1.setVisibility(View.VISIBLE);
                            break;
                        case "Foods":

                            men2.setVisibility(View.VISIBLE);
                            men1.setVisibility(View.INVISIBLE);
                            break;
                    }
                }
            });

        }
        else if(configuration== Configuration.ORIENTATION_LANDSCAPE){
            setContentView(R.layout.fragment_fragment_landscape);
            ListView listView= (ListView) findViewById(R.id.ItemList);

            ListAdapter adapter=new ArrayAdapter<String>(pt,android.R.layout.simple_list_item_1,items );
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                RelativeLayout ger1= (RelativeLayout) findViewById(R.id.fragClothes);
                RelativeLayout ger2= (RelativeLayout) findViewById(R.id.c);


                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String user_chose=String.valueOf(parent.getItemAtPosition(position));
                    switch (user_chose){
                        case "Fruits":
                           ger2 .setVisibility(View.INVISIBLE);
                            ger1.setVisibility(View.VISIBLE);

                            break;
                        case "Foods":

                            ger2.setVisibility(View.VISIBLE);
                            ger1.setVisibility(View.INVISIBLE);
                            break;
                    }
                }
            });
        }
    }
}
