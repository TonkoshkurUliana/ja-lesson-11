package service.impl;

import dao.BucketDao;
import dao.impl.BucketDaoImpl;
import domain.Bucket;
import org.apache.log4j.Logger;
import service.BucketService;


import java.sql.SQLException;
import java.util.List;

public class BucketServiceImpl implements BucketService {
    private BucketDao bucketDao;
    private static final Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
    private static BucketServiceImpl bucketServiceImpl ;


    public BucketServiceImpl() {
        try {
            bucketDao = new BucketDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static BucketService getBucketServiceImpl() {;
        if (bucketServiceImpl == null) {
            bucketServiceImpl = new BucketServiceImpl();
        }
        return bucketServiceImpl;
    }

    @Override
    public Bucket create(Bucket bucket) {
        return bucketDao.create(bucket);
    }

    @Override
    public Bucket read(Integer id) {
        return bucketDao.read(id);
    }

    @Override
    public Bucket update(Bucket bucket) {
        return bucketDao.update(bucket);
    }

    @Override
    public void delete(Integer id) {
    bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }
    @Override
    public List<Bucket> readAllId(Integer idUser) {
        return bucketDao.readAllId(idUser);
    }
}
