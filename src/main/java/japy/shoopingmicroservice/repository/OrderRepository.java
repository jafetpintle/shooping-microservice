package japy.shoopingmicroservice.repository;


import japy.shoopingmicroservice.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
