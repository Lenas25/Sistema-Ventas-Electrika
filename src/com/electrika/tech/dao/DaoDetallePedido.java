
package com.electrika.tech.dao;

import com.electrika.tech.entidades.DetallePedido;
import java.util.List;

public interface DaoDetallePedido extends DaoInterface<DetallePedido, Integer>{
    String actualizarPedido( Integer idDeta);
    List<DetallePedido> seleccionarMemoria();
    void eliminarMemoria();
}
