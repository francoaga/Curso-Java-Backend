package com.educacionit.limpiezait.mapper.interfaces;

public interface IMapper <D,E>{
    E toEntity(D dto);
    D toDTO(E entity);
}
