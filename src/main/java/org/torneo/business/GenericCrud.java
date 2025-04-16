package org.torneo.business;

import java.util.List;

public interface GenericCrud<E, T> {
    public E findById(T id);
    public List<E> findAll();
    public int insertOne(E entity);
    public int updateOne(E entity);
    public int deleteOne(T id);
}
