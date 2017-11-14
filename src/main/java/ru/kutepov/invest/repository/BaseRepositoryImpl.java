package ru.kutepov.invest.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Transactional(readOnly = true)
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepositoryCustom<T, ID> {

  @NotNull
  private final EntityManager entityManager;

  public BaseRepositoryImpl(@NotNull JpaEntityInformation<T, ?> entityInformation, @NotNull EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
  }

}
