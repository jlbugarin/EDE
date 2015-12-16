/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.iluminatic.session.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pe.iluminatic.dao.entidades.EdemCompetencia;

/**
 *
 * @author JBugarinP
 */
@Stateless
public class EdemCompetenciaFacade extends AbstractFacade<EdemCompetencia> {
    @PersistenceContext(unitName = "EDEPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdemCompetenciaFacade() {
        super(EdemCompetencia.class);
    }
    
}
