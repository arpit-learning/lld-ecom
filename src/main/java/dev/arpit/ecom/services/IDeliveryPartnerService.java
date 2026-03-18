package dev.arpit.ecom.services;

import dev.arpit.ecom.models.DeliveryPartner;

import java.util.List;

public interface IDeliveryPartnerService {
  List<DeliveryPartner> findAllById(List<Long> partnerIds);
}
