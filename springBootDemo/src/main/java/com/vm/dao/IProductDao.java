package com.vm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.entity.Product;

@Repository   //it creates bean     
public interface IProductDao extends JpaRepository<Product,Integer>
{

}
