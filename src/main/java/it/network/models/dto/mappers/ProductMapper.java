package it.network.models.dto.mappers;

import it.network.data.entites.ProductEntity;
import it.network.models.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(ProductDTO source);
    ProductDTO toDTO(ProductEntity source);

    void updateProductDTO(ProductDTO source, @MappingTarget ProductDTO target);
    void updateProductEntity(ProductDTO source, @MappingTarget ProductEntity target);
}
