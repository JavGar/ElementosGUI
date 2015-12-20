package com.example.hectorjavier.elementosgui.expandablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.hectorjavier.elementosgui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by HectorJavier on 18/12/2015.
 */
public class AdaptadorListaExpandible extends BaseExpandableListAdapter {

    Context context;
    List<String> cabecera;
    HashMap<String, ArrayList<String>> hijos;
    LayoutInflater li;

    public AdaptadorListaExpandible(Context context, List<String> cabecera, HashMap<String, ArrayList<String>> hijos) {
        this.context = context;
        this.cabecera = cabecera;
        this.hijos = hijos;
        li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return cabecera.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hijos.get(cabecera.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return cabecera.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hijos.get(cabecera.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = li.inflate(R.layout.list_group_header,null);
        }

        ((TextView) convertView.findViewById(R.id.textViewHeader)).setText((String) getGroup(groupPosition));

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = li.inflate(R.layout.list_sub_child,null);
        }
        //es importante dejarlo fuera del if, sino los textos se se asignarán de manera correcta
        ((TextView) convertView.findViewById(R.id.textViewChild)).setText((String) getChild(groupPosition, childPosition));

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
