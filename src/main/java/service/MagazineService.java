package service;

import domain.Magazine;
import shared.AbstractCRUD;

import java.util.Map;

public interface MagazineService extends AbstractCRUD<Magazine> {
    public Map<Integer, Magazine> readAllMap();
}
