package mx.com.cgti.sharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE)
        btnGuardar.setOnClickListener{
            //Objeto para edición
            val editor = preferencias.edit()
            editor.putString(etxNombre.text.toString(),etxDatos.text.toString())
            editor.commit()//Se ha terminado con éxito
            Toast.makeText(this,"Datos grabados",Toast.LENGTH_LONG).show()
            etxNombre.setText("")
            etxDatos.setText("")
        }

        btnRecuperar.setOnClickListener{
            val datos= preferencias.getString(etxNombre.text.toString(),"")
            if(datos.length==0){
                Toast.makeText(this,"No existe dicho nombre en la agencia",Toast.LENGTH_LONG).show()
            }else{
                etxDatos.setText(datos)
            }
        }
    }
}
