package it.network.models.servicies;

import it.network.models.dto.ProductDTO;
import it.network.data.entites.ProductEntity;
import it.network.data.repositories.ProductRepository;
import it.network.models.dto.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void create(ProductDTO product) {
        ProductEntity newProduct = productMapper.toEntity(product);

        productRepository.save(newProduct);
    }

    @Override
    public List<ProductDTO> getAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(i -> productMapper.toDTO(i))
                .toList();
    }

    @Override
    public ProductDTO getById(long productId) {
        ProductEntity fetchProduct = getProductOrThrow(productId);
        return productMapper.toDTO(fetchProduct);
    }

    @Override
    public void edit(ProductDTO product) {
        ProductEntity fetchedProduct = getProductOrThrow(product.getProductId());
        productMapper.updateProductEntity(product, fetchedProduct);
        productRepository.save(fetchedProduct);
    }

    @Override
    public void remove(long productId) {
        ProductEntity fetchedEntity = getProductOrThrow(productId);
        productRepository.delete(fetchedEntity);
    }

    private ProductEntity getProductOrThrow(long productId) {
        return productRepository.findById(productId).orElseThrow();
    }


}
