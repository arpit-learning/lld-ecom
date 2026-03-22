package dev.arpit.ecom.services;

import dev.arpit.ecom.models.HighDemandProduct;
import dev.arpit.ecom.models.Product;
import dev.arpit.ecom.repositories.HighDemandProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HighDemandProductService implements IHighDemandProductService {
    @Autowired
    private HighDemandProductRepository highDemandProductRepository;

    @Override
    public HighDemandProduct findByProduct(Product product) {
        return highDemandProductRepository.findByProduct(product).orElse(null);
    }
}
