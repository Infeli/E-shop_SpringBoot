package it.network.controllers;

import it.network.models.dto.ProductDTO;
import it.network.models.dto.mappers.ProductMapper;
import it.network.models.servicies.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @GetMapping
    public String renderIndex(Model model) {
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        return "pages/products/index";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute ProductDTO product) {
        return "pages/products/create";
    }

    @PostMapping("create")
    private String createProduct(@Valid @ModelAttribute ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return renderCreateForm(product);
        }
        productService.create(product);
        return "redirect:/products";
    }

    @GetMapping("{productId}")
    public String renderDetail(@PathVariable long productId, Model model) {
        ProductDTO product = productService.getById(productId);
        model.addAttribute("product", product);
        return "pages/products/detail";
    }

    @GetMapping("edit/{productId}")
    public String renderEditForm(@PathVariable Long productId, ProductDTO product) {
        ProductDTO fetchedProduct = productService.getById(productId);
        productMapper.updateProductDTO(fetchedProduct, product);
        return "pages/products/edit";
    }

    @PostMapping("edit/{productId}")
    public String editProduct(@PathVariable long productId, @Valid ProductDTO product, BindingResult result) {
        if (result.hasErrors()) {
            return renderEditForm(productId, product);
        }
        product.setProductId(productId);
        productService.edit(product);
        return "redirect:/products";
    }

    @GetMapping("delete/{productId}")
    public String deleteProduct(@PathVariable long productId) {
        productService.remove(productId);
        return "redirect:/products";
    }

}
