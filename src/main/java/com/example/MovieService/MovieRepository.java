package com.example.MovieService;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Long> {
//    @Query("SELECT m FROM Movie m WHERE m.id=?1")
//    Optional<Movie> findById(Long id);

    @Modifying
    @Transactional
    @Query("update Movie m set m.isAvailable = :isAvailable where m.id = :id")
    void setAvailability(@Param("id") Long id, @Param("isAvailable") boolean isAvailable);
}
