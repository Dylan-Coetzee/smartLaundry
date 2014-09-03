/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.smartlaundry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Khanya
 */
public interface CustomerOrder extends JpaRepository<CustomerOrder, Long> {
    
}
