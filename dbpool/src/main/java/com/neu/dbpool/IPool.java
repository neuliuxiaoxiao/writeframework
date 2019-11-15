package com.neu.dbpool;

public interface IPool {
    public PooledConnection getPooledConnection();
    public void createPooledConnection(int count);
}
