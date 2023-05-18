package com.example.Tuan2.Controller;

import com.example.Tuan2.entity.Book;
import com.example.Tuan2.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;
import java.util.List;

public class productsController {
    @Autowired
    private List<Product> products;
    @GetMapping("")
    public String listProduct( Model model){
        model.addAttribute("products", products);
        model.addAttribute("title", "Product List");
        return "product/list";
    }@GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("product",new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product")Product product){
        products.add(product);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable("id")Long id, Model model){
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
    public String editBook(@ModelAttribute("product") Product updatedProduct){
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
