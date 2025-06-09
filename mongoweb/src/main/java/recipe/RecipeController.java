package recipe;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/recipe_servlet/*")
public class RecipeController extends HttpServlet {
	private RecipeDAO dao = new RecipeDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if ("list".equals(action) || action == null) {
	        request.setAttribute("recipes", dao.getAllRecipes());
	        request.getRequestDispatcher("/recipe/list.jsp").forward(request, response);
	    } else if ("view".equals(action)) {
	        String id = request.getParameter("id");
	        RecipeDTO recipe = dao.getRecipeById(id);
	        request.setAttribute("recipe", recipe);
	        request.getRequestDispatcher("/recipe/view.jsp").forward(request, response);
	    } else if ("edit".equals(action)) {
	        String id = request.getParameter("id");
	        RecipeDTO recipe = dao.getRecipeById(id);
	        request.setAttribute("recipe", recipe);
	        request.getRequestDispatcher("/recipe/form.jsp").forward(request, response);
	    } else if ("delete".equals(action)) {
	        dao.deleteRecipe(request.getParameter("id"));
	        response.sendRedirect(request.getContextPath() + "/recipe?action=list");
	    }
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RecipeDTO recipe = new RecipeDTO();
        recipe.setTitle(request.getParameter("title"));
        recipe.setIngredients(request.getParameter("ingredients"));
        recipe.setSteps(request.getParameter("steps"));

        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            dao.insertRecipe(recipe);
        } else {
            recipe.setId(request.getParameter("id"));
            dao.updateRecipe(recipe);
        }

        response.sendRedirect(request.getContextPath() + "/recipe_servlet?action=list");
    }
}
