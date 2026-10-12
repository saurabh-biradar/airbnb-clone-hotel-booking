package io.github.saurabhbiradar.airbnbclone.repository;

import io.github.saurabhbiradar.airbnbclone.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
