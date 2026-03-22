package dev.arpit.ecom.services;

import dev.arpit.ecom.models.Notification;
import dev.arpit.ecom.models.Product;

import java.util.List;

public interface INotificationService {
  List<Notification> sendNotifications (Product product);
}
