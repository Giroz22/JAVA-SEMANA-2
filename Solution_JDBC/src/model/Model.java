package model;

import java.util.List;
import java.util.Objects;

public interface Model {
    public List<Object> findAll();
    public Object findById(int id);
    public Object save(Object obj);
    public Object update(int id, Object obj);
    public boolean delete(int id);
}
