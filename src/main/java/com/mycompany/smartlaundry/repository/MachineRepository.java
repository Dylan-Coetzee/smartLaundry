/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartlaundry.repository;

import com.mycompany.smartlaundry.domain.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Khanya
 */
@Repository
public interface MachineRepository extends JpaRepository<Machine, Long>{
    
}
