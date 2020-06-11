package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private Medicamentos medicamentos;
    ViewMedicamento holder;

    public Adapter(Context context, int layout, Medicamentos medicamentos) {
        this.context = context;
        this.layout = layout;
        this.medicamentos = medicamentos;
    }

    @Override
    public int getCount() {
        return medicamentos.size();
    }

    @Override
    public Object getItem(int position) {
        return medicamentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewMedicamento{
        private TextView nombre_textView;
        private TextView precio_textView;
        private TextView presentacion_textView;
        private TextView laboratorio_textView;
        private TextView existencia_textView;
        private ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        if (convertView==null||convertView.getTag()==null){
            LayoutInflater layoutInflater=LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(R.layout.item_list, null);
            holder=new ViewMedicamento();
            holder.nombre_textView=(TextView)convertView.findViewById(R.id.nombre_textView);
            holder.precio_textView=(TextView)convertView.findViewById(R.id.precio_textView);
            holder.presentacion_textView=(TextView)convertView.findViewById(R.id.presentacion_textView);
            holder.laboratorio_textView=(TextView)convertView.findViewById(R.id.laboratorio_textView);
            holder.existencia_textView=(TextView)convertView.findViewById(R.id.existencia_textView);
            holder.img=(ImageView)convertView.findViewById(R.id.imageView);
        }else{
            holder=(ViewMedicamento)convertView.getTag();
        }
        Medicamento current_Item=medicamentos.get(position);
        holder.nombre_textView.setText(current_Item.getNombre());
        holder.precio_textView.setText(current_Item.getPrecio());
        holder.presentacion_textView.setText(current_Item.getPresentacion());
        holder.laboratorio_textView.setText(current_Item.getLaboratorio());
        holder.existencia_textView.setText(current_Item.getExistencia());
        holder.img.setImageResource(medicamentos.get(position).getImg());
        return convertView;
    }
}
