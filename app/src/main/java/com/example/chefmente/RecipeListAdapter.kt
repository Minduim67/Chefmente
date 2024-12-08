package com.example.chefmente

// RecipeListAdapter.kt
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Recebe uma lista de receitas e cria o Adapter para o RecyclerView
class RecipeListAdapter(private var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    // ViewHolder interno que armazena as referências para as views de cada item
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recipeNameTextView: TextView = view.findViewById(R.id.recipeName)
    }

    // Cria uma nova ViewHolder para cada item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    // Vincula cada item da lista de receitas a uma ViewHolder
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.recipeNameTextView.text = recipes[position].name
    }

    // Retorna o número total de itens na lista de receitas
    override fun getItemCount() = recipes.size

    // Atualiza a lista de receitas e notifica o RecyclerView sobre a alteração dos dados
    fun updateRecipes(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }
}
