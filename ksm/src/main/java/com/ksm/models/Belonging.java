/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ksm.models;

import lombok.Data;

/**
 *
 * @author Qeisarcom
 */
@Data
public class Belonging {
    private Integer id;
    private String name;
    private Integer quantity;
    private Person person;

    public Belonging() {
    }
 
}
