package com.first.board.buser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // DAO역할을 하는 클래스, 인터페이스 지정
public interface BuserRepository extends JpaRepository<Buser, Integer> {
    // 커스텀 JPQL(SQL과 달리 엔티티 클래스 기반으로 쿼리 작업) 쿼리를 메소드에 직접 지정
    @Query("SELECT u FROM Buser u WHERE u.id = ?1")
    Optional<Buser> findBuserById(Integer id);

    @Query("SELECT u FROM Buser u WHERE u.email = ?1")
    Optional<Buser> findBuserByEmail(String email);
}
