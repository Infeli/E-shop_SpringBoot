package it.network.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    @NotBlank(message = "Vyplňte název")
    @NotNull(message = "Vyplňte název")
    @Size(max = 100, message = "Název je příliš dlouhý")
    private String title; // název

    @NotBlank(message = "Vyplňte popisek")
    @NotNull(message = "Vyplňte popisek")
    private String description;

    @NotNull(message = "Vyplňte cenu")
    private int price;

    private long productId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
