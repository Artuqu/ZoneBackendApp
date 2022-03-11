package pl.zone.ZoneBackendApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zone.ZoneBackendApp.entity.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {


}
