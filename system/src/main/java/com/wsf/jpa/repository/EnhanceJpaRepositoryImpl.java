package com.wsf.jpa.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * open
 * SoulLose
 * 2022-05-11 19:35
 */
public class EnhanceJpaRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements EnhanceJpaRepository<T,ID> {
    private EntityManager em;
    private JPAQueryFactory queryFactory;
    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given {@link JpaEntityInformation}.
     *
     * @param entityInformation must not be {@literal null}.
     * @param entityManager     must not be {@literal null}.
     */
    public EnhanceJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
        this.queryFactory = new JPAQueryFactory(this.em);
    }
    
    /**
     * Creates a new {@link SimpleJpaRepository} to manage objects of the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     * @param entityManager          must not be {@literal null}.
     */
    public EnhanceJpaRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.em = entityManager;
        this.queryFactory = new JPAQueryFactory(this.em);
    }
    
    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }
    
    @Override
    public JPAQueryFactory getQueryFactory() {
        return this.queryFactory;
    }
    
    @Override
    public <M, N> M getReference(Class<M> clazz, N id) {
        return this.em.getReference(clazz, id);
    }
}
