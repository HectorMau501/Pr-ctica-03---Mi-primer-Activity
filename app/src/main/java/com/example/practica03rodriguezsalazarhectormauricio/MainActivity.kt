package com.example.practica03rodriguezsalazarhectormauricio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.View


class MainActivity : AppCompatActivity() {

    //Declaramos las intancias de las clases
    private lateinit var objHerramienta: Herramienta
    private lateinit var  objHerramientaMecanica: HerramientaMecanica

    //Intancias para componentes graficos

    //Cajas de texto
    private lateinit var titul: TextView
    private lateinit var mar: EditText
    private lateinit var model: EditText
    private lateinit var  cod: EditText
    private lateinit var cost: EditText
    private lateinit var  pes: EditText
    private lateinit var  tam: EditText
    private lateinit var  dim: AutoCompleteTextView

    //Boton limpiar
    private lateinit var agre: Button
    private lateinit var lim: Button
    private lateinit var mos: Button

    private lateinit var cont: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Intanciamos los constructores de las clases, con sus atributos
        objHerramienta = Herramienta("","",0,0.0)
        objHerramientaMecanica = HerramientaMecanica("","",0,0.0)

        //Asociacion con los componentes hacia una variable
        titul = findViewById(R.id.textTitulo)
        mar = findViewById(R.id.editMarca)
        model = findViewById(R.id.editModelo)
        cod = findViewById(R.id.editCodigo)
        cost = findViewById(R.id.editCosto)
        pes = findViewById(R.id.editPeso)
        tam = findViewById(R.id.editTamanio)
        dim = findViewById(R.id.autoCompleteDimension)
        agre = findViewById(R.id.btnAgregar)
        lim = findViewById(R.id.btnLimpiar)
        mos = findViewById(R.id.btnMostrar)
        cont = findViewById(R.id.textViewMostrar)
    }//override

    fun agregar(view: View?){
        //Ponemos la condicion para que se pueda agregar si hay unformacion en estos tres puntos
        if(mar.text.isNotEmpty() && cod.text.isNotEmpty()
            && cost.text.isNotEmpty()
        )
        {
            //Asociamos los atributos de las clases con las cajas de texto
            objHerramienta.marca = mar.text.toString()
            objHerramienta.modelo = model.text.toString()
            objHerramienta.codigo = cod.text.toString().toInt()
            objHerramienta.costo = cost.text.toString().toDouble()
            objHerramientaMecanica.peso = pes.text.toString().toFloat()
            objHerramientaMecanica.tamanio = tam.text.toString().toFloat()
            objHerramientaMecanica.dimensiones = dim.text.toString()

            //Un mensaje de que se agrego
            Toast.makeText(
                this, "Marca: ${objHerramienta.marca} registrado\n" + "" +
                        "El modelo: ${objHerramienta.marca} \n" +
                        "El codigo: ${objHerramienta.codigo} \n" ,
                Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Regitrar informacion.",
                Toast.LENGTH_LONG).show()
        }//else
    }//if

    fun mostrarCampos(){

        //Ponemos la variable de los atributos para imprimir
        val mostrarTexto = "Marca: ${objHerramienta.marca}\n"+
                "Modelo: ${objHerramienta.modelo}\n" +
                "Codigo: ${objHerramienta.codigo}\n"+
                "Costo: ${objHerramienta.costo}\n"+
                "Peso: ${objHerramientaMecanica.peso}\n"+
                "Tamaño: ${objHerramientaMecanica.tamanio}\n"+
                "Dimensiones: ${objHerramientaMecanica.dimensiones}\n"

        //La funcion apply
        cont.apply{
            text = mostrarTexto //Establecemos el texto como cadena
            visibility = View.VISIBLE //Visibility para que pueda ver el usuario
        }//apply
    }//mostrarCampos

    private fun limpiarCampos() {
        mar.text.clear() //Limpiarmos las cajas de texto con .clear()
        model.text.clear()
        cod.text.clear()
        cost.text.clear()
        pes.text.clear()
        tam.text.clear()
        dim.text.clear()
    }//limpiarCampos()


    fun onClick(v: View?){
        when(v?.id){
            R.id.btnAgregar -> {
                agregar(v)
                limpiarCampos()
                Toast.makeText(
                    this, "Registrar informacion",
                    Toast.LENGTH_LONG).show()
            }
            R.id.btnLimpiar -> {
                limpiarCampos()
                Toast.makeText(
                    this, "Limpiar informacion",
                    Toast.LENGTH_LONG).show()
            }
            R.id.btnMostrar -> {
                mostrarCampos()
                Toast.makeText(
                    this, "Mostrar informacion",
                Toast.LENGTH_LONG).show()
            }
        }//when
    }//Onclic
}//classActivity