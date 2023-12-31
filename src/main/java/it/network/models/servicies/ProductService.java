package it.network.models.servicies;

import it.network.models.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    void create(ProductDTO product);
    List<ProductDTO> getAll();
    ProductDTO getById(long productId);
    void edit(ProductDTO product);
    void remove(long productId);
}
