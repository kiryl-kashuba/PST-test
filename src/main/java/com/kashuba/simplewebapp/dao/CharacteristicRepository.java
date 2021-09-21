package com.kashuba.simplewebapp.dao;

import com.kashuba.simplewebapp.entity.Characteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Long> {

}

