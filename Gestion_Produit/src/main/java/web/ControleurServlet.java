package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IProduitDao;
import dao.ProduitDaoImplt;
import metier.entities.Produit;

@WebServlet(name = "cs", urlPatterns = { "*.php" })
public class ControleurServlet extends HttpServlet {
	private IProduitDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProduitDaoImplt();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.php")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		} else if (path.equals("/chercher.php")) {
			String motCle = request.getParameter("moCle");
			ProduitModel model = new ProduitModel();
			model.setMoCle(motCle);
			List<Produit> produits = metier.ProduitParMC("%" + motCle + "%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);

		} else if (path.equals("/Saisie.php")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);

		} else if (path.equals("/saveProduit.php") && (request.getMethod().equals("POST"))) {
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit p = metier.save(new Produit(des, prix, quantite));
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);

		}else if(path.equals("/Supprimie.php")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id); 
			//request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.php?moCle=");
		}else if(path.equals("/Edit.php")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit produit = metier.getProduit(id);
			request.setAttribute("produit",produit);
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
			
		}  else if (path.equals("/UpdateProduit.php") && (request.getMethod().equals("POST"))) {
			Long id = Long.parseLong(request.getParameter("id"));
			String des = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			Produit produit = new Produit(des,prix,quantite);
			produit.setId(id);
			metier.upDate(produit);
			request.setAttribute("produit",produit);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			
		}else {
			response.sendError(response.SC_BAD_REQUEST);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
