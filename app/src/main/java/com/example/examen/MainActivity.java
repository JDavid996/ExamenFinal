package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    Medicamentos medicamentos;
    Medicamento medicamento;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.list1);
        myList.setOnCreateContextMenuListener(this);
        fillList();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.bt_eliminar:
                this.medicamentos.remove(info.position);
                this.adapter.notifyDataSetChanged();
                return true;
            case R.id.bt_agregar:
                final Dialog dlg=new Dialog(this);
                dlg.setContentView(R.layout.add_new);
                dlg.setTitle("Nuevo medicamento");
                dlg.setCancelable(false);

                Button btagregar=(Button)dlg.findViewById(R.id.bt_aceptar);
                Button btcancelar=(Button)dlg.findViewById(R.id.bt_cancelar);

                btagregar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText etnombre=(EditText)dlg.findViewById(R.id.et_nombre);
                        EditText etprecio=(EditText)dlg.findViewById(R.id.et_precio);
                        EditText etpresentacion=(EditText)dlg.findViewById(R.id.et_presentacion);
                        EditText etlaboratorio=(EditText)dlg.findViewById(R.id.et_laboratorio);
                        EditText etexistencia=(EditText)dlg.findViewById(R.id.et_existencia);
                        ImageView view1=(ImageView)dlg.findViewById(R.id.imageView);
                        if ((etnombre.getText().toString().contentEquals(""))||(etprecio.getText().toString().contentEquals(""))||(etpresentacion.getText().toString().contentEquals(""))||(etlaboratorio.getText().toString().contentEquals(""))||(etexistencia.getText().toString().contentEquals(""))){
                            Toast.makeText(MainActivity.this, "Llene todos los campos", Toast.LENGTH_LONG).show();
                        }else {
                            Medicamento medicamento=new Medicamento();
                            medicamento.setNombre(etnombre.getText().toString());
                            medicamento.setPrecio(etprecio.getText().toString());
                            medicamento.setPresentacion(etpresentacion.getText().toString());
                            medicamento.setLaboratorio(etlaboratorio.getText().toString());
                            medicamento.setExistencia(etexistencia.getText().toString());
                            medicamento.setImg(R.drawable.pills);
                            medicamentos.add(medicamento);
                            adapter.notifyDataSetChanged();
                            dlg.cancel();
                        }



                    }
                });
                btcancelar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dlg.cancel();
                    }
                });
                dlg.show();
                break;
            case R.id.bt_salir:
                System.exit(0);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones");
        getMenuInflater().inflate(R.menu.menu_contextual,menu);
    }


    void fillList(){
        medicamentos=new Medicamentos();
        medicamento=new Medicamento("Paracetamol", "20", "tabletas", "LCH", "180");
        medicamento.setImg(R.drawable.pill);
        medicamentos.add(medicamento);
        medicamento=new Medicamento("Acetaminofen","6", "tabletas", "Caplin Point", "100");
        medicamento.setImg(R.drawable.drugs);
        medicamentos.add(medicamento);
        medicamento=new Medicamento("Alumin","80", "jarabe", "Solka S.A", "20");
        medicamento.setImg(R.drawable.drugs1);
        medicamentos.add(medicamento);

        adapter=new Adapter(this, R.layout.item_list, medicamentos);
        myList.setAdapter(adapter);
    }
}