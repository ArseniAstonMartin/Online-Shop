package com.example.demo.controllers;

import com.example.demo.entiteas.Image;
import com.example.demo.entiteas.MyUser;
import com.example.demo.entiteas.Product;
import com.example.demo.errors.NoPreviewImageException;
import com.example.demo.services.CSRUserService;
import com.example.demo.services.ProductService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.PostExchange;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CSRUserService userService;

    @GetMapping("/product/search")
    public String searchByTitle(String title, Model model) {
        model.addAttribute("products", productService.findByTitleContainingIgnoreCase(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    @Transactional
    public String productInf(@PathVariable long id, Model model, Principal principal) {
        Product prod = productService.findById(id);
        List<Image> iml = prod.getImageList();
        model.addAttribute("product", prod);
        model.addAttribute("preview", iml.get(0));
        model.addAttribute("images", iml.subList(1, iml.size()));
        return "info";
    }

    @PostMapping("/product/create")
    public String createProduct(Product product, @RequestParam("preview") MultipartFile image1,
                                @RequestParam("image0") MultipartFile image2, @RequestParam("image1") MultipartFile image3, Principal principal) {

        try {
            productService.save(principal, product, image1, image2, image3);
        } catch (NoPreviewImageException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    /*@PreAuthorize("productService.findById(#id).user == userService.findByUsername(#principal.name)")*/
    @PostMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id, Principal principal) {

        productService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/product/update/{id}")
    public String updateProduct(@PathVariable long id, Model model, Principal principal) {
        Product pr = productService.findById(id);
        model.addAttribute("product", pr);
        return "update";
    }

    @PostMapping("/product/update/{id}")
    public String saveUpdates(@PathVariable long id, Product product, @RequestParam("preview") MultipartFile image1,
                              @RequestParam("image0") MultipartFile image2, @RequestParam("image1") MultipartFile image3, Principal principal) {

        try {
            productService.save(principal, product, image1, image2, image3);
        } catch (NoPreviewImageException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return "redirect:/";
    }
}
