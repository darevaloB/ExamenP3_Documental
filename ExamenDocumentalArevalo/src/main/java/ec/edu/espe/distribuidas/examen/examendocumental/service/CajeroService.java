/*
 * Copyright (c) 2021 Diana.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Diana - initial API and implementation and/or initial documentation
 */
package ec.edu.espe.distribuidas.examen.examendocumental.service;

import ec.edu.espe.distribuidas.examen.examendocumental.dao.CajeroRepository;
import ec.edu.espe.distribuidas.examen.examendocumental.exception.CreateException;
import ec.edu.espe.distribuidas.examen.examendocumental.model.Cajero;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diana
 */
@Service
@Slf4j
public class CajeroService {
     private final CajeroRepository cajeroRepo;

    public CajeroService(CajeroRepository cajeroRepo) {
        this.cajeroRepo = cajeroRepo;
    }
      public List<Cajero> getBymonto(Integer monto) {
        return this.cajeroRepo.findByMontoLessThan(monto);
    }
      
      public Cajero getByCodigo(String codigo) {
        Cajero cajero = this.cajeroRepo.findByCodigo(codigo);
        if (codigo == null) {
            throw new CreateException("Cliente no encontrado con ese número de identificación");
        }
        return cajero;
    }
     
      
}
