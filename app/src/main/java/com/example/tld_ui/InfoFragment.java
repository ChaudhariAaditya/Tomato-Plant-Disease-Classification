package com.example.tld_ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Locale;

public class InfoFragment extends Fragment {

    TextView text, textHeading;
    LinearLayout linLayAllDisease;
    ListView listview;

    public InfoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_info, container, false);
        text = root.findViewById(R.id.text);
        linLayAllDisease = root.findViewById(R.id.linLayAllDisease);
        textHeading = root.findViewById(R.id.textHeading);
        listview = root.findViewById(R.id.listview);
        linLayAllDisease.setVisibility(View.VISIBLE);
        String[] array = getResources().getStringArray(R.array.disease);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getActivity(), R.layout.list_item, R.id.label,
                array);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showDisease(array[i]);//Tomato Late Blight
            }
        });
        return root;
    }

    public void showDisease(String Disease) {    //Tomato Late Blight
        linLayAllDisease.setVisibility(View.GONE);
        textHeading.setText(Disease.toUpperCase(Locale.ROOT));
        String searchText = Disease.replaceAll("\\s", ""); //TomatoLateBlight
        switch (searchText) {
            case "TomatoLateBlight":
                text.setText(R.string.TomatoLateBlight);
                break;
            case "MosaicVirus":
                text.setText(R.string.MosaicVirus);
                break;
            case "BacterialSpot":
                text.setText(R.string.BacterialSpot);
                break;
            case "TomatoEarlyBlight":
                text.setText(R.string.TomatoEarlyBlight);
                break;
            case "TomatoLeafMold":
                text.setText(R.string.TomatoLeafMold);
                break;
            case "SeptoriaLeafSpot":
                text.setText(R.string.SeptoriaLeafSpot);
                break;
            case "TomatoSpidermites":
                text.setText(R.string.TomatoSpidermites);
                break;
            case "TomatoTargetSpot":
                text.setText(R.string.TomatoTargetSpot);
                break;
            case "TomatoYellowleafcurl":
                text.setText(R.string.TomatoYellowleafcurl);
                break;
            case "TomatoHealthy":
                text.setText(R.string.TomatoHealthy);
                break;
            //take string name from mainactivity classes without space
        }
    }
}