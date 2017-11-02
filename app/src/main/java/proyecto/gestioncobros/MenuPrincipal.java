package proyecto.gestioncobros;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuPrincipal extends AppCompatActivity {

    Button btnNuevo = (Button)findViewById(R.id.btnNuevo);
    Button btnAbonar = (Button)findViewById(R.id.btnAbonar);
    Button btnProgramar = (Button)findViewById(R.id.btnProgramar);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevo();
            }
        });

        btnAbonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abonar();
            }
        });

        btnProgramar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                programar();
            }
        });
    }

    public void nuevo(){
        Intent intent = new Intent(MenuPrincipal.this, Registro.class);
        startActivity(intent);
    }

    public void abonar(){
        Intent intent = new Intent(MenuPrincipal.this, Abono.class);
        startActivity(intent);
    }

    public void programar(){
        Intent intent = new Intent(MenuPrincipal.this, Programar.class);
        startActivity(intent);
    }

}
