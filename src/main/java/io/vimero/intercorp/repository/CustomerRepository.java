package io.vimero.intercorp.repository;

import io.vimero.intercorp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rony Villanueva <rony@vimero.io>
 * @since 15/12/2019
 */

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
