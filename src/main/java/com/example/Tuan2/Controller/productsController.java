package com.example.Tuan2.Controller;

//import com.example.Tuan2.entity.Book;
import com.example.Tuan2.entity.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/products")
public class productsController {
    @Autowired
    private List<Product> products;
    @GetMapping("")
    public String listProducts( Model model){
        model.addAttribute("products", products);
        model.addAttribute("title", "Product List");
        return "product/list";
    }@GetMapping("/add")
    public String addProductForm(Model model){
        model.addAttribute("product",new Product());
        return "product/add";
    }

//    @PostMapping("/add")
//    public String addProduct(@ModelAttribute("product")Product product, @Valid Product newProduct, BindingResult result){
//        if (result.hasErrors()) {
//            return "products/add";
//        }
//        products.add(product);
//        return "redirect:/products";
//    }

    @PostMapping("/add")
    public String addProduct(@Valid Product newProduct, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            return "products/add";
        }
        products.add(newProduct);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable("id")Long id, Model model){
        Product editProduct = null;
        for (Product product : products){
//            if (product.getId().equals(id)){
//                editProduct = product;
//            }
        }
        if (editProduct != null){
            model.addAttribute("product", editProduct);
            return "book/edit";
        }
        else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product updatedProduct){
        for (int i=0; i < products.size(); i++){
            Product product = products.get(i);
            if (product.getId() == updatedProduct.getId()){
                products.set(i,updatedProduct);
                break;
            }
        }
        return "redirect:/products";
    }



    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")Long id){
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if(product.getId() == id){
                iterator.remove();
                break;
            }
        }
        return "redirect:/products";
    }
}
