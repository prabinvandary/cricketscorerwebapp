/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.repository.generic;

import java.util.List;

/**
 *
 * @author prabin
 * @param <T>
 * @param <ID>
 */
public interface GenericRepositoryInterface<T, ID> {

    Boolean saveData(T t);

    Boolean saveAllData(List<T> t);

    List<T> getAllData();

    T getById(Long id);

    Boolean deleteById(ID id);

}
