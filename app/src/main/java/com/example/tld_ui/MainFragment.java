package com.example.tld_ui;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainFragment extends Fragment {

    Button camera, gallery;
    ImageView imageview;
    TextView result;
    viewModel viewModel;
    View root;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root  = inflater.inflate(R.layout.fragment_main, container, false);
        camera = root.findViewById(R.id.btn_capture_image);
        gallery = root.findViewById(R.id.btn_load_image);
        result = root.findViewById(R.id.tv_output);
        imageview = root.findViewById(R.id.imageView);
        //efab = root.findViewById(R.id.efab);
        viewModel = new ViewModelProvider(getActivity()).get(viewModel.class);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getResult().observe(getActivity(),item->{
            result.setText(item);
        });
        viewModel.getImage().observe(getActivity(),item->{
            imageview.setImageBitmap(item);
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)requireActivity()).cameraBtnClickEvent();
            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)requireActivity()).galleryBtnClickEvent();
            }
        });
        //to redirct user to google search for the scientific name
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                String term = result.getText().toString();
                intent.putExtra(SearchManager.QUERY, term);
                startActivity(intent);
            }
        });
    }
}