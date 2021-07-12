package com.github.brunoomoreshi.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Abaixo importação como visto nos cursos da Samsung Ocean
        val btCalcular =  findViewById<Button>(R.id.btCalc)

        /*
        Abaixo importação como visto no curso da DIO
        Para funcionar tem que add no build.gradle:app o plugin: "id 'kotlin-android-extensions'"
        Daí pra frente ele vai fazer a sugestão de importação dos elementos de interface da activity aqui.
        */
        val resultado = tvResults

        btCalcular.setOnClickListener {
            val NotaOne =Integer.parseInt(etNotaOne.text.toString())
            val NotaTwo =Integer.parseInt(etNotaTwo.text.toString())
            val Faltas = Integer.parseInt(etFaltas.text.toString())
            val Media = (NotaOne + NotaTwo)/2


            if (NotaOne>10 || NotaTwo > 10){
                resultado.setText("Foi digitado um valor acima de 10 para as notas!")
            }
            else if (Media >=6 && Faltas <= 10){
                resultado.setText("Aluno foi Aprovado "+ "\n" + "Nota final: ${Media}"+ "\n" + "Faltas: ${Faltas} ")
            }
            else {
                resultado.setText("Aluno foi Reprovado "+ "\n" + "Nota final: ${Media}"+ "\n" + "Faltas: ${Faltas} ")
            }
        }
    }
}