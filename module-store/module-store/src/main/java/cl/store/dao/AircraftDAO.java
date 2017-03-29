package com.mxi.maintsuite.dao;

import com.mxi.maintsuite.to.Aircraft;

import java.util.List;

/**
 * Created by millanes on 20-03-17.
 */

public interface AircraftDAO {

    Aircraft get(final String tail);

    List<Aircraft> findAll();

    boolean insertAircraft(Aircraft aircraft);
    boolean updateAircraft(Aircraft aircraft);
}