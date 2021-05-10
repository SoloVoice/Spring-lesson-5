package ru.geekbrains.boot.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.boot.servises.ProductsService;

@Controller
@RequiredArgsConstructor
public class ProductController {
    public final ProductsService productService;

    @GetMapping("/prod_list")
    public String getAllProducts(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        return "products_list";
    }

    @GetMapping("/add_prod")
    public String addProduct(@RequestParam(name = "product_id") long id, @RequestParam(name = "name") String name, @RequestParam(name = "cost") long cost) {
        productService.addProductToBD(id, name, cost);
        return "redirect:/prod_list";
    }

    @GetMapping("/delete_prod/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "redirect:/prod_list";
    }

}
