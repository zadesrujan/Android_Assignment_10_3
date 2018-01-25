package com.example.user.android_assignment_10_3;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by IIS 5 on 25-09-2017.
 */
//creating a class called Myfragment which extends List Fragment
//a fragment is a kind of a sub-activity
public class MyFragment extends ListFragment {

    //initialising string variables
    String[] players = { "Youtbe", "Blogger"};
    String[] descriptions = { "youtbe  Description", "eblogger  Description"};
    //creating a variable for hashmap and giving int id for the images from mipmap
    HashMap<String, String> map;
    int[] images = {R.drawable.youtube,R.drawable.blogger};

    //declaring Arraylist of type string
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    //The system calls this callback when it's time for the fragment to draw
    // its user interface for the first time

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //putting the values witrh an object of map
        for(int i=0;i<players.length;i++){
            map = new HashMap<String, String>();
            map.put("player",players[i]);
            map.put("image",Integer.toString(images[i]));
            map.put("description",descriptions[i]);

            data.add(map);
        }
        //KEYS IN MAP
        String[] from ={"player","description","image"};

        //IDs of View
        int[] to = {R.id.textView,R.id.discriptiontext, R.id.imageView1};

        //ADAPTER creating an adapter for the id of mylist
        adapter = new SimpleAdapter(getActivity(), data, R.layout.mylist,from,to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    //The onStart() method is called once the fragment gets visible.
    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                Toast.makeText(getActivity(),data.get(position).get("player"),Toast.LENGTH_LONG).show();
            }
        });
    }

}