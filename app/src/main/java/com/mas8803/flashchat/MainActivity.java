package com.mas8803.flashchat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView function_list;
    private MyAdapter myAdapter=null;
    private List<String> functions=null;
    private Context mContext=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;
        bindViews();

        functions=new LinkedList<>();
        functions.add("Calendar API");
        functions.add("Notification");
        myAdapter=new MyAdapter((LinkedList<String>) functions, mContext);
        function_list.setAdapter(myAdapter);

        function_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, demos[position].demoClass);
                startActivity(intent);
            }
        });


    }

    private void bindViews(){
        function_list = (ListView) findViewById(R.id.list_function);
    }



    private static class DemoInfo {
        private final Class<? extends android.app.Activity> demoClass;

        public DemoInfo(Class<? extends android.app.Activity> demoClass) {
            this.demoClass = demoClass;
        }
    }


    private static final DemoInfo[] demos = {
            new DemoInfo(Calendar.class),
            new DemoInfo(Notification.class)
    };


}


