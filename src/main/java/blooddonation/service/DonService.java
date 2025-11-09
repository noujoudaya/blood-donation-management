package blooddonation.service;

import blooddonation.bean.Don;
import java.util.List;

public interface DonService {

    Don save(Don don);

    Don update(Don don);

    boolean delete(Long id);

    Don findById(Long id);

    List<Don> findAll();
}
