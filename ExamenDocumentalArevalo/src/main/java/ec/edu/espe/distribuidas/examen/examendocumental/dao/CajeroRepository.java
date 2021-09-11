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
package ec.edu.espe.distribuidas.examen.examendocumental.dao;

import ec.edu.espe.distribuidas.examen.examendocumental.model.Cajero;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Diana
 */
public interface CajeroRepository extends MongoRepository<Cajero, String>{
       List<Cajero> findByMontoLessThan(Integer monto);
       Cajero findByCodigo(String codigo);
}
