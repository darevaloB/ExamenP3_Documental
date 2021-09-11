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
package ec.edu.espe.distribuidas.examen.examendocumental.controller;

import ec.edu.espe.distribuidas.examen.examendocumental.dto.GenericDetailSerializer;
import ec.edu.espe.distribuidas.examen.examendocumental.model.Cajero;
import ec.edu.espe.distribuidas.examen.examendocumental.service.CajeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Diana
 */
@Slf4j
@RestController
@RequestMapping("/api/cajero")
public class CajeroController {

    private final CajeroService service;

    public CajeroController(CajeroService service) {
        this.service = service;
    }

    @GetMapping(value = "{monto}")
    @ApiOperation(value = "Obtiene los cajeros dependiento del monto ingresado", notes = "Obtiene todos los cajeros que tienen menos del monto ingresado  ")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK,todos los cajeros que tienen menos del monto ingresado "),
        @ApiResponse(code = 404, message = "No existen cajeros que tienen menos del monto ingresado ")
    })
    public ResponseEntity getByEstadoBancaWeb(@PathVariable("monto") Integer monto) {
        String errorMessage = "Error de Busqueda.";
        try {
            List<Cajero> cajeros = this.service.getBymonto(monto);
            return ResponseEntity.ok(cajeros);
        } catch (Exception e) {
            GenericDetailSerializer errorResponse;
            errorResponse = new GenericDetailSerializer(
                    errorMessage, e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping(value = "{codigo}")
    @ApiOperation(value = "Obtiene la informacion de un cajero", notes = "Obtiene la informacion del monto y de las demonicaciones del cajero")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "OK, Cuando encuentra la informacion del monto y de las demonicaciones del cajero"),
        @ApiResponse(code = 404, message = "No encuentra la informacion del monto y de las demonicaciones del cajero")
    })
    public ResponseEntity getCajero(@PathVariable("codigo") String codigo) {
        String errorMessage = "Error de Busqueda.";
        try {
            Cajero cajero = this.service.getByCodigo(codigo);
            return ResponseEntity.ok(cajero);
        } catch (Exception e) {
            GenericDetailSerializer errorResponse;
            errorResponse = new GenericDetailSerializer(
                    errorMessage, e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

}
