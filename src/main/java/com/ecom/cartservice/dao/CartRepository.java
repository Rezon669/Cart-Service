package com.ecom.cartservice.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecom.cartservice.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("SELECT productid FROM Cart c WHERE c.userid=:userid")
	 Optional<Integer> findProducts(long userid);
	// Additional custom queries can be added here if needed

	@Query("SELECT c.productid FROM Cart c WHERE c.userid = :userid")
	List<Long> findProductIdsByUserId(Long userid);

}
