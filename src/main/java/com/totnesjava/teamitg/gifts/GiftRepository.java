package com.totnesjava.teamitg.gifts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftRepository extends JpaRepository<GiftEntity,String> {

}
