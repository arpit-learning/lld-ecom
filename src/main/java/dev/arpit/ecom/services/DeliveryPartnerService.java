package dev.arpit.ecom.services;

import dev.arpit.ecom.models.DeliveryPartner;
import dev.arpit.ecom.repositories.DeliveryPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPartnerService implements IDeliveryPartnerService {
  @Autowired
  private DeliveryPartnerRepository deliveryPartnerRepository;

  @Override
  public List<DeliveryPartner> findAllById(List<Long> partnerIds) {
    return deliveryPartnerRepository.findAllById(partnerIds);
  }
}
