package com.github.ManoloCosano72.model.interfaces;

import java.io.Closeable;
import java.sql.SQLException;

public interface DAO<T, K> extends Closeable {
    T save(T entity);
    T delete(T entity) throws SQLException;
    T findByDni(K key);
}
