package Back_Articulo_Manufacturado.demo.repositories;


import Back_Articulo_Manufacturado.demo.domain.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SucursalRepository extends BaseRepository<Sucursal,Long> {
    @Query("SELECT s FROM Sucursal s LEFT JOIN FETCH s.promociones WHERE s.id = :id")
    Sucursal findWithPromocionesById(@Param("id") Long id);

    @Query("SELECT s FROM Sucursal s LEFT JOIN FETCH s.empleados WHERE s.id = :id")
    Sucursal findWithEmpleadosById(@Param("id") Long id);

    @Query("SELECT s FROM Sucursal s LEFT JOIN FETCH s.categorias WHERE s.id = :id")
    Sucursal findWithCategoriasById(@Param("id") Long id);
}
