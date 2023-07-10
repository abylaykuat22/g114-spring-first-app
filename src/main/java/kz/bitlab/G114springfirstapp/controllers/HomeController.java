package kz.bitlab.G114springfirstapp.controllers;

import kz.bitlab.G114springfirstapp.db.DBManager;
import kz.bitlab.G114springfirstapp.models.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

  @GetMapping("/") // @WebServlet(value = "/") + doGet()
  public String homePage(Model model) {
    model.addAttribute("items", DBManager.getItems()); // req.setAttribute("zat", item)
    return "home"; // req.getRequestDispatcher("home.jsp").forward(req, resp)
  }

  @PostMapping("/add-item")
  public String addItem(Item item) {
    DBManager.addItem(item);
    return "redirect:/"; //resp.sendRedirect("/")
  }
}
