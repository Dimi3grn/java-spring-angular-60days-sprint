package com.example.demo.repository;

import com.example.demo.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
    Component findByName(String name);

    // J11 - EXERCICE 1 : requête JPQL custom
    // Objectif : trouver tous les composants dont le nom contient un mot-clé (insensible à la casse)
    // Syntaxe @Query : @Query("SELECT c FROM Component c WHERE ...")
    // Indice : LOWER() fonctionne en JPQL, LIKE '%:keyword%' ne marche pas — utilise CONCAT('%', :keyword, '%')
    // Indice : @Param("keyword") lie le paramètre de la méthode à :keyword dans la requête
    @Query("Select c from Component c where LOWER(c.name) LIKE concat('%',LOWER(:keyword),'%')")
    List<Component> searchByName(@Param("keyword") String keyword);

    // J11 - EXERCICE 2 : requête JPQL custom avec tri
    // Objectif : retourner tous les composants triés par nom alphabétique (A → Z)
    // Indice : ORDER BY en JPQL fonctionne comme en SQL
    @Query("Select c from Component c ORDER BY c.name")
    List<Component> findAllSortedByName();
}
