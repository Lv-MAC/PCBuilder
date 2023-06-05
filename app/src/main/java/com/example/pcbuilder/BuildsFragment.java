package com.example.pcbuilder;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BuildsFragment extends Fragment {

   FloatingActionButton acbBtn,aabBtn;
   ExtendedFloatingActionButton abBtn;
   Boolean isAllFabsVisible;

   TextView addCustomBuildText, addAutoBuildText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_builds, container, false);
        FloatingActionButton acbBtn = view.findViewById(R.id.add_custom_builds);
        FloatingActionButton aabBtn = view.findViewById(R.id.add_auto_builds);
        ExtendedFloatingActionButton abBtn = view.findViewById(R.id.add_builds);

        TextView addCustomBuildText = view.findViewById(R.id.add_custom_builds_text);
        TextView addAutoBuildText = view.findViewById(R.id.add_auto_builds_text);

        acbBtn.setVisibility(View.GONE);
        aabBtn.setVisibility(View.GONE);
        addCustomBuildText.setVisibility(View.GONE);
        addAutoBuildText.setVisibility(View.GONE);
        isAllFabsVisible = false;
        abBtn.shrink();

        abBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAllFabsVisible){
                    acbBtn.show();
                    aabBtn.show();
                    abBtn.extend();
                    addCustomBuildText.setVisibility(View.VISIBLE);
                    addAutoBuildText.setVisibility(View.VISIBLE);
                    isAllFabsVisible=true;
                }
                else{
                    acbBtn.hide();
                    aabBtn.hide();
                    abBtn.shrink();
                    addCustomBuildText.setVisibility(View.GONE);
                    addAutoBuildText.setVisibility(View.GONE);
                    isAllFabsVisible=false;
                }
            }
        });

        acbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),button_custombuilds.class);
                startActivity(intent);
            }
        });

        aabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),button_autobuilds.class);
                startActivity(intent);
            }
        });

        return view;

    }

}