package com.dylut2000.server.repository;

import com.dylut2000.server.model.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID> {

    List<Todo> findAllByUserId(UUID userId);

}
