package com.wsf.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public interface EnhanceJpaRepository<T, ID> extends JpaRepository<T, ID> {
    EntityManager getEntityManager();
    
    JPAQueryFactory getQueryFactory();
    
    <M, N> M getReference(Class<M> clazz, N id);
}
