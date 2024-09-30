package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E extends Base, Id extends Serializable> implements BaseService<E, Id> {
    protected BaseRepository<E,Id> baseRepository;

    public BaseServiceImpl(BaseRepository<E,Id> baseRepository){
        this.baseRepository = baseRepository;
    }
    @Override
    @Transactional
    public List<E> findAll() throws Exception {
        try{
            List<E> entities = baseRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Page<E> findAll(Pageable pageable) throws Exception{
        try{
            Page<E> entities = baseRepository.findAll(pageable);
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }


    @Override
    @Transactional
    public E findById(Id id) throws Exception {
        try{
            Optional<E> entityFoundById = baseRepository.findById(id);
            return entityFoundById.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public E save(E entity) throws Exception {
        try{
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public E update(Id id, E entity) throws Exception {
        try{
            Optional<E> entityToUpdate = baseRepository.findById(id);
            E entityUpdated = entityToUpdate.get();
            entityUpdated = baseRepository.save(entity);
            return entityUpdated;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Id id) throws Exception {
        try{
            if(baseRepository.existsById(id)){
                baseRepository.deleteById((id));
                return  true;
            }else{
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }
}
