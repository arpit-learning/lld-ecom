package dev.arpit.ecom.adapters;

import dev.arpit.ecom.models.Location;

import java.util.List;

public interface MapsAdapter {
  List<Location> buildRoute(List<Location> locations);
}
