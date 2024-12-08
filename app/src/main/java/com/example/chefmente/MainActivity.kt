package com.example.chefmente

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val ingredientList = mutableListOf<String>()
    private lateinit var ingredientInput: EditText
    private lateinit var ingredientListTextView: TextView
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeListAdapter: RecipeListAdapter
    private lateinit var recipeDetailsTextView: TextView // Novo TextView para detalhes da receita

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ingredientInput = findViewById(R.id.ingredientInput)
        ingredientListTextView = findViewById(R.id.ingredientList)
        recipeRecyclerView = findViewById(R.id.recipeListRecyclerView)
        recipeDetailsTextView = findViewById(R.id.recipeDetailsTextView) // Inicializando o novo TextView

        val addIngredientButton = findViewById<Button>(R.id.addIngredientButton)
        val findRecipesButton = findViewById<Button>(R.id.findRecipesButton)
        val resetButton = findViewById<Button>(R.id.resetButton) // Novo botão de reset

        // Inicializando o Adapter com uma lista vazia
        recipeListAdapter = RecipeListAdapter(mutableListOf())

        // Configuração do RecyclerView
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.adapter = recipeListAdapter

        addIngredientButton.setOnClickListener {
            addIngredient()
        }

        findRecipesButton.setOnClickListener {
            findRecipes()
        }

        resetButton.setOnClickListener {
            resetApp()
        }
    }

    private fun addIngredient() {
        val ingredient = ingredientInput.text.toString()
        if (ingredient.isNotBlank()) {
            ingredientList.add(ingredient)
            ingredientInput.text.clear()
            updateIngredientListTextView()
        }
    }

    private fun updateIngredientListTextView() {
        ingredientListTextView.text = "Ingredientes na sua despensa: ${ingredientList.joinToString(", ")}"
    }

    private fun findRecipes() {
        // Obtém os detalhes completos da receita que corresponde aos ingredientes
        val recipeDetails = RecipeRepository.showRecipeDetails(ingredientList)

        // Atualiza o TextView com os detalhes da receita
        recipeDetailsTextView.text = recipeDetails
    }

    private fun resetApp() {
        // Reinicia a MainActivity sem passar pela SplashScreen
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
