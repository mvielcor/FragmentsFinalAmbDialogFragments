package prueba.prueba.crgomez.activitatdinamicfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AgregarActivity extends AppCompatActivity {
    private TextView pr, tipusCicle, tipus, titol_new, descip_new;
    private Button btn_anyadirNew;
    ArrayList <CicleFlorida> array = new ArrayList<CicleFlorida>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        pr = (TextView) findViewById(R.id.prueba);
        tipusCicle = (TextView) findViewById(R.id.tipusCicle);
        tipus = (TextView) findViewById(R.id.tipus);
        titol_new = (TextView) findViewById(R.id.titol_new);
        descip_new = (TextView)findViewById(R.id.descripcio_new);
       // btn_anyadirNew = (Button) findViewById(R.id.btn_anyadirNew);

        //Aquí con Bundle lo que hacemos es recoger los datos que nos manda el adapter.
        final Bundle recogerDatos = getIntent().getExtras();
        //Y en el pr lo que hacemos es recoger tvTitol que estamos pasando desde el Recycler.

        btn_anyadirNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recogerDatos != null ){

                    //AQUÍ CON EL BUNDLE LO QUE HACEMOS ES RECOGER TAMBIÉN EL ARRAY Y DESPUÉS LO AÑADIMOS AL ARRAYLIST, VEMOS QUE SE AÑADE PERO NO NOS LO MUESTRA..
                    array = recogerDatos.getParcelableArrayList("arrayList");

                    CicleFlorida c1 = new CicleFlorida(tipusCicle.getText().toString(), tipus.getText().toString(), titol_new.getText().toString(), descip_new.getText().toString());
                    array.add(c1);
                    Log.d("array","valor array"+array.get(array.size()-1));
                    //Aquí lo que hacemos es pasar el nuevo ArrayList actualizado.
                    Intent i = new Intent();
                    i.putParcelableArrayListExtra("arrayList", array);

                    setResult(RESULT_OK, i);
                    finish();
                }


            }
        });

        String value = recogerDatos.getString("prueba");
        pr.setText(value);


    }


}
