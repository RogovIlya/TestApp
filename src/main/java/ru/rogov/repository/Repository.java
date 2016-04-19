package ru.rogov.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repository<T, S extends Serializable> extends JpaRepository<T, S>
{
	
}
