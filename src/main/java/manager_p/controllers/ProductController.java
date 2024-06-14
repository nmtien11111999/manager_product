package manager_p.controllers;

import manager_p.models.Product;
import manager_p.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value ="/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value ="/list")
    public String productList(ModelMap modelMap) {
        modelMap.addAttribute("products", productService.findAll());
        return "list";
    }

    @GetMapping(value = "/detail/{id}")
    public String productDetail(@PathVariable int id , ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @GetMapping(value = "/create")
    public String productCreate(ModelMap modelMap) {
        modelMap.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/create")
    public String pCreate(@ModelAttribute Product product){
        productService.create(product);
        return "redirect:/admin/list";
    }

    @GetMapping(value = "/edit/{id}")
    public String productEdit(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/edit/{id}")
    public String pEdit(@PathVariable int id , @ModelAttribute Product product) {
        productService.edit(id, product);
        return "redirect:/admin/list";
    }

    @PostMapping(value = "/delete/{id}")
    public String pDelete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/admin/list";
    }

    @GetMapping(value = "/search")
    public String productSearch(@RequestParam String name, ModelMap modelMap) {
        modelMap.addAttribute("products", productService.findProductByName(name));
        return "list";
    }
}
