package com.github.brunoomoreshi.calculadoradenotas

import android.graphics.Color
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


            val notaOne =Integer.parseInt(etNotaOne.text.toString())
            val notaTwo =Integer.parseInt(etNotaTwo.text.toString())
            val faltas = Integer.parseInt(etFaltas.text.toString())
            val media = (notaOne + notaTwo)/2

            //Variaveis que vou usar para verificar se o que foi digitado é numérico. ACHO q pode ter maneiras mais curtas, mas acho essa mais readable.
            val klaseCkOne = (notaOne::class.simpleName).toString()
            val klaseCkTwo = (notaOne::class.simpleName).toString()
            val klaseCkFaltas = (notaOne::class.simpleName).toString()

            fun ckScore (){
                if (notaOne > 10 || notaTwo > 10){
                    //To ligado que devia colocar em uma string para facilitar a tradução, mas esse não é o objetivo desse exercicio...
                    resultado.setText("Foi digitado um valor acima de 10 para as notas!")
                }
                else if (notaOne == null || notaTwo == null){
                    resultado.setText("Não foram digitados valores suficientes para a checagem.")
                    resultado.setTextColor(Color.RED)
                }
                else if (media >= 6 && faltas <= 10){
                    resultado.setText("Aluno foi Aprovado "+ "\n" + "Nota final: ${media}"+ "\n" + "Faltas: ${faltas} ")
                    resultado.setTextColor(Color.GREEN)
                }
                else {
                    resultado.setText("Aluno foi Reprovado "+ "\n" + "Nota final: ${media}"+ "\n" + "Faltas: ${faltas} ")
                    resultado.setTextColor(Color.RED)
                }
            }
            if (klaseCkOne != "String" && klaseCkTwo != "String" && klaseCkFaltas != "String" ){
                ckScore ()
            }
            //Na teoria esse else deveria avisar que foi digitado um valor não numérico. Mas o app crasha antes... talvez seja algum metodo de conversão que não está aguentando a exception...
            else{
                resultado.setText("Foi digitado algo que não é um número.")
                resultado.setTextColor(Color.RED)
            }
        }
    }
}
