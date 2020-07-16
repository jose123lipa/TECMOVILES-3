package com.example.tec_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
//AUTOR : CHURA PABEL JOEL,CCUNO CARLOS PAUL ARNALDO, LIPA OCHOA JOSE,  //

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_Bus extends BaseAdapter {
    Context c;
    ArrayList<Bus> buseslist;
    private static LayoutInflater inflater=null;

    public Adapter_Bus(Context c, ArrayList<Bus> buseslist) {
        this.c = c;
        this.buseslist = buseslist;
        inflater = (LayoutInflater)c.getSystemService(c.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return buseslist.size();
    }

    @Override
    public Object getItem(int position) {
        return buseslist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_bus, null);
        final TextView matricula=(TextView) vista.findViewById(R.id.textView2);
        final TextView empresa=(TextView) vista.findViewById(R.id.textView9);
        final ImageView imagen=(ImageView) vista.findViewById(R.id.imageView2);
        matricula.setText(buseslist.get(position).getEmpresa());
        empresa.setText(buseslist.get(position).getMatricula());
        Picasso.get().load(buseslist.get(position).getImagen()).placeholder(R.mipmap.ic_launcher).into(imagen);
        return vista;
    }
}
