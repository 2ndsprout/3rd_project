package com._ndsprout.Education_platform.Repository;

import com._ndsprout.Education_platform.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
