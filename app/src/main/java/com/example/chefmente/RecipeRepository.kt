package com.example.chefmente

// RecipeRepository.kt

// Modelo de dados para cada receita
data class Recipe(
    val name: String,
    val ingredients: List<String>,
    val instructions: String,
    val cookTime: Int,      // em minutos
    val servings: Int
)

// Repositório de receitas
object RecipeRepository {

    // Lista de receitas fictícias para o exemplo
    private val recipes = listOf(
        Recipe(
            name = "Omelete Simples",
            ingredients = listOf("ovo"),
            instructions = "Bata os ovos com sal e pimenta e cozinhe em uma frigideira antiaderente até dourar.",
            cookTime = 5,
            servings = 1
        ),
        Recipe(
            name = "Panqueca de Banana",
            ingredients = listOf("banana", "ovo", "farinha"),
            instructions = "Amasse a banana e misture com o ovo e a farinha. Cozinhe em uma frigideira antiaderente até dourar dos dois lados.",
            cookTime = 10,
            servings = 2
        ),
        Recipe(
            name = "Massa com Molho de Tomate",
            ingredients = listOf("macarrão", "tomate"),
            instructions = "Cozinhe o macarrão e reserve. Faça o molho com tomate e sal e misture com o macarrão cozido.",
            cookTime = 20,
            servings = 2
        ),
        Recipe(
            name = "Sopa de Legumes",
            ingredients = listOf("batata", "cenoura", "cebola"),
            instructions = "Cozinhe todos os legumes em água com sal até ficarem macios. Sirva quente.",
            cookTime = 30,
            servings = 4
        ),
        Recipe(
            name = "Bolo de Chocolate",
            ingredients = listOf("farinha", "açúcar", "cacau", "ovo", "fermento", "leite"),
            instructions = "Misture todos os ingredientes, despeje em uma forma e leve ao forno a 180°C por 40 minutos.",
            cookTime = 40,
            servings = 8
        ),
        Recipe(
            name = "Salada Grega",
            ingredients = listOf("pepino", "tomate", "cebola", "azeitona", "queijo feta"),
            instructions = "Corte todos os ingredientes, misture e tempere com azeite e sal a gosto.",
            cookTime = 10,
            servings = 2
        ),
        Recipe(
            name = "Arroz de Carreteiro",
            ingredients = listOf("arroz", "carne seca", "cebola", "alho"),
            instructions = "Refogue a carne seca com cebola e alho, adicione o arroz e cozinhe até secar.",
            cookTime = 30,
            servings = 4
        ),
        Recipe(
            name = "Torta de Frango",
            ingredients = listOf("farinha", "manteiga", "frango desfiado", "requeijão"),
            instructions = "Prepare a massa com farinha e manteiga, recheie com frango desfiado e requeijão e asse por 40 minutos a 180°C.",
            cookTime = 50,
            servings = 6
        ),
        Recipe(
            name = "Brigadeiro",
            ingredients = listOf("leite condensado", "chocolate em pó", "manteiga"),
            instructions = "Misture tudo em fogo baixo até soltar da panela. Enrole e passe no granulado.",
            cookTime = 15,
            servings = 20
        ),
        Recipe(
            name = "Risoto de Cogumelos",
            ingredients = listOf("arroz arbóreo", "cogumelos", "caldo de legumes", "queijo parmesão", "manteiga"),
            instructions = "Cozinhe o arroz arbóreo com o caldo de legumes, adicione os cogumelos e finalize com manteiga e queijo parmesão.",
            cookTime = 25,
            servings = 4
        )
    )

    // Função para encontrar receitas compatíveis com os ingredientes disponíveis
    fun getRecipesWithIngredients(availableIngredients: List<String>): List<Recipe> {
        return recipes.filter { recipe ->
            // Verifica se todos os ingredientes da receita estão na lista de ingredientes disponíveis
            recipe.ingredients.all { it in availableIngredients }
        }
    }

    // Função para exibir uma receita completa, dados os ingredientes disponíveis
    fun showRecipeDetails(availableIngredients: List<String>): String {
        val matchingRecipes = getRecipesWithIngredients(availableIngredients)
        return if (matchingRecipes.isNotEmpty()) {
            // Monta a descrição detalhada da primeira receita encontrada
            val recipe = matchingRecipes[0]
            """
            Receita: ${recipe.name}
            Ingredientes: ${recipe.ingredients.joinToString(", ")}
            Instruções: ${recipe.instructions}
            Tempo de preparo: ${recipe.cookTime} minutos
            Porções: ${recipe.servings}
            """.trimIndent()
        } else {
            "Nenhuma receita encontrada com os ingredientes disponíveis."
        }
    }
}
