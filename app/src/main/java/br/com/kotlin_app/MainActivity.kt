package br.com.kotlin_app

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val estadosArray = arrayListOf(R.array.states)
//            "Estados…",
//            "Acre",
//            "Alagoas",
//            "Amapá",
//            "Amazonas",
//            "Bahia",
//            "Ceará",
//            "Distrito Federal",
//            "Espírito Santo",
//            "Goiás",
//            "Maranhão",
//            "Mato Grosso",
//            "Mato Grosso do Sul",
//            "Minas Gerais",
//            "Pará",
//            "Paraíba",
//            "Paraná",
//            "Pernambuco",
//            "Piauí",
//            "Rio de Janeiro",
//            "Rio Grande do Norte",
//            "Rio Grande do Sul",
//            "Rondônia",
//            "Roraima",
//            "Santa Catarina",
//            "São Paulo",
//            "Sergipe",
//            "Tocantins"
//        )


        val spinner: Spinner = findViewById(R.id.spnMainEstados)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.states,
            android.R.layout.simple_spinner_item

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
            val message = "O valor do IPVA  no estado $estados para pagar é de: R$"

            //Validação dos campos
            if (valor.isEmpty() || estados == estadosArray[0]) {

                //Apresentando um toast de erro ao usuário
                Toast.makeText(this@MainActivity, "Preencha todos os campos", Toast.LENGTH_SHORT).show()

            }
            //TAX 2%
            else if (estados == "Acre (AC)" || estados == "Tocantins (TO)" || estados == "Santa Catarina (SC)"
                || estados == "Sergipe (SE)" || estados == "Paraíba (PB)" ) {

                val tax = 0.02
                val ipva: Double = number * tax

                textResult.text = "$message $ipva, o valor da taxa é de $tax."

            }
            //TAX 2,5%
            else if (estados == "Alagoas (AL)" || estados == "Pernambuco (PE)"
                || estados == "Rio Grande do Norte (RN)" || estados == "Ceará (CE)"
                ||  estados == "Piauí (PI)" || estados == "Maranhão (MA)"
                || estados == "Bahia (BA)" || estados == "Pará (PA)"
                || estados == "Mato Grosso do Sul (MS)" || estados == "Goiás (GO)") {

                val tax = 0.025
                val ipva: Double = number * tax

                textResult.text = "$message $ipva, o valor da taxa é de $tax."

            }
            //TAX 3%
            else if (estados == "Rio Grande do Sul (RS)" || estados == "São Paulo (SP)"
                || estados == "Amazonas (AM)" || estados == "Amapá (AP)"
                || estados == "Roraima (RR)" || estados == "Rondônia (RO)"
                || estados == "Mato Grosso (MT)" || estados == "Distrito Federal (DF)") {

                val tax = 0.03
                val ipva: Double = number * tax

                textResult.text = "$message $ipva, o valor da taxa é de $tax."

            }
            //TAX 3.5%
            else if (estados == "Paraná (PR)") {

                val tax = 0.035
                val ipva: Double = number * tax

                textResult.text = "$message $ipva, o valor da taxa é de $tax."

            }
            //TAX 4%
            else if (estados == "Rio de Janeiro (RJ)" || estados == "Minas Gerais (MG)") {

                val tax = 0.04
                val ipva: Double = number * tax

                textResult.text = "$message $ipva, o valor da taxa é de $tax."

            }

            //Esconder o soft keyboard quando o botão for clicado
            val inputManager: InputMethodManager =getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(currentFocus?.windowToken, InputMethodManager.SHOW_FORCED)
        }

    }
}
