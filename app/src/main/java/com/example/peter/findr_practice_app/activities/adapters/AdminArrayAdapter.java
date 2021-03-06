package com.example.peter.findr_practice_app.activities.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.peter.findr_practice_app.R;
import com.example.peter.findr_practice_app.models.Admin;

import java.util.List;

/**
 * Created by peter on 12/4/17.
 */

public class AdminArrayAdapter extends ArrayAdapter<Admin> {

    private int i;

    public AdminArrayAdapter(@NonNull Context context, int resource, @NonNull List<Admin> objects) {
        super(context, resource, objects);
        i = resource;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(i, parent, false);

            Admin admin = getItem(position);

            ((TextView) convertView.findViewById(R.id.tv_name)).setText("Name: " + admin.getName());
            ((TextView) convertView.findViewById(R.id.tv_email)).setText("Email: " + admin.getEmail());
        }
        return convertView;
    }

}
