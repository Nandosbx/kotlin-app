package br.com.kotlin_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val estadosArray = arrayListOf(
            "Estados…",
            "Acre",
            "Alagoas",
            "Amapá",
            "Amazonas",
            "Bahia",
            "Ceará",
            "Distrito Federal",
            "Espírito Santo",
            "Goiás",
            "Maranhão",
            "Mato Grosso",
            "Mato Grosso do Sul",
            "Minas Gerais",
            "Pará",
            "Paraíba",
            "Paraná",
            "Pernambuco",
            "Piauí",
            "Rio de Janeiro",
            "Rio Grande do Norte",
            "Rio Grande do Sul",
            "Rondônia",
            "Roraima",
            "Santa Catarina",
            "São Paulo",
            "Sergipe",
            "Tocantins"
        )

        val spinner: Spinner = findViewById(R.id.spnMainEstados)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.states,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        btnMainCalcular.setOnClickListener {
            //Capturar os dados digitados
            val estados = spnMainEstados.selectedItem
            val valor = editTextMainValor.text.trim()
            val number: Double = valor.toString().toDouble()
            val message = "O valor do IPVA a pagar é de: R$"

            //Validação dos campos
            if (valor.isEmpty() || estados == estadosArray[0]) {

                //Apresentando um toast de erro ao usuário
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else if (estados == "Acre (AC)" || estados == "Tocantins (TO)") {

                val tax = 0.02
                val ipva: Double = number * tax

                textResult.text = "$message $ipva"
            }

        }
    }
}
