package service.impl;

import dao.MagazineDao;

import dao.impl.MagazineDaoImpl;
import domain.Magazine;
import org.apache.log4j.Logger;
import service.MagazineService;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MagazineServiceImpl implements MagazineService {
    private MagazineDao magazineDao;
    private static final Logger LOGGER = Logger.getLogger(MagazineServiceImpl.class);
    private static MagazineServiceImpl magazineServiceImpl;

    public MagazineServiceImpl() {
        try {
            magazineDao = new MagazineDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public static MagazineService getMagazineServiceImpl() {;
        if (magazineServiceImpl == null) {
            magazineServiceImpl = new MagazineServiceImpl();
        }

        return magazineServiceImpl;
    }
    @Override
    public Magazine create(Magazine magazine) {
        return magazineDao.create(magazine);
    }

    @Override
    public Magazine read(Integer id) {
        return magazineDao.read(id);
    }

    @Override
    public Magazine update(Magazine magazine) {
        return magazineDao.update(magazine);
    }

    @Override
    public void delete(Integer id) {
         magazineDao.delete(id);
    }

    @Override
    public List<Magazine> readAll() {
        return magazineDao.readAll();
    }

    @Override
    public List<Magazine> readAllId(Integer id) {
        return null;
    }

    @Override
    public Map<Integer, Magazine> readAllMap() {
        return  readAll().stream().collect(Collectors.toMap(Magazine::getId, Function.identity()));
    }
}
