package ua.lviv.cinema.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.lviv.cinema.entity.Address;


public interface AddressDao extends JpaRepository<Address, Integer> {

}
