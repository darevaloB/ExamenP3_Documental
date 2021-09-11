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
package ec.edu.espe.distribuidas.examen.examendocumental.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Diana
 */
@Data
@Document(collection = "trama")
public class Trama {

    @Id
    private String id;
    private Integer retiro;
     private Integer montoRetiro;
    private Integer retironumerobilletesDiez;
    private Integer retironumerobilletesVeinte;
    private Integer rellenadoCajero;
    private String estado;

}
