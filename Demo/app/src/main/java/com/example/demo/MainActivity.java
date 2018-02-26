package com.example.demo;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnItemClickListener{
private GridView gridView;
    private List<Map<String,Object>> list;
    private SimpleAdapter adapter;
    private int[] icon={R.drawable.guo,R.drawable.guo};
    private String[] iconName={"猫","老虎"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        list = new ArrayList<Map<String, Object>>();
        // getData();
        adapter = new SimpleAdapter(this, getData(), R.layout.item, new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
    }
    private List<Map<String,Object>> getData() {
        for(int i=0;i<icon.length;i++)
        {

            Map<String,Object> map=new HashMap<String,Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            list.add(map);
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this,"我是"+iconName[i],Toast.LENGTH_SHORT).show();
    }
}
