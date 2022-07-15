package com.kapil.chhotaURL.Repository;


import com.kapil.chhotaURL.Entity.ChhotaUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChhotaUrlRepository extends JpaRepository<ChhotaUrlEntity, String> {

    boolean existsByHashCode(String hashCode);

    ChhotaUrlEntity findByHashCode(String hashCode);

    ChhotaUrlEntity save(ChhotaUrlEntity chhotaUrlEntity);

}
