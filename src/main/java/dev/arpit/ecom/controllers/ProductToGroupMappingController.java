package dev.arpit.ecom.controllers;

import dev.arpit.ecom.dtos.*;
import dev.arpit.ecom.exceptions.BaseException;
import dev.arpit.ecom.mappers.ProductToGroupMappingDTOs;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.services.IProductService;
import dev.arpit.ecom.services.IProductToGroupMappingService;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductToGroupMappingController implements IProductToGroupMappingController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductToGroupMappingService iProductToGroupMappingService;

    @Override
    @GetMapping(Endpoints.v1ProductsByIdRecommendations)
    public ResponseEntity<@NonNull ResponseDto<GenerateRecommendationsResponseDto>> generateRecommendations(@PathVariable Long productId) {
        ResponseDto<GenerateRecommendationsResponseDto> responseDto = new ResponseDto<>();

        try {
            Product product = iProductService.findById(productId);
            List<Product> recommendations = iProductToGroupMappingService.getRecommendations(product);
            responseDto.setData(ProductToGroupMappingDTOs.getGenerateRecommendationsResponseDto(recommendations));
            responseDto.setMeta(
                new MetaDataDto(
                    ResponseCode.ECOM_SUCCESS_200,
                    "Recommendations fetched successfully",
                    "Recommendations fetched successfully",
                    null,
                    null
                )
            );

            return ResponseEntity.ok(responseDto);
        } catch (BaseException e) {
            responseDto.setMeta(
                new MetaDataDto(
                    e.getCode(),
                    e.getMessage(),
                    e.getDisplayMessage(),
                    null,
                    null
                )
            );

          ResponseEntity.BodyBuilder bodyBuilder = ResponseEntity.badRequest();
          return bodyBuilder.body(responseDto);
        }
    }
}
