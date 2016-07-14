package doapps.testingcollaboration.activity;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;

import doapps.testingcollaboration.R;
import doapps.testingcollaboration.adapter.PortadaAdapter;
import doapps.testingcollaboration.dto.Portada;

public class MainActivity extends AppCompatActivity {
    final int color = 0xFFFF0000;
    final Drawable drawable = new ColorDrawable(color);
    private TabHost tabs;
    private ArrayList<Portada> portadas;
    private ListView visorLista ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        init();
        initHardData();
    }

    private void init() {
        visorLista = (ListView) findViewById( R.id.lisViewNoticias);

        Resources res = getResources();

        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("mitab1");

        spec.setContent(R.id.tab1);
        spec.setIndicator("PORTADA", res.getDrawable(R.drawable.launcher));

        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("DEPORTES", getResources().getDrawable(android.R.drawable.ic_dialog_map));

        tabs.addTab(spec);
        /*
        spec = tabs.newTabSpec("mitab3");
        spec.setContent(R.id.tab2);
        spec.setIndicator("GASTRONOMIA", getResources().getDrawable(android.R.drawable.ic_dialog_map));

        tabs.addTab(spec);

        spec = tabs.newTabSpec("mitab4");
        spec.setContent(R.id.tab2);
        spec.setIndicator("ESPECIALES", getResources().getDrawable(android.R.drawable.ic_dialog_map));

        tabs.addTab(spec);
        */
        tabs.setCurrentTab(0);
    }

    @Override
    protected void onResume() {
        super.onResume();

        for(int i=0;i<tabs.getTabWidget().getChildCount();i++)
        {
            TextView tv = (TextView) tabs.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources().getColor(R.color.primary_text));
        }
        PortadaAdapter pa=new PortadaAdapter(MainActivity.this,portadas);
        visorLista.setAdapter(pa);
        pa.notifyDataSetChanged();
    }

    private void initHardData(){
        portadas = new ArrayList<Portada>();

        Portada portada = new Portada();
        portada.setCodigo("123sxewedx");
        portada.setFecha("21-12-2345 10:15 AM");
        portada.setPregunta(":V los memes inundan facebook");
        portada.setMensaje("123sxccedx");

        Portada portada1 = new Portada();
        portada1.setCodigo("12wqxccedx");
        portada1.setFecha("21-12-234 11:45 AM");
        portada1.setPregunta("CONSECUENCIAS DEL ACABE DEL PETROLEO");
        portada1.setMensaje("Se ha acabdo el petroleo");

    }
}
