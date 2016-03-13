package ru.rogov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.rogov.entity.Rights;

public interface RightsRepository extends JpaRepository<Rights, Long>
{

}
