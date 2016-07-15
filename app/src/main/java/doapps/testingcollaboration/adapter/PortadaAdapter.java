package doapps.testingcollaboration.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
 import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import doapps.testingcollaboration.R;
import doapps.testingcollaboration.dto.Portada;

/**
 * Created by frank on 13/07/16.
 */
public class PortadaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Portada> portadas;

    public PortadaAdapter(Context context, ArrayList<Portada> portadas) {
        this.context = context;
        this.portadas = portadas;
    }

    @Override
    public int getCount() {
        return portadas.size();
    }

    @Override
    public Object getItem(int i) {
        return portadas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HolderPortada holderPortada;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_view_portada, null);

            holderPortada = new HolderPortada();
            holderPortada.fecha = (TextView) view.findViewById(R.id.idDate);
            holderPortada.pregunta = (TextView) view.findViewById(R.id.idQuestion);
            holderPortada.mensaje = (TextView) view.findViewById(R.id.tvMessage);
            holderPortada.img = (ImageView) view.findViewById(R.id.imgNoticia);

            view.setTag(holderPortada);
        } else {
            holderPortada = (HolderPortada) view.getTag();
        }
        if (portadas != null && !portadas.isEmpty()) {
            Portada portada = portadas.get(i);
            holderPortada.fecha.setText(portada.getFecha());
            holderPortada.pregunta.setText(portada.getPregunta());
            holderPortada.img.setImageResource(R.drawable.logo_eco_175);
            holderPortada.mensaje.setText(portada.getMensaje());
        }

        return view;
    }

    private static class HolderPortada {
        TextView fecha;
        TextView pregunta;
        TextView mensaje;
        ImageView img;
    }

}
