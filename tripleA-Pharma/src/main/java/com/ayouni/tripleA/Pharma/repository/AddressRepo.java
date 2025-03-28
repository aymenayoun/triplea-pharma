package com.ayouni.tripleA.Pharma.repository;
import com.ayouni.tripleA.Pharma.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AddressRepo extends JpaRepository<Address, Long> {
}
