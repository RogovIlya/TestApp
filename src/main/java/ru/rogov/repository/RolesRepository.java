package ru.rogov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.rogov.entity.Role;

public interface RolesRepository extends JpaRepository<Role, Long>
{

}
